package com.assignment.bookingservice.exception;

public class InvalidBookingIdException extends RuntimeException{
    public InvalidBookingIdException(){
        super("Invalid Booking Id");
    }
}
