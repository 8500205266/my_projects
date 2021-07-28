package com.kafka;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@Service
public class Orders {
    Map<String, String> orders = new HashMap<>();
    Map<String, String> orderStatus = new HashMap<>();

    public String add(String id, String order) {
        orders.put(id, order);
        orderStatus.put(id, "PENDING");
        return id + " " + order + " " + "PENDING";
    }


    public void changeOrderStatus(String id, String status) {
        orderStatus.put(id, status);
    }
    public String get(String id) {
       return orders.get(id);
    }
    public String getStatus(String id) {
        return orderStatus.get(id);
    }
}
