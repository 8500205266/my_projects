package com.flightservice.controller;

import com.flightservice.dto.FlighrBookingAcknowledgement;
import com.flightservice.dto.FlightBookingRequest;
import com.flightservice.service.FlightBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookigController
{
    @Autowired
    private FlightBookingService flightBookingService;

    @PostMapping("/bookflightticket")
    public FlighrBookingAcknowledgement bookflightticket(@RequestBody FlightBookingRequest request)
    {
        return flightBookingService.bookflightticket(request);
    }
}
