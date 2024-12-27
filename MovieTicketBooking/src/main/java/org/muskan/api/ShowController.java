package org.muskan.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.muskan.model.Movie;
import org.muskan.model.Screen;
import org.muskan.services.MovieService;
import org.muskan.services.SeatAvailabilityService;
import org.muskan.services.ShowService;
import org.muskan.services.TheatreService;

import java.util.Date;

@AllArgsConstructor
public class ShowController {
    private final SeatAvailabilityService seatAvailabilityService;
    private final ShowService showService;
    private final TheatreService theatreService;
    private final MovieService movieService;

    public String createShow(@NonNull final String movieId, @NonNull final String screenId, @NonNull final Date startTime,
                             @NonNull final Integer durationInSeconds){
        final Screen screen = theatreService.getScreen(screenId);
        final Movie movie = movieService.getMovie(movieId);
        return showService.createShow(movie, screen, startTime, durationInSeconds).getId();
    }
}
