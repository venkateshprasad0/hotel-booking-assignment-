package com.assignment.bookingservice.service;

import DTO.BookingEntityDTO;
import DTO.TransactionInfoDTO;
import com.assignment.bookingservice.entity.BookingInfoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface BookingService {
    public BookingInfoEntity getBooking(BookingEntityDTO bookingEntityDTO);
    public BookingInfoEntity doBooking(TransactionInfoDTO transactionInfoDTO, int bookingId);
}
