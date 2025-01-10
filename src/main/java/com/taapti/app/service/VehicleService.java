package com.taapti.app.service;

import com.taapti.app.dto.Vehicle;

/**
 * Service interface for handling operations related to vehicles.
 * This interface provides methods for creating vehicles and retrieving the type of vehicle.
 *
 * @param <T> the type of vehicle
 */
public interface VehicleService<T extends Vehicle> {

    /**
     * Creates a new vehicle.
     *
     * @param vehicle the vehicle to create
     * @return the created vehicle
     */
    T create(T vehicle);

    /**
     * Implemented by the end service and returns the vehicle type.
     *
     * @return the class type of the vehicle
     */
    Class<T> getType();
}
