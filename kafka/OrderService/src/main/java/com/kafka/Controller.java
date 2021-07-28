package com.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/Order")
public class Controller {

    private final Producer producer;
    private final Orders orders;
    @Autowired
    Controller(Producer producer, Orders orders) {
        this.producer = producer;
        this.orders = orders;
    }

    @Autowired
    Consumer consumer;

    @PostMapping(value = "/create")
    public String sendMessageToKafkaTopic(@RequestParam("id") String id,
            @RequestParam("order") String order)
    {
        final String add = orders.add(id, order);
        this.producer.sendMessage(order , id);
        return add;
    }

    @GetMapping
    public String get(@RequestParam("id") String id)
    {
        return orders.get(id) + " "+ orders.getStatus(id);
    }

}