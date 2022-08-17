package com.assignment.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="TRANSACTION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInfoEntity {

    @Id
    @Column(name = "TRANSACTIONID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int transactionId;
    @Column(name="PAYMENTMODE")
    private String paymentMOde;
    @Column(name="BOOKINGID")
    private int bookingId;
    @Column(name="UPIID")
    private String upiId;
    @Column(name="CARDNUMBER")
    private String cardNumber;

}
