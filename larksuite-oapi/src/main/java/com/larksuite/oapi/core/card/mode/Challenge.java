package com.larksuite.oapi.core.card.mode;

import com.google.gson.annotations.SerializedName;

public class Challenge {
    @SerializedName("challenge")
    private String challenge;
    @SerializedName("token")
    private String token;
    @SerializedName("type")
    private String type;

    public String getChallenge() {
        return challenge;
    }

    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "challenge='" + challenge + '\'' +
                ", token='" + token + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
