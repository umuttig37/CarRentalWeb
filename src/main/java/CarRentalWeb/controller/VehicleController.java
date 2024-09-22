package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
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
        System.out.println("Vehicle added: " + vehicle.getVehicleId());
    }

    @PostMapping("/addMultiple")
    public void addMultipleVehicles(@RequestBody List<Vehicle> vehicles) {
        vehicleRepository.saveAll(vehicles);
        System.out.println(vehicles.size() + " vehicles added.");
    }
}