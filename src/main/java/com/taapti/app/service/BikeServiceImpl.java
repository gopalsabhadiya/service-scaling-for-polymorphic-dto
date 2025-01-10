package com.taapti.app.service;

import com.taapti.app.dto.Bike;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Service implementation for handling operations related to bikes.
 */
@Service
class BikeServiceImpl extends VehicleCommon implements BikeService {

    private final Map<String, Bike> bikeStore = new HashMap<>();

    /**
     * Creates a new bike and stores it in the bike store.
     *
     * @param bike the bike to create
     * @return the created bike with a generated ID
     */
    @Override
    public Bike create(Bike bike) {
        String id = UUID.randomUUID().toString();
        bikeStore.put(
                id,
                new Bike(
                        id,
                        bike.getMake(),
                        bike.getModel(),
                        bike.getYear(),
                        bike.getIsChainDrive()
                )
        );
        createVehicleLog(id);
        return bikeStore.get(id);
    }

    @Override
    public Class<Bike> getType() {
        return Bike.class;
    }
}
