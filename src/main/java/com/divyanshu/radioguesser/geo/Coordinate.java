package com.divyanshu.radioguesser.geo;

import com.divyanshu.radioguesser.common.constants.GeoConstants;

public record Coordinate(double latitude, double longitude) {
        public Boolean isValid(){
                return false;
        }

        public Coordinate{
                if (latitude < GeoConstants.MIN_LATITUDE
                        || latitude > GeoConstants.MAX_LATITUDE) {
                        throw new IllegalArgumentException(
                                "Latitude must be between -90 and 90 degrees."
                        );
                }

                if (longitude < GeoConstants.MIN_LONGITUDE
                        || longitude > GeoConstants.MAX_LONGITUDE) {
                        throw new IllegalArgumentException(
                                "Longitude must be between -180 and 180 degrees."
                        );
                }
        }
}