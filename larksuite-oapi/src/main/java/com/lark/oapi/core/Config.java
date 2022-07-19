package com.lark.oapi.core;


import com.lark.oapi.core.cache.ICache;
import com.lark.oapi.core.enums.AppType;
import com.lark.oapi.core.enums.BaseUrlEnum;
import com.lark.oapi.core.httpclient.IHttpTransport;
import java.util.concurrent.TimeUnit;

public class Config {

  private long requestTimeOut;
  private TimeUnit timeOutTimeUnit;
  private String helpDeskID;
  private ICache cache;
  private String baseUrl;
  private boolean disableTokenCache;
  private AppType appType;
  private String helpDeskToken;
  private String helpDeskAuthToken;
  private String tokenCache;
  private String appId;
  private String appSecret;
  private IHttpTransport httpTransport;
  private boolean logReqAtDebug;

  public Config() {
    this.baseUrl = BaseUrlEnum.FeiShu.getUrl();
    this.appType = AppType.SELF_BUILT;
  }

  public IHttpTransport getHttpTransport() {
    return httpTransport;
  }

  public void setHttpTransport(IHttpTransport httpTransport) {
    this.httpTransport = httpTransport;
  }

  public boolean isLogReqAtDebug() {
    return logReqAtDebug;
  }

  public void setLogReqAtDebug(boolean logReqAtDebug) {
    this.logReqAtDebug = logReqAtDebug;
  }

  public long getRequestTimeOut() {
    return requestTimeOut;
  }

  public void setRequestTimeOut(long requestTimeOut) {
    this.requestTimeOut = requestTimeOut;
  }

  public TimeUnit getTimeOutTimeUnit() {
    return timeOutTimeUnit;
  }

  public void setTimeOutTimeUnit(TimeUnit timeOutTimeUnit) {
    this.timeOutTimeUnit = timeOutTimeUnit;
  }

  public ICache getCache() {
    return cache;
  }

  public void setCache(ICache cache) {
    this.cache = cache;
  }

  public String getBaseUrl() {
    return baseUrl;
  }

  public void setBaseUrl(String baseUrl) {
    this.baseUrl = baseUrl;
  }

  public void setDomain(BaseUrlEnum domain) {
    this.baseUrl = domain.getUrl();
  }

  public boolean isDisableTokenCache() {
    return disableTokenCache;
  }

  public void setDisableTokenCache(boolean disableTokenCache) {
    this.disableTokenCache = disableTokenCache;
  }

  public AppType getAppType() {
    return appType;
  }

  public void setAppType(AppType appType) {
    this.appType = appType;
  }

  public String getHelpDeskID() {
    return helpDeskID;
  }

  public void setHelpDeskID(String helpDeskID) {
    this.helpDeskID = helpDeskID;
  }

  public String getHelpDeskToken() {
    return helpDeskToken;
  }

  public void setHelpDeskToken(String helpDeskToken) {
    this.helpDeskToken = helpDeskToken;
  }

  public String getTokenCache() {
    return tokenCache;
  }

  public void setTokenCache(String tokenCache) {
    this.tokenCache = tokenCache;
  }

  public String getHelpDeskAuthToken() {
    return helpDeskAuthToken;
  }

  public void setHelpDeskAuthToken(String helpDeskAuthToken) {
    this.helpDeskAuthToken = helpDeskAuthToken;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String appId) {
    this.appId = appId;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }

}