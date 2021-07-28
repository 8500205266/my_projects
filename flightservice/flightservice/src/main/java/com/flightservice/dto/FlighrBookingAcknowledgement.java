package com.flightservice.dto;

import com.flightservice.entity.PassengerInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class FlighrBookingAcknowledgement
{
    private  String status;
    private double totalFare;
    private String pnrNo;
    private PassengerInfo passengerInfo;
}
