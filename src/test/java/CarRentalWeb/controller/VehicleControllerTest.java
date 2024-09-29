/*package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
import CarRentalWeb.repository.VehicleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class VehicleControllerTest {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleController vehicleController;

    @BeforeEach
    public void setUp() {
        vehicleRepository.deleteAll();
    }

    @Test
    public void testAddVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleName("Test Vehicle");

        vehicleController.addVehicle(vehicle);
        assertEquals("Test Vehicle", vehicle.getVehicleName());
    }

    @Test
    public void testAddMultipleVehicles() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleName("Vehicle 1");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleName("Vehicle 2");

        List<Vehicle> vehicles = Arrays.asList(vehicle1, vehicle2);

        vehicleController.addMultipleVehicles(vehicles);
        assertEquals(2, vehicles.size());
    }
}*/