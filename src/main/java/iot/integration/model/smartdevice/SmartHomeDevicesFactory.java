package iot.integration.model.smartdevice;

import iot.integration.constant.SmartHomeDevices;
import iot.integration.model.Location;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class SmartHomeDevicesFactory {
    static Map<SmartHomeDevices,Class<? extends SmartHomeDevice>> classMap;

    static{
        classMap.put(SmartHomeDevices.Light, Light.class);
        classMap.put(SmartHomeDevices.FAN, Fan.class);
    }

    public static SmartHomeDevice getInstance(String name, Location location, String defaultActivationKeyword) throws Exception {
        SmartHomeDevices deviceName=SmartHomeDevices.valueOf(name);
        if(classMap.containsKey(deviceName))
                return classMap.get(deviceName).getDeclaredConstructor().newInstance(defaultActivationKeyword, name, location);
        else{
            throw new Exception("Device name not found");
        }
    }

}
