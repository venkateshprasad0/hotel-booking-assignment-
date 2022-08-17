package com.assignment.bookingservice.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name="booking")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class BookingInfoEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int BOOKINGID;
    @Column(name="FROMDATE")
    private Date fromDate;
    @Column(name="TODATE")
    private Date toDate;
    @Column(name="AADHARNUMBER")
    private String aadharNumber;
    @Column(name="NUMOFROOMS")
    private int numOfRooms;
    @Column(name="ROOMNUMBERS")
    private String roomNumbers;
    @Column(name="ROOMPRICE")
    private int roomPrice;
    @Column(name="TRANSACTIONID")
    private int transactionID;
    @Column(name="BOOKEDON")
    private LocalDateTime bookedOn;

}
