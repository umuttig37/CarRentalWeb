package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
import CarRentalWeb.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VehicleController {

    private static final Logger logger = LoggerFactory.getLogger(VehicleController.class);
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping("/api/vehicle")
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        logger.info("Returning {} vehicles to the client", vehicles.size());
        return vehicles;
    }

    // New POST method to add multiple vehicles
    @PostMapping("/add")
    public ResponseEntity<?> addMultipleVehicles(@RequestBody List<Vehicle> vehicles) {
        vehicleService.addVehicles(vehicles);  // Calling the service to save vehicles
        logger.info("Added {} vehicles to the database", vehicles.size());
        return ResponseEntity.ok().build();
    }
}