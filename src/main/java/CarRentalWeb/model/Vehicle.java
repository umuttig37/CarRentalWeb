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

    public boolean getVehicleAvailable() {
        return vehicleAvailable;
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
}









/*package CarRentalWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleReg;
    private int vehiclePrice;
    private String vehicleTitle;
    private boolean vehicleAvailable;
    private String vehicleColor;
    private int vehicleYear;
    private int vehiclePeople;
    private String vehicleTransmission;
    private String vehicleFuel;
    private double vehicleConsumption;



    public Long getVehicleReg() { return vehicleReg; }
    public void setVehicleReg(Long vehicleReg) { this.vehicleReg = vehicleReg; }
    public int getVehiclePrice() { return vehiclePrice; }
    public void setVehiclePrice(int vehiclePrice) { this.vehiclePrice = vehiclePrice; }
    public String getVehicleTitle() { return vehicleTitle; }
    public void setVehicleTitle(String vehicleTitle) { this.vehicleTitle = vehicleTitle; }
    public boolean isVehicleAvailable() { return vehicleAvailable; }
    public void setVehicleAvailable(boolean vehicleAvailable) { this.vehicleAvailable = vehicleAvailable; }
    public String getVehicleColor() { return vehicleColor; }
    public void setVehicleColor(String vehicleColor) { this.vehicleColor = vehicleColor; }
    public int getVehicleYear() { return vehicleYear; }
    public void setVehicleYear(int vehicleYear) { this.vehicleYear = vehicleYear; }
    public int getVehiclePeople() { return vehiclePeople; }
    public void setVehiclePeople(int vehiclePeople) { this.vehiclePeople = vehiclePeople; }
    public String getVehicleTransmission() { return vehicleTransmission; }
    public void setVehicleTransmission(String vehicleTransmission) { this.vehicleTransmission = vehicleTransmission; }
    public String getVehicleFuel() { return vehicleFuel; }
    public void setVehicleFuel(String vehicleFuel) { this.vehicleFuel = vehicleFuel; }
    public double getVehicleConsumption() { return vehicleConsumption; }
    public void setVehicleConsumption(double vehicleConsumption) { this.vehicleConsumption = vehicleConsumption; }
}*/