package com.assignment.bookingservice.service;

import DTO.BookingEntityDTO;
import DTO.TransactionInfoDTO;
import com.assignment.bookingservice.entity.BookingInfoEntity;
import com.assignment.bookingservice.exception.InvalidBookingIdException;
import com.assignment.bookingservice.exception.InvalidModeOfPaymentException;
import com.assignment.bookingservice.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository repo;

    @Autowired
    RestTemplate restTemplate;

    public static String getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String> numberList = new ArrayList<String>();
        for(int i=0; i < count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList.toString();
    }

    @Override
    public BookingInfoEntity getBooking(BookingEntityDTO bookingEntityDTO) {
        BookingInfoEntity  bookingInfoEntity = new BookingInfoEntity();
        bookingInfoEntity.setFromDate(bookingEntityDTO.getFromDate());
        bookingInfoEntity.setToDate(bookingEntityDTO.getToDate());
        bookingInfoEntity.setAadharNumber(bookingEntityDTO.getAadharNumber());
        bookingInfoEntity.setNumOfRooms(bookingEntityDTO.getNumOfRooms());
        bookingInfoEntity.setRoomNumbers(BookingServiceImpl.getRandomNumbers(bookingEntityDTO.getNumOfRooms()));
        bookingInfoEntity.setBookedOn(LocalDateTime.now());
        bookingInfoEntity.setRoomPrice(calculateRoomRent(bookingInfoEntity.getFromDate(),bookingEntityDTO.getToDate(),bookingEntityDTO.getNumOfRooms()));
        bookingInfoEntity = repo.save(bookingInfoEntity);
        return bookingInfoEntity;
    }

    @Override
    public BookingInfoEntity doBooking(TransactionInfoDTO transactionInfoDTO, int bookingId) {
//        if(!transactionInfoDTO.getPaymentMode().equalsIgnoreCase("card")||transactionInfoDTO.getPaymentMode().equalsIgnoreCase("upi")|| transactionInfoDTO.getPaymentMode()!=null)
//        {
//            throw new InvalidModeOfPaymentException();
//        }
        TransactionInfoDTO requestBody = new TransactionInfoDTO();
        requestBody.setBookingId(bookingId);
        requestBody.setCardNumber(transactionInfoDTO.getCardNumber());
        requestBody.setPaymentMode(transactionInfoDTO.getPaymentMode());
        requestBody.setUpiId(transactionInfoDTO.getUpiId());

        int TransactionId = restTemplate.postForObject("http://payment-service/payment/transaction",requestBody,Integer.class);
            BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
            bookingInfoEntity = repo.findById(bookingId);
            bookingInfoEntity.setTransactionID(TransactionId);
            return bookingInfoEntity;
    }


    private int calculateRoomRent(Date fromDate, Date toDate, int noOfRooms){
        long time_difference = toDate.getTime()-fromDate.getTime();
        // Calucalte time difference in days
        long durationOfStay =  (time_difference / (1000*60*60*24)) % 365;
        return (int) (1000*durationOfStay)*noOfRooms;
    }

}
