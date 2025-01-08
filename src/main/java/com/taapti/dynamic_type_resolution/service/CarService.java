package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CarService implements VehicleService<Car> {

    private final CarInventoryService carInventoryService;

    private final Map<String, Car> carStore = new HashMap<>();

    @Override
    public Car create(Car car) {
        carInventoryService.reduce();
        String id = UUID.randomUUID().toString();
        carStore.put(
                id,
                new Car(
                        id,
                        car.getMake(),
                        car.getModel(),
                        car.getYear(),
                        car.getNumberOfAirbags(),
                        car.getIsPowerSteering()
                )
        );
        return carStore.get(id);
    }

}
