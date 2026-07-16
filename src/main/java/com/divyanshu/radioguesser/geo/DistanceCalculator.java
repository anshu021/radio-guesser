package com.divyanshu.radioguesser.geo;

import com.divyanshu.radioguesser.common.constants.GeoConstants;

import java.util.Objects;

public final class DistanceCalculator {

    private DistanceCalculator(){}

    public static double calculate(Coordinate first , Coordinate second){

        Objects.requireNonNull(first);
        Objects.requireNonNull(second);

        Objects.requireNonNull(first, "First coordinate cannot be null");
        Objects.requireNonNull(second, "Second coordinate cannot be null");

        double latitude1 = Math.toRadians(first.latitude());
        double longitude1 = Math.toRadians(first.longitude());

        double latitude2 = Math.toRadians(second.latitude());
        double longitude2 = Math.toRadians(second.longitude());

        double deltaLatitude =  latitude2 - latitude1;
        double deltaLongitude =  longitude2 - longitude1;

        double sinLatitude = Math.sin(deltaLatitude / 2);
        double sinLongitude = Math.sin(deltaLongitude / 2);

        double a = sinLatitude * sinLatitude
                + Math.cos(latitude1) * Math.cos(latitude2)
                * sinLongitude
                * sinLongitude;

        double centralAngle = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return GeoConstants.EARTH_RADIUS_KM * centralAngle;
    }
}
