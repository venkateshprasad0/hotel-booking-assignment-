package com.assignment.paymentservice.controlller;

import com.assignment.paymentservice.DTO.TransactionDTO;
import com.assignment.paymentservice.entity.TransactionInfoEntity;
import com.assignment.paymentservice.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class PaymentServiceController {

    @Autowired
    TransactionRepository repo;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return "Im Payment Service";
    }


    @GetMapping("/payment/transaction/{transactionId}")
    public TransactionInfoEntity getTransactionDetails(@PathVariable("transactionId") int transactionId) {
        TransactionInfoEntity transactionInfoEntity = new TransactionInfoEntity();
        transactionInfoEntity = repo.findById(transactionId);
        return transactionInfoEntity;
    }

    @PostMapping(value = "/payment/transaction", consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public int getBooking(@RequestBody TransactionDTO transactionDTO
    ) {
        TransactionInfoEntity transactionInfoEntity = new TransactionInfoEntity();
        transactionInfoEntity.setPaymentMOde(transactionDTO.getPaymentMode());
        transactionInfoEntity.setBookingId(transactionDTO.getBookingId());
        transactionInfoEntity.setUpiId(transactionDTO.getUpiId());
        transactionInfoEntity.setCardNumber(transactionDTO.getCardNumber());
        TransactionInfoEntity savedEntitity = repo.save(transactionInfoEntity);
        System.out.println("Booking confirmed for user with aadhar number: ");
        return savedEntitity.getTransactionId();
    }


}
