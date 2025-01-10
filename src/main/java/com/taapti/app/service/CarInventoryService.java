package com.taapti.app.service;

/**
 * Service interface for managing car inventory operations.
 */
public interface CarInventoryService {

    /**
     * Reduces the count of car parts in the inventory.
     * Throws a RuntimeException if there are no parts left.
     */
    void reduce();
}
