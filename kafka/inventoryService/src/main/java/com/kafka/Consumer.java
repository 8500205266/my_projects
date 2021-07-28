package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer
{
    @Autowired
    Producer producer;
    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("message from order->"+message);
        final String[] s = message.split(" ");
        System.out.println("s------>"+s);

        if(s[2]=="pant")
        {
            producer.sendMessage("This Item(Pant) is Available!!");
        }
        else if(s[2]=="shirt")
        {
            producer.sendMessage("This Item(Shirt) is Available!!");
        }
        else
        {
            producer.sendMessage("This Item"+s[2]+" is NOT Available!!");
        }
    }


}