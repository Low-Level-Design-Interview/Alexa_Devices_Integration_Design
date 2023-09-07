package iot.integration.model.command;

import iot.integration.constant.Color;
import iot.integration.model.smartdevice.Light;

public class LightBrightnessCommand  implements Command {

    Light light;

    public LightBrightnessCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute(String commandValue) throws Exception {
        int brightness=Integer.valueOf(commandValue);

    }



}
