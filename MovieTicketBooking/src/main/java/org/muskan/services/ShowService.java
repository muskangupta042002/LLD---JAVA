package org.muskan.services;

import lombok.NonNull;
import org.muskan.exception.NotFoundException;
import org.muskan.exception.ScreenAlreadyOccupiedException;
import org.muskan.model.Movie;
import org.muskan.model.Screen;
import org.muskan.model.Show;

import java.util.*;

public class ShowService {
    private final Map<String, Show> shows;
    public ShowService(){
        this.shows = new HashMap<>();
    }

    public Show getShow(@NonNull final String showId){
        if (!shows.containsKey(showId)) {
            throw new NotFoundException();
        }
        return shows.get(showId);
    }

    public Show createShow(@NonNull final Movie movie, @NonNull final Screen screen, @NonNull final Date startTime,
                           @NonNull final Integer durationInSeconds){
        if (!checkIfShowCreationAllowed(screen, startTime, durationInSeconds)){
            throw new ScreenAlreadyOccupiedException();
        }
        String showId = UUID.randomUUID().toString();
        final Show show = new Show(showId, movie, screen, startTime, durationInSeconds);
        this.shows.put(showId, show);
        return show;
    }

    private List<Show> getShowsForScreen(final Screen screen){
        final List<Show> showList = new ArrayList<>();
        for(Show show: shows.values()){
            if (show.getScreen().equals(screen)){
                showList.add(show);
            }
        }
        return showList;
    }

    private boolean checkIfShowCreationAllowed(final Screen screen, final Date startTime, final Integer durationInSeconds) {
        // TODO: Implement this. This method will return whether the screen is free at a particular time for
        // specific duration. This function will be helpful in checking whether the show can be scheduled in that slot
        // or not.
        return true;
    }
}
