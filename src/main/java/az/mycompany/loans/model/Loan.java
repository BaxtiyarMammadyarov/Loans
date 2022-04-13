package az.mycompany.loans.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Loan {
    BigDecimal amount;
    BigDecimal percentage;
    Integer LoanPeriod;
    LocalDateTime payOutDate;
    List<Invoices> invoices;

}
