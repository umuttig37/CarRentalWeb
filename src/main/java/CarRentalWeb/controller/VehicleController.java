package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
import CarRentalWeb.service.VehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}



/*import CarRentalWeb.model.Vehicle;
import CarRentalWeb.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleController(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @PostMapping("/add")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        vehicleRepository.save(vehicle);
        System.out.println("Vehicle added: " + vehicle.getVehicleReg());
    }

    @PostMapping("/addMultiple")
    public void addMultipleVehicles(@RequestBody List<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
        System.out.println(vehicles.size() + " vehicles added.");
    }
}*/
