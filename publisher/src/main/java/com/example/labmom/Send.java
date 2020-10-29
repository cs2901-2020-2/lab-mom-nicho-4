package com.example.labmom;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.nio.charset.StandardCharsets;

public class Send {

    private static final String EXCHANGE_NAME = "logs";
    private static final String EXCHANGE_DEPORTES = "deportes";

    public static void rabbit(String [] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        String s = args.length < 1 ? "mensaje enviado" :
                String.join(" ", args);

        sendQueueChannel(EXCHANGE_NAME, factory, s);
        sendQueueChannel(EXCHANGE_DEPORTES, factory, s);

    }

    private static void sendQueueChannel(String queueExchange, ConnectionFactory factory, String s) throws Exception{
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.exchangeDeclare(queueExchange, "fanout");

            channel.basicPublish(queueExchange, "", null, s.getBytes("UTF-8"));
            System.out.println(" [x] Sent " + s + "1" + queueExchange);
        }
    }
}
