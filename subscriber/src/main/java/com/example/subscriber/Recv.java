package com.example.subscriber;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class Recv {

    private static final String EXCHANGE_NAME = "logs";
    private static final String EXCHANGE_DEPORTES = "deportes";

    public static void rabbit(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        queuesChannel(EXCHANGE_NAME, factory);
        queuesChannel(EXCHANGE_DEPORTES, factory);

    }

    private static void queuesChannel(String queueExchange, ConnectionFactory factory) throws Exception {
        final Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        channel.exchangeDeclare(queueExchange, "fanout");
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, queueExchange, "");

        DeliverCallback deliverCallback2 = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");

            System.out.println(" [x] Received '" + message + "'" + queueName);
        };
        channel.basicConsume(queueName, true, deliverCallback2, consumerTag -> { });
    }

    public static void registerSubscriber(Subscriber S, String topic, HashMap<String, Vector<Subscriber>> subscriberList){
        if(subscriberList.get(topic)==null){
            Vector<Subscriber> newlist = new Vector<>();
            newlist.add(S);
            subscriberList.put(topic,newlist);
        }else {
            subscriberList.get(topic).add(S);
        }
    }

    public int getSizeSubscribers(String channel){
        return subscriberList.get(channel).size();
    }
}
