package CarRentalWeb.repository;

import CarRentalWeb.model.RentalTransaction;
import CarRentalWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Long> {

    List<RentalTransaction> findByUser(User user);

    List<RentalTransaction> findByVehicle_VehicleReg(String vehicleReg);
}