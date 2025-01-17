package com.taapti.app.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
