package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class VehicleHandler implements VehicleService<Vehicle> {

    private final Map<Class<?>, VehicleService<Vehicle>> serviceMap;

    public VehicleHandler(List<VehicleService<? extends Vehicle>> vehicleServiceList) {
        this.serviceMap = vehicleServiceList.stream().collect(Collectors.toMap(VehicleService::getGenericType, service -> (VehicleService<Vehicle>) service));
    }

    @Override
    public Vehicle create(Vehicle vehicle) {
        return serviceMap.get(vehicle.getClass()).create(vehicle);
    }
}
