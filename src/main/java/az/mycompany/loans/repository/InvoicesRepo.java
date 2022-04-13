package az.mycompany.loans.repository;

import az.mycompany.loans.entity.InvoicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoicesRepo extends JpaRepository<InvoicesEntity,Long> {
}
