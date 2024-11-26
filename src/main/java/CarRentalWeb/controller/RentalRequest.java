// RentalRequest.java
package CarRentalWeb.controller;

// This class is used to represent a rental request
public class RentalRequest {
    private String vehicleReg;
    private String pickupDate;
    private String dropoffDate;

    // Getters and Setters
    public String getVehicleReg() {
        return vehicleReg;
    }

    public void setVehicleReg(String vehicleReg) {
        this.vehicleReg = vehicleReg;
    }

    public String getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(String pickupDate) {
        this.pickupDate = pickupDate;
    }

    public String getDropoffDate() {
        return dropoffDate;
    }

    public void setDropoffDate(String dropoffDate) {
        this.dropoffDate = dropoffDate;
    }
}