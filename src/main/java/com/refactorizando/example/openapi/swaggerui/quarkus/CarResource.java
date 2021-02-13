package com.refactorizando.example.openapi.swaggerui.quarkus;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/cars")
public class CarResource {


    private Set<Car> cars = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CarResource() {
        cars.add(new Car(1L, "Mustang", "Black", "Ford"));
        cars.add(new Car(2L, "Megane", "Yellow", "Renault"));
    }

    @GET
    public Set<Car> list() {
        return cars;
    }

    @POST
    public Set<Car> add(Car car) {
        cars.add(car);
        return cars;
    }

    @DELETE
    public Set<Car> delete(Car car) {
        cars.removeIf(existingCar -> existingCar.getId().equals(car.getId()));
        return cars;
    }
}