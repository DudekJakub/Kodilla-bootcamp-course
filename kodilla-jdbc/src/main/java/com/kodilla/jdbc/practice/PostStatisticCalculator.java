package com.kodilla.jdbc.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostStatisticCalculator {

    private final PostsEntityProcessor postsEntityProcessor;

    @Autowired
    public PostStatisticCalculator(PostsEntityProcessor postsEntityProcessor) {
        this.postsEntityProcessor = postsEntityProcessor;
    }
}
