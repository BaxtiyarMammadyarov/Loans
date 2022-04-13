package az.mycompany.loans.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Invoices {

    BigDecimal amount;
    LocalDateTime dueDate;
    Integer LoanPeriod;
    Integer invoiceNr;
    Integer orderNr;

}
