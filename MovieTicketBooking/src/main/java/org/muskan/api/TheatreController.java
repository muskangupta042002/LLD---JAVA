package org.muskan.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.muskan.model.Screen;
import org.muskan.model.Theatre;
import org.muskan.services.TheatreService;



@AllArgsConstructor
public class TheatreController {
    final private TheatreService theatreService;

    public String createTheatre(@NonNull final String theatreName){
        return theatreService.createTheatre(theatreName).getId();
    }

    public String createScreenInTheatre(@NonNull final String screenName, @NonNull final String theatreId){
        final Theatre theatre = theatreService.getTheatre(theatreId);
        return theatreService.createScreenInTheatre(screenName, theatre).getId();
    }

    public String createSeatInScreen(@NonNull final Integer rowNo, @NonNull final Integer seatNo, @NonNull final String screenId){
        final Screen screen = theatreService.getScreen(screenId);
        return theatreService.createSeatInScreen(rowNo,seatNo,screen).getId();

    }
}
