package com.assignment.bookingservice.controller;

import DTO.BookingEntityDTO;
import DTO.TransactionInfoDTO;
import com.assignment.bookingservice.entity.BookingInfoEntity;
import com.assignment.bookingservice.exception.InvalidModeOfPaymentException;
import com.assignment.bookingservice.repository.BookingRepository;
import com.assignment.bookingservice.service.BookingService;
import com.assignment.bookingservice.service.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
public class BookingServiceController {
   @Autowired
  private BookingService bookingService;

    @PostMapping (value="/booking", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public BookingInfoEntity getBooking(@RequestBody BookingEntityDTO bookingEntityDTO
                           ){
       return bookingService.getBooking(bookingEntityDTO);
    }

    @PostMapping(value = "/booking/{bookingId}/transaction")
    public BookingInfoEntity doBooking(@RequestBody TransactionInfoDTO transactionInfoDTO, @PathVariable("bookingId") int bookingId){

        return bookingService.doBooking(transactionInfoDTO,bookingId);

    }


}
