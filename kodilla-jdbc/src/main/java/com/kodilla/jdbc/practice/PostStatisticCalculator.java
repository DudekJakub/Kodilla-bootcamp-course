package com.kodilla.jdbc.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class PostStatisticCalculator {

    private final PostsEntityProcessor postsEntityProcessor;

    @Autowired
    public PostStatisticCalculator(PostsEntityProcessor postsEntityProcessor) {
        this.postsEntityProcessor = postsEntityProcessor;
    }

    public Map<Integer, Double> calculateQuantityOfUsersPostsPerMonth() throws SQLException {

        var usersIdWithPostsMonths = postsEntityProcessor.getAllUsersPostsAndDates()
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> (new ArrayList<>(e.getValue().values()))));

        postsEntityProcessor.getAllUsersPostsAndDates()
                .entrySet()
                .forEach(e -> System.out.println(e + "/n"));

        return new HashMap<>();
    }
}
