package com.taapti.dynamic_type_resolution.controller;

import com.taapti.dynamic_type_resolution.dto.Vehicle;
import com.taapti.dynamic_type_resolution.service.VehicleHandler;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for handling vehicle-related operations.
 */
@AllArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    private final VehicleHandler vehicleHandler;

    /**
     * Creates a new vehicle.
     *
     * @param vehicle the vehicle to create
     * @return the created vehicle
     */
    @PostMapping
    public Vehicle createNewVehicle(@RequestBody Vehicle vehicle) {
        return vehicleHandler.create(vehicle);
    }
}
