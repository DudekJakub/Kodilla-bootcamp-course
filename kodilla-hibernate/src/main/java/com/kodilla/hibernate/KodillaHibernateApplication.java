package com.kodilla.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com/kodilla/hibernate"})
public class KodillaHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(KodillaHibernateApplication.class, args);
    }

}
