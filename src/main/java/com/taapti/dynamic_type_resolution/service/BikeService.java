package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Bike;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class BikeService implements VehicleService<Bike> {

    private final Map<String, Bike> bikeStore = new HashMap<>();

    @Override
    public Bike create(Bike bike) {
        String id = UUID.randomUUID().toString();
        bikeStore.put(
                id,
                new Bike(
                        id,
                        bike.getMake(),
                        bike.getModel(),
                        bike.getYear(),
                        bike.getIsChainDrive()
                )
        );
        return bikeStore.get(id);
    }

}
