package com.example.subscriber;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.awt.geom.RectangularShape;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SubscriberApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SubscriberApplication.class, args);
        Recv.rabbit(args);
    }

}
