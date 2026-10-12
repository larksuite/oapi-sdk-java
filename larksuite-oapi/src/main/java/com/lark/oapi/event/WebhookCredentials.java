package com.lark.oapi.event;

/** Immutable credentials snapshot for a single HTTP webhook request. */
public final class WebhookCredentials {
  private final String encryptKey;
  private final String verificationToken;

  /**
   * Creates a credentials snapshot. Provider results must use non-null strings;
   * empty strings explicitly represent unconfigured credentials.
   *
   * @param encryptKey encryption key
   * @param verificationToken verification token
   */
  public WebhookCredentials(String encryptKey, String verificationToken) {
    this.encryptKey = encryptKey;
    this.verificationToken = verificationToken;
  }

  /** @return the encryption key */
  public String getEncryptKey() {
    return encryptKey;
  }

  /** @return the verification token */
  public String getVerificationToken() {
    return verificationToken;
  }
}
