package com.taapti.dynamic_type_resolution.service;

import com.taapti.dynamic_type_resolution.dto.Vehicle;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public interface VehicleService<T extends Vehicle> {
    T create(T vehicle);

    default Class<? extends Vehicle> getGenericType() {

        // Get the superclass type
        Type[] genericInterfaces = getClass().getGenericInterfaces();
        if (genericInterfaces.length > 0) {
            Type superClass = genericInterfaces[0];
            if (superClass instanceof ParameterizedType) {
                // Get the actual type arguments
                Type[] typeArguments = ((ParameterizedType) superClass).getActualTypeArguments();
                if (typeArguments != null && typeArguments.length > 0) {
                    // Return the first type argument
                    return (Class<? extends Vehicle>) typeArguments[0];
                }
            }
        }
        return null;
    }

}
