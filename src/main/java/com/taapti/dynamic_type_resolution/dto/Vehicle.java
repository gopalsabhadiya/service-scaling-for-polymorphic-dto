package com.taapti.dynamic_type_resolution.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "typeInfo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Car.class),
        @JsonSubTypes.Type(value = Bike.class)
})
public abstract class Vehicle {
    private String id;
    private String make;
    private String model;
    private Integer year;
}
