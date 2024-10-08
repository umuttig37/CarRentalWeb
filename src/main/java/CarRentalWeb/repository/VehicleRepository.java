package CarRentalWeb.repository;

import CarRentalWeb.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByVehicleReg(String vehicleReg);
}