// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.speech_to_text.v1.model;

import com.google.gson.annotations.SerializedName;
import com.larksuite.oapi.core.response.BaseResponse;

public class FileRecognizeSpeechResp extends BaseResponse {

    @SerializedName("data")
    private FileRecognizeSpeechDTO body;

    public FileRecognizeSpeechDTO getFileRecognizeSpeechDTO() {
        return this.body;
    }

    public void setFileRecognizeSpeechDTO(FileRecognizeSpeechDTO body) {
        this.body = body;
    }
}
