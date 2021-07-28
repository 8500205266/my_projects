package com.flightservice.dto;

import com.flightservice.entity.PassengerInfo;
import com.flightservice.entity.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest
{
    private PassengerInfo passengerInfo;
    private PaymentInfo paymentInfo;

}
