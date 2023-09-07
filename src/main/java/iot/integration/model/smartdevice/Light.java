package iot.integration.model.smartdevice;

import iot.integration.constant.Color;
import iot.integration.constant.SmartDeviceStatus;
import iot.integration.model.Location;

public class Light extends SmartHomeDevice{
    private Color color;
    private static final Color defaultColor=Color.White;
    private int brightnessLevel=0;

    public Light(){
        super();

    }
    public Light(String defaultActivationKeyword, String name, Location location, SmartDeviceStatus status) {
        super(defaultActivationKeyword, name, location,status);
        this.color=defaultColor;
    }

    public Color getColor() {
        return color;
    }

    protected void setColor(Color color) {
        this.color = color;
    }

    public int getBrightnessLevel() {
        return brightnessLevel;
    }

    protected void setBrightnessLevel(int brightnessLevel) {
        this.brightnessLevel = brightnessLevel;
    }
}
