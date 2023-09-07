package iot.integration.model.smartdevice;

import iot.integration.constant.SmartDeviceStatus;
import iot.integration.model.Location;
import iot.integration.model.interfacedevice.InterfaceDevice;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public abstract class SmartHomeDevice {
    private String defaultActivationKeyword;
    private String name;
    private Location location;

    private SmartDeviceStatus status;

    private Set<InterfaceDevice> connectedToDevices;

    public SmartHomeDevice(String defaultActivationKeyword, String name, Location location, SmartDeviceStatus status) {
        this.defaultActivationKeyword = defaultActivationKeyword;
        this.name = name;
        this.location = location;
        this.status = status;
        connectedToDevices= new HashSet<>();
    }

    public SmartHomeDevice() {

    }

    public void addInterfaceDevice(InterfaceDevice device){
        connectedToDevices.add(device);
    }

    public Set<InterfaceDevice> getConnectedToDevices() {
        return connectedToDevices;
    }

    public void turnOff() {
        status=SmartDeviceStatus.Off;
        System.out.println("turning off device= "+name );
    }

    public void turnOnn(){
        status=SmartDeviceStatus.On;
        System.out.println("turning on device= "+name);
    }

    public SmartDeviceStatus getStatus() {
        return status;
    }

    public void setStatus(SmartDeviceStatus status) {
        this.status = status;
    }

    public String getDefaultActivationKeyword() {
        return defaultActivationKeyword;
    }

    public void setDefaultActivationKeyword(String defaultActivationKeyword) {
        this.defaultActivationKeyword = defaultActivationKeyword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof SmartHomeDevice)) return false;
        SmartHomeDevice that = (SmartHomeDevice) o;
        return Objects.equals(getName(), that.getName()) && Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getLocation());
    }
}
