package iot.integration.model.smartdevice;

import iot.integration.constant.SmartDeviceStatus;
import iot.integration.model.Location;

public class Fan extends SmartHomeDevice{
    private int fanSpeed;

    public Fan(String defaultActivationKeyword, String name, Location location, SmartDeviceStatus status) {
        super(defaultActivationKeyword, name, location,status);
        this.fanSpeed=0;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    protected void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }
}
