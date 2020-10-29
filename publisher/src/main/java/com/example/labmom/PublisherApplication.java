package com.example.labmom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class PublisherApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(PublisherApplication.class, args);
        Send.rabbit(args);
    }

}
