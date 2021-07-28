package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/payment")
public class Controller {

    private final Producer producer;

    @Autowired
    Controller(Producer producer) {
        this.producer = producer;
    }

    @Autowired
    Consumer consumer;

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message)
    {
        this.producer.sendMessage(message);
    }

/*    @GetMapping
    public void getPaymentStatus(@RequestParam("id") String id)
    {
        System.out.println("payment");
        this.consumer.paymentStatus(id);
    }*/
    @GetMapping
    public String getPaymentStatus(@RequestParam("id") String id)
    {
        return consumer.paymentStatus(id);
    }

}