package com.lark.oapi.scene.registration;

import com.google.gson.JsonParseException;
import com.lark.oapi.core.utils.Jsons;
import com.lark.oapi.core.utils.Strings;
import com.lark.oapi.okhttp.FormBody;
import com.lark.oapi.okhttp.HttpUrl;
import com.lark.oapi.okhttp.OkHttpClient;
import com.lark.oapi.okhttp.Request;
import com.lark.oapi.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

public final class RegisterApp {
    private static final String SDK_NAME = "java-sdk";
    private static final String DEFAULT_FEISHU_DOMAIN = "https://accounts.feishu.cn";
    private static final String DEFAULT_LARK_DOMAIN = "https://accounts.larksuite.com";
    private static final String ENDPOINT = "/oauth/v1/app/registration";
    private static final String ACTION_BEGIN = "begin";
    private static final String ACTION_POLL = "poll";
    private static final String ARCHETYPE = "PersonalAgent";
    private static final String AUTH_METHOD = "client_secret";
    private static final String REQUEST_USER_INFO = "open_id";
    private static final String ERROR_ABORT = "abort";
    private static final String ERROR_ACCESS_DENIED = "access_denied";
    private static final String ERROR_EXPIRED_TOKEN = "expired_token";
    private static final String ERROR_INVALID_ARGUMENT = "invalid_argument";
    private static final String ERROR_INVALID_RESPONSE = "invalid_response";
    private static final String ERROR_NETWORK = "network_error";
    private static final int DEFAULT_INTERVAL_SECONDS = 5;
    private static final int DEFAULT_EXPIRE_SECONDS = 600;

    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build();

    private RegisterApp() {
    }

    public static RegisterAppResult register(RegisterAppOptions opts) throws RegisterAppException {
        throwIfInterrupted();

        if (opts == null) {
            throw new RegisterAppException(ERROR_INVALID_ARGUMENT, "options is required");
        }
        if (opts.getOnQRCode() == null) {
            throw new RegisterAppException(ERROR_INVALID_ARGUMENT, "onQRCode is required");
        }

        String domain = Strings.isEmpty(opts.getDomain()) ? DEFAULT_FEISHU_DOMAIN : opts.getDomain();
        String larkDomain = Strings.isEmpty(opts.getLarkDomain()) ? DEFAULT_LARK_DOMAIN : opts.getLarkDomain();

        BeginResponse beginResponse = doRegistrationRequest(domain, buildBeginRequest(), BeginResponse.class);
        if (beginResponse == null
                || Strings.isEmpty(beginResponse.device_code)
                || Strings.isEmpty(beginResponse.verification_uri_complete)) {
            throw new RegisterAppException(ERROR_INVALID_RESPONSE, "missing device code or verification url");
        }

        int intervalSeconds = beginResponse.interval > 0 ? beginResponse.interval : DEFAULT_INTERVAL_SECONDS;
        int expireSeconds = beginResponse.expire_in > 0 ? beginResponse.expire_in : DEFAULT_EXPIRE_SECONDS;
        String qrCodeUrl = buildQRCodeUrl(beginResponse.verification_uri_complete, opts.getSource());

        opts.getOnQRCode().accept(new QRCodeInfo(qrCodeUrl, expireSeconds));

        long deadline = System.currentTimeMillis() + expireSeconds * 1000L;
        String currentDomain = domain;
        boolean domainSwitched = false;
        boolean waitBeforePoll = false;

        while (true) {
            throwIfInterrupted();
            ensureNotExpired(deadline);

            if (waitBeforePoll) {
                sleepInterruptibly(intervalSeconds);
                ensureNotExpired(deadline);
            }

            PollResponse pollResponse = doRegistrationRequest(
                    currentDomain,
                    buildPollRequest(beginResponse.device_code),
                    PollResponse.class
            );

            if (!domainSwitched
                    && pollResponse != null
                    && pollResponse.user_info != null
                    && "lark".equals(pollResponse.user_info.tenant_brand)) {
                currentDomain = larkDomain;
                domainSwitched = true;
                notifyStatus(opts.getOnStatusChange(), new StatusChangeInfo(StatusChangeInfo.DOMAIN_SWITCHED));
                waitBeforePoll = false;
                continue;
            }

            if (pollResponse != null
                    && Strings.isNotEmpty(pollResponse.client_id)
                    && Strings.isNotEmpty(pollResponse.client_secret)) {
                return new RegisterAppResult(
                        pollResponse.client_id,
                        pollResponse.client_secret,
                        toUserInfo(pollResponse.user_info)
                );
            }

            if (pollResponse == null) {
                throw new RegisterAppException(ERROR_INVALID_RESPONSE, "empty poll response");
            }

            if (Strings.isEmpty(pollResponse.error)) {
                throw new RegisterAppException(ERROR_INVALID_RESPONSE, "missing client credentials");
            }

            String description = Strings.isEmpty(pollResponse.error_description)
                    ? "Unknown error"
                    : pollResponse.error_description;

            switch (pollResponse.error) {
                case "authorization_pending":
                    notifyStatus(opts.getOnStatusChange(), new StatusChangeInfo(StatusChangeInfo.POLLING));
                    waitBeforePoll = true;
                    break;
                case "slow_down":
                    intervalSeconds += 5;
                    notifyStatus(opts.getOnStatusChange(),
                            new StatusChangeInfo(StatusChangeInfo.SLOW_DOWN, intervalSeconds));
                    waitBeforePoll = true;
                    break;
                case ERROR_ACCESS_DENIED:
                    throw new AccessDeniedException(pollResponse.error, description);
                case ERROR_EXPIRED_TOKEN:
                    throw new ExpiredException(pollResponse.error, description);
                default:
                    throw new RegisterAppException(pollResponse.error, description);
            }
        }
    }

    private static FormBody buildBeginRequest() {
        return new FormBody.Builder()
                .add("action", ACTION_BEGIN)
                .add("archetype", ARCHETYPE)
                .add("auth_method", AUTH_METHOD)
                .add("request_user_info", REQUEST_USER_INFO)
                .build();
    }

    private static FormBody buildPollRequest(String deviceCode) {
        return new FormBody.Builder()
                .add("action", ACTION_POLL)
                .add("device_code", deviceCode)
                .build();
    }

    private static String buildQRCodeUrl(String verificationUriComplete, String source) throws RegisterAppException {
        try {
            HttpUrl.Builder builder = HttpUrl.get(verificationUriComplete).newBuilder();
            builder.setQueryParameter("from", "sdk");
            builder.setQueryParameter("source", Strings.isEmpty(source) ? SDK_NAME : SDK_NAME + "/" + source);
            builder.setQueryParameter("tp", "sdk");
            return builder.build().toString();
        } catch (IllegalArgumentException e) {
            throw new RegisterAppException(ERROR_INVALID_RESPONSE, "invalid verification url");
        }
    }

    private static void notifyStatus(Consumer<StatusChangeInfo> callback, StatusChangeInfo info) {
        if (callback != null) {
            callback.accept(info);
        }
    }

    private static UserInfo toUserInfo(PollUserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        return new UserInfo(userInfo.open_id, userInfo.tenant_brand);
    }

    private static void ensureNotExpired(long deadline) throws ExpiredException {
        if (System.currentTimeMillis() >= deadline) {
            throw new ExpiredException(ERROR_EXPIRED_TOKEN, "Polling timed out");
        }
    }

    private static void sleepInterruptibly(int intervalSeconds) throws RegisterAppException {
        try {
            Thread.sleep(intervalSeconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw abortException();
        }
    }

    private static void throwIfInterrupted() throws RegisterAppException {
        if (Thread.currentThread().isInterrupted()) {
            throw abortException();
        }
    }

    private static RegisterAppException abortException() {
        return new RegisterAppException(ERROR_ABORT, "Registration was aborted");
    }

    private static <T> T doRegistrationRequest(String domain, FormBody body, Class<T> respClass)
            throws RegisterAppException {
        throwIfInterrupted();

        Request request;
        try {
            request = new Request.Builder()
                    .url(domain + ENDPOINT)
                    .post(body)
                    .build();
        } catch (IllegalArgumentException e) {
            throw new RegisterAppException(ERROR_INVALID_ARGUMENT, "invalid domain url");
        }

        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.body() == null) {
                throw new RegisterAppException(ERROR_INVALID_RESPONSE, "empty response body");
            }
            String responseBody = response.body().string();
            return Jsons.DEFAULT.fromJson(responseBody, respClass);
        } catch (JsonParseException e) {
            throw new RegisterAppException(ERROR_INVALID_RESPONSE, "invalid response json");
        } catch (IOException e) {
            if (Thread.currentThread().isInterrupted()) {
                throw abortException();
            }
            throw new RegisterAppException(ERROR_NETWORK, e.getMessage());
        }
    }
}
