package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStore {

    public Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
        booksTitlesWithTranslations.put("IM", ironManTranslations);
        booksTitlesWithTranslations.put("AV", avengersTranslations);
        booksTitlesWithTranslations.put("FL", flashTranslations);

        return booksTitlesWithTranslations;
    }

public static class Stream_challenge_TASK_13_1 {

        MovieStore movieStore = new MovieStore();
        Map<String, List<String>> movies = movieStore.getMovies();

        String moviesString = movies.entrySet()
                .stream()
                .flatMap(m -> m.getValue().stream())
                .collect(Collectors.joining(", "));
}

    public static void main(String[] args) {

        MovieStore movieStore = new MovieStore();
        System.out.println(movieStore.getMovies());

        Stream_challenge_TASK_13_1 stream_challenge_task_13_1 = new Stream_challenge_TASK_13_1();
        System.out.println(stream_challenge_task_13_1.moviesString);
    }
}


