package com.taapti.dynamic_type_resolution.service;

import org.springframework.stereotype.Service;

/**
 * Service implementation for managing car inventory operations.
 */
@Service
class CarInventoryServiceImpl implements CarInventoryService {

    private Integer carPartsCount = 2;

    /**
     * Reduces the count of car parts in the inventory.
     * Throws a RuntimeException if there are no parts left.
     */
    @Override
    public void reduce() {
        if(carPartsCount == 0) {
            throw new RuntimeException("Cannot create new car due to lack of parts");
        }
        carPartsCount -= 1;
    }
}
