package iot.integration.manager;


import iot.integration.constant.SmartDeviceStatus;
import iot.integration.constant.SmartHomeDevices;
import iot.integration.model.Location;
import iot.integration.model.interfacedevice.InterfaceDevice;
import iot.integration.model.smartdevice.SmartHomeDevice;
import iot.integration.model.smartdevice.SmartHomeDevicesFactory;

import java.util.HashSet;

public class SmartHomeDeviceManager {
    static HashSet<SmartHomeDevice> smartDevices;


    public SmartHomeDeviceManager(HashSet<SmartHomeDevice> smartDevices) {
        this.smartDevices = smartDevices;
    }

    public void addDevice(String name, Location location, String activationKeyword) throws Exception{
        SmartHomeDevice device=SmartHomeDevicesFactory.getInstance(name,location,activationKeyword);
        validate(device);
        smartDevices.add(device);
    }
    public  static void validate(SmartHomeDevice device) throws Exception {
        InterfaceDeviceManager.validate(InterfaceDeviceManager.createDummyInterface( device.getDefaultActivationKeyword()));
        if(smartDevices.contains(device))
            throw new Exception("Device already present with same location-name");

        LocationManager.validate(device.getLocation());
    }
    public static SmartHomeDevice creatyDummyDevice(String name,Location location) throws Exception {
        return SmartHomeDevicesFactory.getInstance(name,location,null);
    }

    public static SmartHomeDevice getDevice(String name,Location location) throws Exception {
        SmartHomeDevice dummy=creatyDummyDevice(name,location);
        validate(dummy);
        for(SmartHomeDevice device: smartDevices){
            if(device.equals(dummy))
                return device;
        }
        throw new Exception("Device not present in database");
    }

}
