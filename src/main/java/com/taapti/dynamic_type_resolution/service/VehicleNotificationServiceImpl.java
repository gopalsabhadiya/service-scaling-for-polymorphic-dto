package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Vehicle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * Service implementation for sending notifications related to vehicles.
 */
@Slf4j
@Service
class VehicleNotificationServiceImpl implements VehicleNotificationService {

    /**
     * Sends a notification to the user about the specified vehicle.
     *
     * @param vehicle the vehicle for which the notification is to be sent
     */
    @Override
    public void sendUserNotification(Vehicle vehicle) {
        log.info("This is to notify user that new vehicle is created: {}", vehicle.toString());
    }
}
