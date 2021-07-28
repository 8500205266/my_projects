package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class Consumer {

    @Autowired
    Orders orders;

    @KafkaListener(topics = "payments", groupId = "group_id")
    public void consume(String message)
    {
        System.out.println("message from payments->"+message);
        final String[] s = message.split(" ");
        if(s[2].equals("PAYMENT_SUCCESS"))
        {
            orders.changeOrderStatus(s[0], "ORDER_SUCCESS");
        }
        else
        {
            orders.changeOrderStatus(s[0],"ORDER_FAILED");
        }
        System.out.println("Chaged order status "+ orders.get(s[0]));
    }



}