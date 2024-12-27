package org.muskan.api;

import lombok.AllArgsConstructor;

import lombok.NonNull;
import org.muskan.model.Seat;
import org.muskan.model.Show;
import org.muskan.services.BookingService;
import org.muskan.services.ShowService;
import org.muskan.services.TheatreService;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BookingController {
    private final ShowService showService;
    private final BookingService bookingService;
    private final TheatreService theatreService;

    public String createBooking(@NonNull final String userId, @NonNull String showId,
                                @NonNull final List<String> seatIds){
        final Show show = showService.getShow(showId);
        final List<Seat> seats = seatIds.stream().map(theatreService::getSeat).collect(Collectors.toList());
        return bookingService.createBooking(userId, show,seats).getId();
    }

}
