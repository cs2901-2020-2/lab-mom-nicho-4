package com.example.labmom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;


@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class LabmomApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(LabmomApplication.class, args);
        Send.rabbit(args);
    }

}
