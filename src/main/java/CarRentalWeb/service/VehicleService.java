package CarRentalWeb.service;

import CarRentalWeb.model.Vehicle;
import CarRentalWeb.repository.VehicleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    private static final Logger logger = LoggerFactory.getLogger(VehicleService.class);
    private final VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        logger.info("Fetched {} vehicles from the database", vehicles.size());
        return vehicles;
    }

    public void addVehicles(List<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);  // Save the list of vehicles to the repository
    }
}