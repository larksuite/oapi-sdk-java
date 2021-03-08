package com.larksuite.oapi.core;

import com.larksuite.oapi.core.utils.Strings;

public class Config {

    public static final String CTX_KEY_CONFIG = "-----ctxKeyConfig";

    private final String domain;
    private final AppSettings appSettings;
    private final IStore store;

    public Config(Domain domain, AppSettings appSettings, IStore store) {
        this(domain.getUrl(), appSettings, store);
    }

    public Config(String domain, AppSettings appSettings, IStore store) {
        this.domain = domain;
        this.appSettings = appSettings;
        this.store = store;
    }

    public static Config ByCtx(Context context) {
        return (Config) context.get(CTX_KEY_CONFIG);
    }

    public static Config NewTestConfig(String domain, AppSettings appSettings) {
        return new Config(domain, appSettings, new DefaultStore());
    }

    private static String domainFeiShu(String env) {
        return System.getenv().get(env + "_FEISHU_DOMAIN");
    }

    private static AppSettings getISVAppSettings(String env) {
        String appID = System.getenv().get(env + "_ISV_APP_ID");
        String appSecret = System.getenv().get(env + "_ISV_APP_SECRET");
        String verificationToken = System.getenv().get(env + "_ISV_VERIFICATION_TOKEN");
        String encryptKey = System.getenv().get(env + "_ISV_ENCRYPT_KEY");
        return new AppSettings(AppType.ISV, appID, appSecret, verificationToken, encryptKey);
    }

    private static AppSettings createInternalAppSettings(String env) {
        String appID = System.getenv().get(env + "_INTERNAL_APP_ID");
        String appSecret = System.getenv().get(env + "_INTERNAL_APP_SECRET");
        String verificationToken = System.getenv().get(env + "_INTERNAL_VERIFICATION_TOKEN");
        String encryptKey = System.getenv().get(env + "_INTERNAL_ENCRYPT_KEY");
        return new AppSettings(AppType.Internal, appID, appSecret, verificationToken, encryptKey);
    }

    public static AppSettings createInternalAppSettings(String appID, String appSecret,
                                                        String verificationToken, String encryptKey) {
        return new AppSettings(AppType.Internal, appID, appSecret, verificationToken, encryptKey);
    }

    public static AppSettings createIsvAppSettings(String appID, String appSecret,
                                                   String verificationToken, String encryptKey) {
        return new AppSettings(AppType.ISV, appID, appSecret, verificationToken, encryptKey);
    }

    public static AppSettings getInternalAppSettingsByEnv() {
        String appID = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");
        String verificationToken = System.getenv().get("VERIFICATION_TOKEN");
        String encryptKey = System.getenv().get("ENCRYPT_KEY");
        validateAppSettingsParams(appID, appSecret);
        return new AppSettings(AppType.Internal, appID, appSecret, verificationToken, encryptKey);
    }

    public static AppSettings getIsvAppSettingsByEnv() {
        String appID = System.getenv().get("APP_ID");
        String appSecret = System.getenv().get("APP_SECRET");
        String verificationToken = System.getenv().get("VERIFICATION_TOKEN");
        String encryptKey = System.getenv().get("ENCRYPT_KEY");
        validateAppSettingsParams(appID, appSecret);
        return new AppSettings(AppType.ISV, appID, appSecret, verificationToken, encryptKey);
    }

    private static void validateAppSettingsParams(String appID, String appSecret) {
        if (Strings.isEmpty(appID) || Strings.isEmpty(appSecret)) {
            throw new IllegalArgumentException("environment variables not exist `APP_ID` or `APP_SECRET`");
        }
    }

    public static Config getTestISVConf(String env) {
        env = env.toUpperCase();
        return NewTestConfig(getDomain(env), getISVAppSettings(env));
    }

    public static Config getTestInternalConf(String env) {
        env = env.toUpperCase();
        return NewTestConfig(getDomain(env), createInternalAppSettings(env));
    }

    private static String getDomain(String env) {
        if (!env.equals("BOE") && !env.equals("PRE") && !env.equals("ONLINE")) {
            throw new IllegalArgumentException("env must in [boe, pre, online]");
        }
        if (env.equals("ONLINE")) {
            return Domain.FeiShu.getUrl();
        }
        return domainFeiShu(env);
    }

    public void withContext(Context context) {
        context.set(CTX_KEY_CONFIG, this);
    }

    public String getDomain() {
        return domain;
    }

    public AppSettings getAppSettings() {
        return appSettings;
    }

    public IStore getStore() {
        return store;
    }

    @Override
    public String toString() {
        return "Config{" +
                "domain='" + domain + '\'' +
                ", appSettings=" + appSettings +
                ", store=" + store +
                '}';
    }
}
