package com.example.subscriber;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

public class Subscriber {

    private HashMap<String, Vector<Subscriber>> subscriberList;

    public int getSizeSubscribers(String channel){
        return subscriberList.get(channel).size();
    }

    private Subscriber(){subscriberList = new HashMap<>();}

    public Subscriber(String topic){
        Recv.registerSubscriber(this,topic, subscriberList);
    }

}
