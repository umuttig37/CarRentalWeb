package CarRentalWeb.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @Column(nullable = false, unique = true)
    private String vehicleReg;
    private String vehicleTitle;
    private int vehicleYear;
    private String vehiclePeople;
    private String vehicleFuel;
    private String vehicleConsumption;
    private String vehicleTransmission;
    private double vehiclePrice;
    private boolean vehicleAvailable;
    private String image;

    // Getters and setters

    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getVehicleTitle() {
        return vehicleTitle;
    }

    public void setVehicleTitle(String vehicleTitle) {
        this.vehicleTitle = vehicleTitle;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public String getVehiclePeople() {
        return vehiclePeople;
    }

    public void setVehiclePeople(String vehiclePeople) {
        this.vehiclePeople = vehiclePeople;
    }

    public String getVehicleFuel() {
        return vehicleFuel;
    }

    public void setVehicleFuel(String vehicleFuel) {
        this.vehicleFuel = vehicleFuel;
    }

    public String getVehicleConsumption() {
        return vehicleConsumption;
    }

    public void setVehicleConsumption(String vehicleConsumption) {
        this.vehicleConsumption = vehicleConsumption;
    }

    public String getVehicleTransmission() {
        return vehicleTransmission;
    }

    public void setVehicleTransmission(String vehicleTransmission) {
        this.vehicleTransmission = vehicleTransmission;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public void setVehicleAvailable(boolean vehicleAvailable) {
        this.vehicleAvailable = vehicleAvailable;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isVehicleAvailable() {
        return vehicleAvailable;
    }
}