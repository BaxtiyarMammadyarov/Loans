package az.mycompany.loans.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;


import java.math.BigDecimal;
import java.time.LocalDate;



@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculateInvoices {
   String userId;
   BigDecimal amount;
   Integer period;
   BigDecimal interest;
   @DateTimeFormat(pattern = "yyyy-MM-dd")
   LocalDate payout;

}
