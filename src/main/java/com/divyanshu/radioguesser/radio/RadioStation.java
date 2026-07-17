package com.divyanshu.radioguesser.radio;

import com.divyanshu.radioguesser.geo.Coordinate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public final class RadioStation {

    private final UUID id;
    private final String name;
    private final String streamUrl;
    private final Coordinate location;
    private final String country;
    private final String city;
    private final String language;
    private final Set<String> tags;

}
