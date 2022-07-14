package com.lark.oapi.core.request;

import com.google.gson.annotations.SerializedName;
import com.lark.oapi.core.Config;
import com.lark.oapi.core.Constants;
import com.lark.oapi.core.annotation.Body;
import com.lark.oapi.core.annotation.Path;
import com.lark.oapi.core.annotation.Query;
import com.lark.oapi.core.exception.IllegalAccessTokenTypeException;
import com.lark.oapi.core.token.AccessTokenType;
import com.lark.oapi.core.token.GlobalTokenManager;
import com.lark.oapi.core.utils.Lists;
import com.lark.oapi.core.utils.Strings;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReqTranslator {

  private static String encode(String value) {
    try {
      return URLEncoder.encode(value, StandardCharsets.UTF_8.name());
    } catch (UnsupportedEncodingException e) {
      // won't happen
    }
    return "";
  }

  public RawRequest translate(Object req
      , AccessTokenType accessTokenType
      , Config config, String httpMethod, String httpPath
      , RequestOptions requestOptions) throws Exception {

    // 解析path,query,body 参数
    ParsedReq parsedReq = parseInput(req, requestOptions);

    // 拼接URL
    String reqUrl = getFullReqUrl(config.getBaseUrl(), httpPath, parsedReq.pathMap,
        parsedReq.queryMap);

    // headers
    Map<String, List<String>> headers = requestOptions.getHeaders();
    if (headers == null) {
      headers = new HashMap<>();
    }

    headers.put("User-Agent", Lists.newArrayList("oapi-sdk-java/" + Constants.VERSION));

    if (Strings.isNotEmpty(requestOptions.getRequestId())) {
      headers.put(Constants.CUSTOM_REQUEST_ID, Lists.newArrayList(requestOptions.getRequestId()));
    }

    // 获取并缓存token
    if (accessTokenType != AccessTokenType.None) {
      String token = getToken(requestOptions.getTenantKey(), accessTokenType, config,
          requestOptions);
      headers.put("Authorization", Lists.newArrayList(String.format("Bearer %s", token)));
    }

    RawRequest rawRequest = new RawRequest();
    rawRequest.setBody(parsedReq.body);
    rawRequest.setReqUrl(reqUrl);
    rawRequest.setHeaders(headers);
    rawRequest.setHttpMethod(httpMethod);
    rawRequest.setConfig(config);
    rawRequest.setSupportDownLoad(requestOptions.isSupportUpload());
    return rawRequest;
  }

  private String getToken(String tenantKey, AccessTokenType accessTokenType, Config config,
      RequestOptions requestOptions) throws Exception {
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
        throw new IllegalAccessTokenTypeException();
    }
  }

  private ParsedReq parseInput(Object req, RequestOptions requestOptions)
      throws IllegalAccessException {
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
          if (null != field.get(req)) {
            parsedReq.pathMap.put(serializedName.value(), (String) field.get(req));
          }
        }

        // 解析Query注解
        Query query = field.getAnnotation(Query.class);
        if (query != null) {
          hasHttpAnnotation = true;
          SerializedName serializedName = field.getAnnotation(SerializedName.class);
          if (null != field.get(req)) {
            parsedReq.queryMap.put(serializedName.value(), (String) field.get(req));
          }
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

  private String getFullReqUrl(String domain, String httpPath, Map<String, String> pathMap,
      Map<String, String> queryMap) {
    String reqUrl = joinPathParam(httpPath, pathMap);
    if (!reqUrl.startsWith("http")) {
      reqUrl = domain + reqUrl;
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
          throw new IllegalArgumentException(
              "path:" + path + ", param name:" + varName + " not found value");
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
