package org.muskan.services;

import lombok.NonNull;
import org.muskan.exception.NotFoundException;
import org.muskan.model.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class MovieService {
    private final Map<String, Movie> movies;
    public MovieService(){
        this.movies=new HashMap<>();
    }

    public Movie getMovie(@NonNull final String movieId){
        if(!movies.containsKey(movieId)){
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }

    public Movie createMovie(@NonNull final String movieName){
        String id = UUID.randomUUID().toString();
        Movie movie = new Movie(id, movieName);
        movies.put(id, movie);
        return movie;
    }
}
