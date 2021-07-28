package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Random;

@Service
public class Consumer {

    @Autowired
    Producer producer;

    HashMap<String,String> payment_status=new HashMap<>();

    @KafkaListener(topics = "orders", groupId = "group_id")
    public void consume(String message)
    {

        System.out.println("Received an order to proceed to payment->"+message);
        Random rn =new Random();
        if(rn.nextBoolean())
        {
            System.out.println("Customer has balance in account so amount got deducted! Payment success!");
            producer.sendMessage(message+ " " + "PAYMENT_SUCCESS");
            final String[] s = message.split(" ");
            System.out.println("s------>"+s);
            payment_status.put(s[0],"PAYMENT_SUCCESS");
        }
        else
        {
            System.out.println("Customer has no balance in account so amount not deducted! Payment Declined!");
            producer.sendMessage(message+ " " + "PAYMENT_FAILED");
            final String[] s = message.split(" ");
            System.out.println("s------>"+s);
            payment_status.put(s[0],"PAYMENT_FAILED");
        }
    }
    public String paymentStatus(String id)
    {
        return payment_status.get(id);
    }


}