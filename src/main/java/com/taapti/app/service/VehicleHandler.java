package com.taapti.app.service;

import com.taapti.app.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service handler for managing vehicle operations.
 * This class delegates the creation of vehicles to the appropriate service implementation
 * based on the type of vehicle.
 */
@Service
class VehicleHandler implements VehicleService<Vehicle> {

    private final Map<Class<?>, VehicleService<Vehicle>> serviceMap;
    private final VehicleNotificationService vehicleNotificationService;

    /**
     * Constructs a VehicleHandler with a list of vehicle services and a notification service.
     *
     * @param vehicleServiceList the list of vehicle services
     * @param vehicleNotificationService the notification service for sending notifications
     */
    @SuppressWarnings("unchecked")
    public VehicleHandler(
            List<VehicleService<? extends Vehicle>> vehicleServiceList,
            VehicleNotificationService vehicleNotificationService
    ) {
        this.serviceMap =
                vehicleServiceList
                        .stream()
                        .collect(
                                Collectors.toMap(
                                        VehicleService::getType,
                                        service -> (VehicleService<Vehicle>) service
                                )
                        );
        this.vehicleNotificationService = vehicleNotificationService;
    }

    /**
     * Creates a new vehicle by delegating to the appropriate vehicle service
     * and sends a notification about the created vehicle.
     *
     * @param vehicle the vehicle to create
     * @return the created vehicle
     */
    @Override
    public Vehicle create(Vehicle vehicle) {
        //With some creativity and reflection, you can also throw error at compile-time or runtime in the constructor
        // to make sure your application doesn't start without service for new Vehicle type
        if(!serviceMap.containsKey(vehicle.getClass())) {
            throw new RuntimeException("Unsupported vehicle type: " + vehicle.getClass().getSimpleName());
        }
        Vehicle created = serviceMap.get(vehicle.getClass()).create(vehicle);
        vehicleNotificationService.sendUserNotification(created);
        return created;
    }

    @Override
    public Class<Vehicle> getType() {
        return Vehicle.class;
    }
}