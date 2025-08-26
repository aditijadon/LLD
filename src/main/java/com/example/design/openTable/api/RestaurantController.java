package com.example.design.openTable.api;

import com.example.design.openTable.model.Restaurant;
import com.example.design.openTable.service.RestaurantService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RestaurantController {
    private final RestaurantService restaurantService;

    public Response<Restaurant> getRestaurantById(int restaurantId) {
        return restaurantService.getRestaurantById(restaurantId);
    }

    public Response<List<Restaurant>> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    public Response<List<Table>> getAvailableTables(int restaurantId, int numberOfGuests) {
        return restaurantService.getAvailableTables(restaurantId, numberOfGuests);
    }
}
