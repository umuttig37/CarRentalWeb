package CarRentalWeb.repository;

import CarRentalWeb.model.RentalTransaction;
import CarRentalWeb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// This is the repository for the RentalTransaction entity
@Repository
public interface RentalTransactionRepository extends JpaRepository<RentalTransaction, Long> {
    // This method finds all rental transactions by user
    List<RentalTransaction> findByUser(User user);
    // This method finds all rental transactions by vehicle registration
    List<RentalTransaction> findByVehicle_VehicleReg(String vehicleReg);
}