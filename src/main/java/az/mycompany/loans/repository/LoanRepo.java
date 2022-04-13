package az.mycompany.loans.repository;


import az.mycompany.loans.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface LoanRepo extends JpaRepository<LoanEntity,Long> {


}
