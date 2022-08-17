CREATE TABLE booking (
    bookingId int PRIMARY KEY AUTO_INCREMENT,
    fromDate date NOT NULL,
    toDate date NOT NULL,
    aadharNumber varchar(20) NOT NULL,
    numOfRooms int ,
    roomNumbers varchar(50),
    roomPrice int NOT NULL,
    transactionId int DEFAULT 0,
    bookedOn date NOT NULL
);