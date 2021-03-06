// Code generated by lark suite oapi sdk gen
package com.larksuite.oapi.service.vc.v1.model;
import com.google.gson.annotations.SerializedName;

public class RoomDigitalSignage {
    @SerializedName("enable")
    private Boolean enable;
    @SerializedName("mute")
    private Boolean mute;
    @SerializedName("start_display")
    private Integer startDisplay;
    @SerializedName("stop_display")
    private Integer stopDisplay;
    @SerializedName("materials")
    private RoomDigitalSignageMaterial[] materials;

    public Boolean getEnable() {
        return this.enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public Boolean getMute() {
        return this.mute;
    }

    public void setMute(Boolean mute) {
        this.mute = mute;
    }

    public Integer getStartDisplay() {
        return this.startDisplay;
    }

    public void setStartDisplay(Integer startDisplay) {
        this.startDisplay = startDisplay;
    }

    public Integer getStopDisplay() {
        return this.stopDisplay;
    }

    public void setStopDisplay(Integer stopDisplay) {
        this.stopDisplay = stopDisplay;
    }

    public RoomDigitalSignageMaterial[] getMaterials() {
        return this.materials;
    }

    public void setMaterials(RoomDigitalSignageMaterial[] materials) {
        this.materials = materials;
    }

}
