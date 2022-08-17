create table transaction(
transactionId int primary key AUTO_INCREMENT,
paymentMode varchar(20) ,
bookingId int NOT NULL,
upiId varchar(20) NULL,
cardNumber varchar(20) NULL
)