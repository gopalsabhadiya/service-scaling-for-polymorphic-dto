package com.taapti.app.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class Bike extends Vehicle {

    private Boolean isChainDrive;

    public Bike(String id, String make, String model, Integer year, Boolean isChainDrive) {
        super(id, make, model, year);
        this.isChainDrive = isChainDrive;
    }

}
