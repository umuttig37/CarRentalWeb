package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public VehicleController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping("/add")
    public void addVehicle(@RequestBody Vehicle vehicle) {
        mongoTemplate.insert(vehicle);
        System.out.println("Vehicle added: " + vehicle.getVehicleId());
    }

    @PostMapping("/addMultiple")
    public void addMultipleVehicles(@RequestBody List<Vehicle> vehicles) {
        mongoTemplate.insertAll(vehicles);
        System.out.println(vehicles.size() + " vehicles added.");
    }
}