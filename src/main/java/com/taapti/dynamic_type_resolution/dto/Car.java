package com.taapti.dynamic_type_resolution.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Car extends Vehicle {

    private Integer numberOfAirbags;
    private Boolean isPowerSteering;

    public Car(String id, String make, String model, Integer year, Integer numberOfAirbags, Boolean isPowerSteering) {
        super(id, make, model, year);
        this.numberOfAirbags = numberOfAirbags;
        this.isPowerSteering = isPowerSteering;
    }

}
