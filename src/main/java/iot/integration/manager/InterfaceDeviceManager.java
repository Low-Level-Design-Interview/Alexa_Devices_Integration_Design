package iot.integration.manager;


import iot.integration.model.Location;
import iot.integration.model.interfacedevice.InterfaceDevice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public  class InterfaceDeviceManager {
    private static HashSet< InterfaceDevice> devices;

    private static InterfaceDeviceManager instance;

    private InterfaceDeviceManager (){
        devices= new HashSet<>();
    }

    public static InterfaceDeviceManager getInstance() {
        if(instance==null)
            synchronized (InterfaceDeviceManager.class){
                if(instance==null){
                    return instance=new InterfaceDeviceManager();
                }
            }
        return instance;
    }

    public void addDevice(String name, Location location,String activationKeyword) throws Exception{
        InterfaceDevice device= new InterfaceDevice(name,activationKeyword,location);
        validate(device);

        devices.add(device);
    }

    public static void  validate(InterfaceDevice device) throws Exception {
        if(devices.contains(device))
            throw new Exception("Device already present");

        LocationManager.validate(device.getLocation());
    }
    public static InterfaceDevice  createDummyInterface(String activationKeyword) throws Exception {

        return new InterfaceDevice("dummy",activationKeyword,null);
    }

    public static InterfaceDevice getDeviceFromKeyword(String activationKeyword) throws Exception {
        InterfaceDevice dummyDevice= createDummyInterface(activationKeyword);
        validate(dummyDevice);
        for(InterfaceDevice device: devices){
            if(device.equals(dummyDevice))
                return device;
        }
        throw new Exception("Device not connected");
    }
}
