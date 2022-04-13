package az.mycompany.loans.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CalculateInvoices {
   BigDecimal amount;
   Integer period;
   BigDecimal interest;
   @DateTimeFormat(pattern = "yyyy-MM-dd 'T' HH:mm")
   LocalDateTime payoutDate;

}
