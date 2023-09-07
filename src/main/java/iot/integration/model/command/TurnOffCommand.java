package iot.integration.model.command;

import iot.integration.model.smartdevice.SmartHomeDevice;

public class TurnOffCommand implements Command{
    SmartHomeDevice smartDevice;

    public TurnOffCommand(SmartHomeDevice smartDevice) {
        this.smartDevice = smartDevice;
    }

    @Override
    public void execute(String commandValue) throws Exception {
        smartDevice.turnOff();
    }
}
