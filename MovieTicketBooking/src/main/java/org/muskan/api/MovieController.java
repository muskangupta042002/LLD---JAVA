package org.muskan.api;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.muskan.services.MovieService;

@AllArgsConstructor
public class MovieController {

    final private MovieService movieService;
    //model objects are not for user dont return it  directly **Contracts between various layers.


    public String createMovie(@NonNull final String movieName){
        return movieService.createMovie(movieName).getId();
    }
}
