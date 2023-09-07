package iot.integration.manager;

import iot.integration.model.Location;

import java.util.HashMap;
import java.util.HashSet;

public class LocationManager {
    private static HashSet<Location> locations;

    public LocationManager(HashSet<Location> locations) {
        this.locations = locations;
    }

    public static void validate(Location location) throws Exception {
        if(!locations.contains(location))
            throw new Exception("invalid location");
    }
}
