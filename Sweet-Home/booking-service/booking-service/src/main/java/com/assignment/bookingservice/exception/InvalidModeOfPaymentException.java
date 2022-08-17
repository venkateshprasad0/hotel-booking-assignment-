package com.assignment.bookingservice.exception;

public class InvalidModeOfPaymentException extends RuntimeException{
    public InvalidModeOfPaymentException(){
        super("Invalid mode of Payment");
    }
}
