package CarRentalWeb.controller;

import CarRentalWeb.DTO.RentalVehicleResponse;
import CarRentalWeb.model.RentalTransaction;
import CarRentalWeb.model.User;
import CarRentalWeb.model.Vehicle;
import CarRentalWeb.repository.RentalTransactionRepository;
import CarRentalWeb.repository.UserRepository;
import CarRentalWeb.repository.VehicleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RentalController {

    private final RentalTransactionRepository rentalTransactionRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public RentalController(RentalTransactionRepository rentalTransactionRepository, UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.rentalTransactionRepository = rentalTransactionRepository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }
    // This method rents a vehicle for the authenticated user
    @PostMapping("/rent")
    public ResponseEntity<?> rentVehicle(@RequestBody RentalRequest rentalRequest, Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Principal is null");
        }

        String username = principal.getName();
        User authenticatedUser = findByUserName(username); // Assuming default language is "en"

        if (authenticatedUser != null) {
            Vehicle vehicle = vehicleRepository.findByVehicleReg(rentalRequest.getVehicleReg());
            if (vehicle == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vehicle not found");
            }

            LocalDate pickupDate = LocalDate.parse(rentalRequest.getPickupDate());
            LocalDate dropoffDate = LocalDate.parse(rentalRequest.getDropoffDate());

            // Check if the vehicle is already rented during the requested period
            List<RentalTransaction> existingRentals = rentalTransactionRepository.findByVehicle_VehicleReg(rentalRequest.getVehicleReg());
            for (RentalTransaction rental : existingRentals) {
                if ((pickupDate.isBefore(rental.getRentalEndDate()) && dropoffDate.isAfter(rental.getRentalDate())) ||
                        pickupDate.isEqual(rental.getRentalDate()) || dropoffDate.isEqual(rental.getRentalEndDate())) {
                    return ResponseEntity.status(HttpStatus.CONFLICT).body("Vehicle is already rented during the requested period");
                }
            }

            RentalTransaction rentalTransaction = new RentalTransaction();
            rentalTransaction.setUser(authenticatedUser);
            rentalTransaction.setVehicle(vehicle);
            rentalTransaction.setRentalDate(pickupDate);
            rentalTransaction.setRentalEndDate(dropoffDate);

            rentalTransactionRepository.save(rentalTransaction);
            return ResponseEntity.ok("Rental confirmed");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    // This method returns the rentals for the authenticated user
    @GetMapping("/rentals")
    public ResponseEntity<?> getRentals(Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Principal is null");
        }

        String username = principal.getName();
        User authenticatedUser = findByUserName(username);

        // If the authenticated user is not found, return a 404 status code with the message "User not found"
        if (authenticatedUser != null) {
            List<RentalTransaction> rentals = rentalTransactionRepository.findByUser(authenticatedUser);
            List<RentalVehicleResponse> vehicles = rentals.stream()
                    .map(rental -> {
                        Vehicle vehicle = rental.getVehicle();
                        return new RentalVehicleResponse(
                                vehicle.getVehicleReg(),
                                vehicle.getVehicleTitle(),
                                vehicle.getVehicleYear(),
                                vehicle.getVehiclePeople(),
                                vehicle.getVehicleFuel(),
                                vehicle.getVehicleConsumption(),
                                vehicle.getVehicleTransmission(),
                                vehicle.getVehiclePrice(),
                                vehicle.isVehicleAvailable(),
                                vehicle.getImage(),
                                rental.getRentalDate(),
                                rental.getRentalEndDate()
                        );
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.ok(vehicles);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }
    // This method returns the user by username
    private User findByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}