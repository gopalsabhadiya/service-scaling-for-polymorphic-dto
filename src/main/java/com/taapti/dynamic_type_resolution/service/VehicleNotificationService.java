package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Vehicle;

/**
 * Service interface for sending notifications related to vehicles.
 */
public interface VehicleNotificationService {

    /**
     * Sends a notification to the user about the specified vehicle.
     *
     * @param vehicle the vehicle for which the notification is to be sent
     */
    void sendUserNotification(Vehicle vehicle);
}
