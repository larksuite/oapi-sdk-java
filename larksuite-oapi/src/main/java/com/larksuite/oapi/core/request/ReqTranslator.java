package com.larksuite.oapi.core.request;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.Config;
import com.larksuite.oapi.core.Constants;
import com.larksuite.oapi.core.annotation.Body;
import com.larksuite.oapi.core.annotation.Path;
import com.larksuite.oapi.core.annotation.Query;
import com.larksuite.oapi.core.exception.AccessTokenTypeInvalidException;
import com.larksuite.oapi.core.token.AccessTokenType;
import com.larksuite.oapi.core.token.GlobalTokenManager;
import com.larksuite.oapi.core.utils.Jsons;
import com.larksuite.oapi.core.utils.Strings;
import com.larksuite.oapi.okhttp3_14.MediaType;
import com.larksuite.oapi.okhttp3_14.MultipartBody;
import com.larksuite.oapi.okhttp3_14.RequestBody;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class ReqTranslator {

    private static String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
        } catch (UnsupportedEncodingException e) {
            // won't happen
        }
        return "";
    }

    public com.larksuite.oapi.okhttp3_14.Request translate(Object req
            , AccessTokenType accessTokenType
            , Config config, String httpMethod, String httpPath
            , RequestOptions requestOptions) throws Exception {
        // 解析path,query,body 参数
        ParsedReq parsedReq = parseInput(req, requestOptions);

        // 构建http body payload
        RequestBody body = buildReqBody(parsedReq);

        // 拼接URL
        String reqUrl = getFullReqUrl(config.getDomain(), httpPath, parsedReq.pathMap, parsedReq.queryMap);

        // 构建request
        com.larksuite.oapi.okhttp3_14.Request.Builder builder = new com.larksuite.oapi.okhttp3_14.Request.Builder().url(reqUrl).method(httpMethod, body);

        // 设置请求header
        builder.header("User-Agent", "oapi-sdk-java/" + Constants.VERSION);
        if (requestOptions.getHeaders() != null && requestOptions.getHeaders().size() > 0) {
            for (Map.Entry<String, List<String>> entry : requestOptions.getHeaders().entrySet()) {
                for (String value : entry.getValue()) {
                    builder.header(entry.getKey(), value);
                }
            }
        }

        if (Strings.isNotEmpty(requestOptions.getRequestId())) {
            builder.header(Constants.CUSTOM_REQUEST_ID, requestOptions.getRequestId());
        }

        // 获取并缓存token
        if (accessTokenType != AccessTokenType.None) {
            String token = getToken(requestOptions.getTenantKey(), accessTokenType, config, requestOptions);
            builder.header("Authorization", String.format("Bearer %s", token));
        }

        return builder.build();
    }

    private String getToken(String tenantKey, AccessTokenType accessTokenType, Config config, RequestOptions requestOptions) throws Exception {
        switch (accessTokenType) {
            case App:
                if (config.isDisableTokenCache()) {
                    return requestOptions.getAppAccessToken();
                }
                return GlobalTokenManager.getTokenManager()
                        .getAppAccessToken(config);

            case Tenant:
                if (config.isDisableTokenCache()) {
                    return requestOptions.getTenantAccessToken();
                }
                return GlobalTokenManager.getTokenManager()
                        .getTenantAccessToken(config, tenantKey);

            case User:
                return requestOptions.getUserAccessToken();
            default:
                throw new AccessTokenTypeInvalidException();
        }
    }

    private ParsedReq parseInput(Object req, RequestOptions requestOptions) throws IllegalAccessException {
        // 解析 path,body,query注解
        ParsedReq parsedReq = new ParsedReq();
        if (req == null) {
            return parsedReq;
        }
        Field[] fields = req.getClass().getDeclaredFields();
        boolean hasHttpAnnotation = false;
        if (fields != null) {
            for (Field field : fields) {
                // 解析body注解
                field.setAccessible(true);
                Body body = field.getAnnotation(Body.class);
                if (body != null) {
                    hasHttpAnnotation = true;
                    parsedReq.body = field.get(req);
                }

                // 解析Path注解
                Path path = field.getAnnotation(Path.class);
                if (path != null) {
                    hasHttpAnnotation = true;
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    parsedReq.pathMap.put(serializedName.value(), (String) field.get(req));
                }

                // 解析Query注解
                Query query = field.getAnnotation(Query.class);
                if (query != null) {
                    hasHttpAnnotation = true;
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    parsedReq.queryMap.put(serializedName.value(), (String) field.get(req));
                }
            }
        }

        if (!hasHttpAnnotation) {
            parsedReq.body = req;
        }

        if (parsedReq.body != null) {
            if (requestOptions.isSupportUpload()) {
                parsedReq.body = buildFormData(parsedReq.body);
            }
        }

        return parsedReq;
    }

    private FormData buildFormData(Object body) throws IllegalAccessException {
        // 构建form-data格式的数据
        FormData formData = new FormData();
        Field[] fields = body.getClass().getDeclaredFields();
        if (fields != null) {
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.getType() == File.class) {
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    FormDataFile formDataFile = new FormDataFile();
                    formDataFile.setFile((File) field.get(body));
                    formDataFile.setFieldName(serializedName.value().trim());
                    formData.addFile(serializedName.value().trim(), formDataFile);
                } else {
                    SerializedName serializedName = field.getAnnotation(SerializedName.class);
                    if (serializedName != null && field.get(body) != null) {
                        formData.addField(serializedName.value().trim(), field.get(body));
                    }
                }
            }
        }

        return formData;
    }

    private RequestBody buildReqBody(ParsedReq parsedReq) {
        if (parsedReq == null || parsedReq.body == null) {
            return null;
        }

        Object body = parsedReq.body;
        if (body instanceof FormData) {
            String contentType = "multipart/form-data;charset=" + StandardCharsets.UTF_8;
            MultipartBody.Builder builder = new MultipartBody.Builder()
                    .setType(MediaType.parse(contentType));

            for (Map.Entry<String, Object> entry : ((FormData) body).getParams().entrySet()) {
                builder.addFormDataPart(entry.getKey(), (String) entry.getValue());
            }

            for (FormDataFile file : ((FormData) body).getFiles()) {
                final File finalFile = file.getFile();
                builder.addFormDataPart(file.getFieldName(),
                        Strings.isEmpty(file.getFileName()) ? "unknown" : file.getFileName()
                        , RequestBody.create(MediaType.parse("application/octet-stream"), finalFile));
            }

            return builder.build();
        }

        return RequestBody.create(MediaType.parse(Constants.DEFAULT_CONTENT_TYPE)
                , Jsons.LONG_TO_STR_GSON.toJson(body).getBytes(StandardCharsets.UTF_8));
    }

    private String getFullReqUrl(String domain, String httpPath, Map<String, String> pathMap, Map<String, String> queryMap) {
        String reqUrl = joinPathParam(httpPath, pathMap);
        if (!reqUrl.startsWith("http")) {
            if (reqUrl.startsWith("/open-apis")) {
                reqUrl = domain + reqUrl;
            } else {
                reqUrl = domain + "/open-apis/" + reqUrl;
            }
        }

        if (queryMap.size() > 0) {
            reqUrl += "?" + this.buildQuery(queryMap);
        }

        return reqUrl;
    }


    private String joinPathParam(String path, Map<String, String> pathMap) {
        if (pathMap.size() == 0) {
            return path;
        }
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
            if (varName.equals("")) {
                newPath.append(subPath.substring(0, j));
            } else {
                Object v = pathMap.get(varName);
                if (v == null) {
                    throw new IllegalArgumentException("path:" + path + ", param name:" + varName + " not found value");
                }
                newPath.append(v.toString());
            }
            if (j == subPath.length()) {
                break;
            }
            tmpPath = subPath.substring(j);
        }
        return newPath.toString();
    }

    private String buildQuery(Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return "";
        }
        Set<Map.Entry<String, String>> entries = params.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : entries) {
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

    private class ParsedReq {
        private HashMap<String, String> pathMap = new HashMap<>();
        private HashMap<String, String> queryMap = new HashMap<>();
        private Object body;
    }

}