package iot.integration.model.interfacedevice;


import iot.integration.model.Location;
import iot.integration.model.smartdevice.SmartHomeDevice;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class InterfaceDevice {
    private String interfaceName;
    private String activationKeyword;
    private Location location;

    private HashSet<SmartHomeDevice> connectedDevices;

    public InterfaceDevice(String interfaceName, String activationKeyword, Location location) {
        this.interfaceName = interfaceName;
        this.activationKeyword = activationKeyword;
        this.location = location;
    }


    public HashSet<SmartHomeDevice> getConnectedDevices() {
        return connectedDevices;
    }

    public SmartHomeDevice getSmartDevice(SmartHomeDevice dummyDevice) throws Exception {
        if(connectedDevices.contains(dummyDevice)){
            for(SmartHomeDevice device: connectedDevices)
                if(device.equals(dummyDevice))
                    return device;
        }
        throw new Exception("Not connected to device");
    }



    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getActivationKeyword() {
        return activationKeyword;
    }

    public void setActivationKeyword(String activationKeyword) {
        this.activationKeyword = activationKeyword;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InterfaceDevice)) return false;
        InterfaceDevice that = (InterfaceDevice) o;
        return getActivationKeyword().equals(that.getActivationKeyword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getActivationKeyword());
    }
}
