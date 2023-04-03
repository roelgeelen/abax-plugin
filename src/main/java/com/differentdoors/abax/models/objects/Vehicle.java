package com.differentdoors.abax.models.objects;

import com.differentdoors.abax.models.ObjectName;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vehicle {
    private String id;
    private String asset_id;
    private String alias;
    private ObjectName manufacturer;
    private ObjectName model;
    private ObjectName license_plate;
    private Location location;
}
