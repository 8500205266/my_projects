package com.flightservice.service;
import com.flightservice.dto.FlighrBookingAcknowledgement;
import com.flightservice.dto.FlightBookingRequest;
import com.flightservice.entity.PassengerInfo;
import com.flightservice.entity.PaymentInfo;
import com.flightservice.repository.PassengerInfoRepository;
import com.flightservice.repository.PaymentInfoRepository;
import com.flightservice.util.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class FlightBookingService
{
    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlighrBookingAcknowledgement bookflightticket(FlightBookingRequest request)
    {
        FlighrBookingAcknowledgement acknowledgement=null;
        PassengerInfo passengerInfo=request.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo=request.getPaymentInfo();
        paymentInfo.setPassergerId(passengerInfo.getPassengerId());
        paymentInfo.setAmount(passengerInfo.getFare());
        PaymentUtils.validatecredentails(paymentInfo.getAccountNo(),paymentInfo.getAmount());
        paymentInfoRepository.save(paymentInfo);
        return new FlighrBookingAcknowledgement("success",passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0],passengerInfo);
    }
}
