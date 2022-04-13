package az.mycompany.loans.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "invoices")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class InvoicesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    LocalDateTime dueDate;
    Integer LoanPeriod;
    Integer invoiceNr;
    Integer orderNr;
    @ManyToOne(targetEntity = LoanEntity.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "loan_id",referencedColumnName = "id")
    LoanEntity loan;

}
