package com.divyanshu.radioguesser.radio;

import com.divyanshu.radioguesser.geo.Coordinate;

import java.util.Set;
import java.util.UUID;

public final class RadioStation {

    private UUID id;
    private String name;
    private String streamUrl;
    private Coordinate location;
    private String country;
    private String city;
    private String language;
    private Set<String> tags;

}
