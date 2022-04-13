package az.mycompany.loans.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "loans")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoanEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    BigDecimal amount;
    BigDecimal percentage;
    Integer LoanPeriod;
    LocalDateTime payOutDate;
    @ManyToOne(targetEntity = UserEntity.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",referencedColumnName = "clientUniqueId")
    @JsonIgnore
    UserEntity userEntity;
    @OneToMany(mappedBy = "loan",cascade = CascadeType.ALL)
    List<InvoicesEntity> invoices;

}
