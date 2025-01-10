package com.taapti.app.service;

import com.taapti.app.dto.Car;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service implementation for handling operations related to cars.
 */
@Service
@AllArgsConstructor
class CarServiceImpl extends VehicleCommon implements CarService {

    private final CarInventoryServiceImpl carInventoryServiceImpl;
    private final Map<String, Car> carStore = new HashMap<>();

    /**
     * Creates a new car, reduces the inventory, and stores it in the car store.
     *
     * @param car the car to create
     * @return the created car with a generated ID
     */
    @Override
    public Car create(Car car) {
        carInventoryServiceImpl.reduce();
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
        createVehicleLog(id);
        return carStore.get(id);
    }

    @Override
    public Class<Car> getType() {
        return Car.class;
    }
}