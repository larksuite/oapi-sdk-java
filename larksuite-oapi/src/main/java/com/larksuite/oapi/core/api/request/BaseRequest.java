package com.larksuite.oapi.core.api.request;

import com.google.gson.Gson;
import com.larksuite.oapi.core.Context;
import com.larksuite.oapi.core.api.AccessTokenType;
import com.larksuite.oapi.core.api.Constants;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.Strings;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class BaseRequest<I, O> {

    private final static String ctxKeyRequestInfo = "------ctxKeyRequestInfo";
    private final String httpMethod;
    private final I input;
    private final Set<AccessTokenType> accessTokenTypeSet;
    private final List<RequestOptFn> requestOptFns;
    private final O output;
    private String httpPath;
    private String queryParams;
    private AccessTokenType accessTokenType;
    private String tenantKey;
    private String userAccessToken;
    private boolean isNotDataField;
    private long timeoutOfMs;
    private boolean retry;
    private boolean isResponseStream;
    private boolean isResponseStreamReal;
    private Gson gson;

    public BaseRequest(String httpPath, String httpMethod, AccessTokenType accessTokenType,
                       I input, O output, RequestOptFn... requestOptFns) {
        this.httpPath = httpPath;
        this.httpMethod = httpMethod;
        this.input = input;
        this.output = output;
        this.accessTokenTypeSet = new HashSet<>();
        this.accessTokenTypeSet.add(accessTokenType);
        this.accessTokenType = accessTokenType;
        this.requestOptFns = new ArrayList<>();
        this.requestOptFns.addAll(Arrays.asList(requestOptFns));
    }

    public BaseRequest(String httpPath, String httpMethod, AccessTokenType[] accessTokenTypes,
                       I input, O output, RequestOptFn... requestOptFns) {
        this.httpPath = httpPath;
        this.httpMethod = httpMethod;
        this.input = input;
        this.output = output;
        this.accessTokenTypeSet = new HashSet<>();
        this.accessTokenTypeSet.addAll(Arrays.asList(accessTokenTypes));
        this.accessTokenType = getDefaultAccessTokenType(accessTokenTypes);
        this.requestOptFns = new ArrayList<>();
        this.requestOptFns.addAll(Arrays.asList(requestOptFns));
    }

    public static BaseRequest byContext(Context context) {
        return (BaseRequest) context.get(ctxKeyRequestInfo);
    }

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // won't happen
        }
        return "";
    }

    public void init() {
        RequestOpt opt = new RequestOpt();
        for (RequestOptFn f : this.getRequestOptFns()) {
            f.fn(opt);
        }
        this.timeoutOfMs = opt.getTimeoutOfMs();
        this.isNotDataField = opt.isNotDataField();
        this.setResponseStream(opt.isResponseStream());
        this.setGson(Jsons.LONG_TO_STR_GSON);
        if (opt.isSupportLongDataType()) {
            this.setGson(Jsons.DEFAULT_GSON);
        }
        if (!Strings.isEmpty(opt.getTenantKey())) {
            if (this.getAccessTokenTypeSet().contains(AccessTokenType.Tenant)) {
                this.tenantKey = opt.getTenantKey();
                this.accessTokenType = AccessTokenType.Tenant;
            }
        }
        if (!Strings.isEmpty(opt.getUserAccessToken())) {
            if (this.getAccessTokenTypeSet().contains(AccessTokenType.User)) {
                this.userAccessToken = opt.getUserAccessToken();
                this.accessTokenType = AccessTokenType.User;
            }
        }
        if (opt.getPathParams() != null) {
            this.httpPath = resolvePath(this.getHttpPath(), opt.getPathParams());
        }
        if (opt.getQueryParams() != null) {
            this.queryParams = buildQuery(opt.getQueryParams());
        }
    }

    public String resolvePath(String path, Map<String, Object> pathVar) {
        String tmpPath = path;
        StringBuilder newPath = new StringBuilder();
        for (; true; ) {
            int i = tmpPath.indexOf(":");
            if (i == -1) {
                newPath.append(tmpPath);
                break;
            }
            newPath.append(tmpPath, 0, i);
            String subPath = tmpPath.substring(i);
            int j = subPath.indexOf("/");
            if (j == -1) {
                j = subPath.length();
            }
            String varName = subPath.substring(1, j);
            Object v = pathVar.get(varName);
            if (v == null) {
                throw new IllegalArgumentException("path:" + path + ", param name:" + varName + " not found value");
            }
            newPath.append(v.toString());
            if (j == subPath.length()) {
                break;
            }
            tmpPath = subPath.substring(j);
        }
        return newPath.toString();
    }

    public String buildQuery(Map<String, Object> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        Set<Map.Entry<String, Object>> entries = params.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Object> entry : entries) {
            String name = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            if (value instanceof List) {
                for (Object o : (List) value) {
                    list.add(name + "=" + encode(o.toString()));
                }
            } else if (value.getClass().isArray()) {
                int len = Array.getLength(value);
                for (int i = 0; i < len; i++) {
                    list.add(name + "=" + encode(Array.get(value, i).toString()));
                }
            } else {
                list.add(name + "=" + encode(value.toString()));
            }
        }
        if (list.isEmpty()) {
            return "";
        }
        StringBuilder query = new StringBuilder();
        for (String s : list) {
            query.append(s).append("&");
        }
        return query.deleteCharAt(query.length() - 1).toString();
    }

    private AccessTokenType getDefaultAccessTokenType(AccessTokenType[] accessTokenTypes) {
        AccessTokenType accessTokenType = accessTokenTypes[0];
        for (AccessTokenType t : accessTokenTypes) {
            if (t == AccessTokenType.Tenant) {
                accessTokenType = t;
                break;
            }
        }
        return accessTokenType;
    }

    public void withContext(Context context) {
        context.set(ctxKeyRequestInfo, this);
    }

    public long getTimeoutOfMs() {
        return timeoutOfMs;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getQueryParams() {
        return queryParams;
    }

    public I getInput() {
        return input;
    }

    public Set<AccessTokenType> getAccessTokenTypeSet() {
        return accessTokenTypeSet;
    }

    public AccessTokenType getAccessTokenType() {
        return accessTokenType;
    }

    public String getTenantKey() {
        return tenantKey;
    }

    public String getUserAccessToken() {
        return userAccessToken;
    }

    public boolean isNotDataField() {
        return isNotDataField;
    }

    public O getOutput() {
        return output;
    }

    public boolean isRetry() {
        return retry;
    }

    public void setRetry(boolean retry) {
        this.retry = retry;
    }

    public boolean isResponseStream() {
        return isResponseStream;
    }

    public void setResponseStream(boolean responseStream) {
        isResponseStream = responseStream;
    }

    public List<RequestOptFn> getRequestOptFns() {
        return requestOptFns;
    }

    public boolean isResponseStreamReal() {
        return isResponseStreamReal;
    }

    public void setResponseStreamReal(boolean responseStreamReal) {
        isResponseStreamReal = responseStreamReal;
    }

    public String url() {
        String path = "/" + Constants.OAPI_ROOT_PATH + "/" + this.getHttpPath();
        if (!Strings.isEmpty(this.getQueryParams())) {
            path += "?" + this.getQueryParams();
        }
        return path;
    }

    public String fullUrl(String domain) {
        return domain + url();
    }


    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
