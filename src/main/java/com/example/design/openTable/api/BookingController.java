package com.example.design.openTable.api;

import com.example.design.openTable.service.BookingService;
import com.example.design.openTable.model.Booking;
import com.example.design.openTable.util.Response;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    public Response<Booking> createBooking(String customerId, String contact, int numberOfGuests, LocalDateTime bookingTime) {
        return bookingService.createBooking(String customerId, contact, numberOfGuests, bookingTime);
    }

    public Response<String> cancelBooking(String bookingId) {
        return bookingService.cancelBooking(bookingId);
    }

    public Response<List<Booking>> getAllBookingsByRestaurant(int restaurantId) {
        return bookingService.getAllBookingsByRestaurant(restaurantId);
    }

    public Response<Booking> getBookingById(String bookingId) {
        return bookingService.getBookingById(bookingId);
    }

}
