package com.assignment.paymentservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;
}
