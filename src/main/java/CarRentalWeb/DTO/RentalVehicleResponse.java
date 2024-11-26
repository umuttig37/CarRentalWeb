package CarRentalWeb.DTO;

import java.time.LocalDate;
// This class is used to represent a rental vehicle response
public class RentalVehicleResponse {
    private final String vehicleReg;
    private final String vehicleTitle;
    private final int vehicleYear;
    private final String vehiclePeople;
    private final String vehicleFuel;
    private final String vehicleConsumption;
    private final String vehicleTransmission;
    private final double vehiclePrice;
    private final boolean vehicleAvailable;
    private final String image;
    private final LocalDate rentalStartDate;
    private final LocalDate rentalEndDate;

    public RentalVehicleResponse(String vehicleReg, String vehicleTitle, int vehicleYear, String vehiclePeople, String vehicleFuel, String vehicleConsumption, String vehicleTransmission, double vehiclePrice, boolean vehicleAvailable, String image, LocalDate rentalStartDate, LocalDate rentalEndDate) {
        this.vehicleReg = vehicleReg;
        this.vehicleTitle = vehicleTitle;
        this.vehicleYear = vehicleYear;
        this.vehiclePeople = vehiclePeople;
        this.vehicleFuel = vehicleFuel;
        this.vehicleConsumption = vehicleConsumption;
        this.vehicleTransmission = vehicleTransmission;
        this.vehiclePrice = vehiclePrice;
        this.vehicleAvailable = vehicleAvailable;
        this.image = image;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
    }

    // Getters
    public String getVehicleReg() {
        return vehicleReg;
    }

    public String getVehicleTitle() {
        return vehicleTitle;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public String getVehiclePeople() {
        return vehiclePeople;
    }

    public String getVehicleFuel() {
        return vehicleFuel;
    }

    public String getVehicleConsumption() {
        return vehicleConsumption;
    }

    public String getVehicleTransmission() {
        return vehicleTransmission;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public boolean isVehicleAvailable() {
        return vehicleAvailable;
    }

    public String getImage() {
        return image;
    }

    public LocalDate getRentalStartDate() {
        return rentalStartDate;
    }

    public LocalDate getRentalEndDate() {
        return rentalEndDate;
    }
}