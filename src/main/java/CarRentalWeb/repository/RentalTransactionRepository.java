package CarRentalWeb.repository;

import CarRentalWeb.model.RentalTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Long> {
}