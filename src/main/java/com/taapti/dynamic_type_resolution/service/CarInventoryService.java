package com.taapti.dynamic_type_resolution.service;

import org.springframework.stereotype.Service;

@Service
public class CarInventoryService {

    private Integer carPartsCount = 2;

    public void reduce() {
        if(carPartsCount == 0) {
            throw new RuntimeException("Cannot create new car due to lack of parts");
        }
        carPartsCount -= 1;
    }
}
