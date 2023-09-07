package iot.integration.model.command;

import iot.integration.model.smartdevice.SmartHomeDevice;

public class TurnOnCommand implements Command{
    SmartHomeDevice smartDevice;

    public TurnOnCommand(SmartHomeDevice smartDevice) {
        this.smartDevice = smartDevice;
    }

    @Override
    public void execute(String commandValue) throws Exception {
        smartDevice.turnOnn();
    }
}

