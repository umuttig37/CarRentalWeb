package CarRentalWeb.controller;

import CarRentalWeb.model.Vehicle;
import CarRentalWeb.repository.VehicleRepository;
import CarRentalWeb.service.VehicleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class VehicleControllerTest {

    @Autowired
    private VehicleController vehicleController;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleService vehicleService;

    @BeforeEach
    public void setUp() {
        vehicleRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "testUser")
    public void testAddMultipleVehicles() {
        Vehicle vehicle1 = new Vehicle();
        vehicle1.setVehicleReg("REG123");
        vehicle1.setVehicleTitle("Vehicle 1");

        Vehicle vehicle2 = new Vehicle();
        vehicle2.setVehicleReg("REG124");
        vehicle2.setVehicleTitle("Vehicle 2");

        List<Vehicle> vehicles = Arrays.asList(vehicle1, vehicle2);

        vehicleController.addMultipleVehicles(vehicles);
        assertEquals(2, vehicleRepository.findAll().size());
    }
}