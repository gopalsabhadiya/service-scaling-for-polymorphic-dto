package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Vehicle;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Service interface for handling operations related to vehicles.
 *
 * @param <T> the type of vehicle
 */
public interface VehicleService<T extends Vehicle> {

    /**
     * Creates a new vehicle.
     *
     * @param vehicle the vehicle to create
     * @return the created vehicle
     */
    T create(T vehicle);

    /**
     * Retrieves the generic type of the vehicle.
     *
     * @return the class of the generic type
     */
    //This method handles only specific case where the Car or Bike service implementation is extending CarService as first interface
    //Other cases can be handled easily and below given logic can be extended as per business requirement.
    @SuppressWarnings("unchecked")
    default Class<T> getGenericType() {
        Type[] genericInterfaces = getClass().getInterfaces()[0].getGenericInterfaces();
        if (genericInterfaces.length > 0) {
            Type superClass = genericInterfaces[0];
            if (superClass instanceof ParameterizedType parameterizedType) {
                Type[] typeArguments = parameterizedType.getActualTypeArguments();
                if (typeArguments.length > 0) {
                    return (Class<T>) typeArguments[0];
                }
            }
        }
        return null;
    }
}
