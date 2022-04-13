package com.kodilla.testing.streamExercices.springConfig;

import com.kodilla.testing.streamExercices.baseClasses.Forum;
import com.kodilla.testing.streamExercices.idManager.ForumUser_ID_manager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.kodilla.testing.streamExercices")
public class CoreConfiguration {

    @Bean
    public ForumUser_ID_manager forumUser_id_manager() {
        return new ForumUser_ID_manager();
    }

    @Bean
    public Forum forum() {
        return new Forum();
    }
}
