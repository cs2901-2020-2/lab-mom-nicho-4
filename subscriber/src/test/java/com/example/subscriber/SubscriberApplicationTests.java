package com.example.subscriber;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.assertEquals;


@SpringBootTest
class SubscriberApplicationTests {

    @Test
    void subscriberSize() {
        Subscriber subscriber1 = new Subscriber("EXCHANGE_NAME");
        Subscriber subscriber2 = new Subscriber("EXCHANGE_NAME");
        Subscriber subscriber3 = new Subscriber("EXCHANGE_DEPORTES");

        assertEquals(subscriber1.getSizeSubscribers("EXCHANGE_NAME"), 2);

    }

}
