package com.flightservice.util;

import com.flightservice.exception.InsufficientAmountException;

import java.util.HashMap;
import java.util.Map;

public class PaymentUtils
{
    private static Map<String,Double> payment=new HashMap<>();
   static
   {
        payment.put("prashanth",1200.0);
        payment.put("baalu",1000.0);
        payment.put("raaju",900.0);
        payment.put("venky",500.0);
    }
    public static boolean validatecredentails(String account,double paidamount )
    {
        if(paidamount>payment.get(account))
        {
            throw  new InsufficientAmountException("insufficient fund here....!! ");
        }
        else
        {
            return true;
        }
    }
}
