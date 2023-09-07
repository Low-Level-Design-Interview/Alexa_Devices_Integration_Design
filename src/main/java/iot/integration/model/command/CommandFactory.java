package iot.integration.model.command;

import iot.integration.constant.Commands;
import iot.integration.constant.SmartHomeDevices;
import iot.integration.model.Location;
import iot.integration.model.smartdevice.Fan;
import iot.integration.model.smartdevice.Light;
import iot.integration.model.smartdevice.SmartHomeDevice;

import java.util.Map;

public class CommandFactory {
    static Map<Commands,Class<? extends Command>> classMap;

    static{
        classMap.put(Commands.TURN_ON, TurnOnCommand.class);
        classMap.put(Commands.SET_BRIGHTNESS, LightBrightnessCommand.class);
    }

    public static Command getInstance(Commands commandEnum,SmartHomeDevice device) throws Exception {

        if(classMap.containsKey(commandEnum))
            return classMap.get(commandEnum).getDeclaredConstructor().newInstance(device);
        else{
            throw new Exception("Command not found");
        }
    }
}
