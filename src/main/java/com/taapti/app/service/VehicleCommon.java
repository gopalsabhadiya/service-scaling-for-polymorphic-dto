package com.taapti.app.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Abstract class providing common vehicle-related functionalities.
 * Contains a method to log the creation of a new vehicle.
 * Note: If you need a choice of executing the logic based on requirement, that logic can be implemented in this class
 */
@Slf4j
abstract class VehicleCommon {

    /**
     * Logs the creation of a new vehicle with the given ID.
     *
     * @param id the ID of the newly created vehicle
     */
    public void createVehicleLog(String id) {
        log.info("This is common log method to notify that new vehicle has been created with ID: {}", id);
    }
}
