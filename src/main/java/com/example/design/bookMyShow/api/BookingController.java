package com.example.design.bookMyShow.api;

import com.example.design.bookMyShow.model.Seat;
import com.example.design.bookMyShow.model.Show;
import com.example.design.bookMyShow.services.BookingService;
import com.example.design.bookMyShow.services.ShowService;
import com.example.design.bookMyShow.services.TheatreService;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public String createBooking(@NonNull final String userId, @NonNull final String showId,
                                @NonNull final List<String> seatsIds) {
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatsIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show, seats).getId();
    }
}
