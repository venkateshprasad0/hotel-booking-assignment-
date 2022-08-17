package DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionInfoDTO {
    private String paymentMode;
    private int bookingId;
    private String upiId;
    private String cardNumber;
}
