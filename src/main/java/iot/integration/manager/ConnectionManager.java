package iot.integration.manager;

import iot.integration.model.Location;
import iot.integration.model.interfacedevice.InterfaceDevice;
import iot.integration.model.smartdevice.SmartHomeDevice;

import java.util.HashSet;

public class ConnectionManager {
    public void connectSmartHomeDevice(String activationKeyword, Location location,String deviceName) throws Exception {
        SmartHomeDevice dummyDevice= SmartHomeDeviceManager.getDevice(deviceName,location);
        InterfaceDevice interfaceDevice=InterfaceDeviceManager.getDeviceFromKeyword(activationKeyword);
        try{
            interfaceDevice.getSmartDevice(dummyDevice);
            throw new Exception("already device connected");
        }
        catch (Exception e){
            interfaceDevice.getConnectedDevices().add(SmartHomeDeviceManager.getDevice(deviceName,location));
        }

    }
    public void disconnectDevice(String activationKeyword, Location location,String deviceName) throws Exception {

        HashSet<SmartHomeDevice> devices= InterfaceDeviceManager.getDeviceFromKeyword(activationKeyword).getConnectedDevices();
        SmartHomeDevice dummyDevice= SmartHomeDeviceManager.creatyDummyDevice(deviceName,location);

        if(devices.contains(dummyDevice))
            devices.remove(dummyDevice);
        else throw new RuntimeException("Device cant be removed as alredy present");


    }
}
