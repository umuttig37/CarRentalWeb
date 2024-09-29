package CarRentalWeb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vehicleId;
    private int vehiclePrice;
    private String vehicleName;
    private boolean vehicleAvailable;
    private String vehicleColor;
    private String vehicleMf;
    private String vehicleModel;
    private String vehicleReg;
    private String vehicleTrans;
    private String vehicleType;

    public Long getVehicleId() { return vehicleId; }
    public void setVehicleId(Long vehicleId) { this.vehicleId = vehicleId; }
    public int getVehiclePrice() { return vehiclePrice; }
    public void setVehiclePrice(int vehiclePrice) { this.vehiclePrice = vehiclePrice; }
    public String getVehicleName() { return vehicleName; }
    public void setVehicleName(String vehicleName) { this.vehicleName = vehicleName; }
    public boolean isVehicleAvailable() { return vehicleAvailable; }
    public void setVehicleAvailable(boolean vehicleAvailable) { this.vehicleAvailable = vehicleAvailable; }
    public String getVehicleColor() { return vehicleColor; }
    public void setVehicleColor(String vehicleColor) { this.vehicleColor = vehicleColor; }
    public String getVehicleMf() { return vehicleMf; }
    public void setVehicleMf(String vehicleMf) { this.vehicleMf = vehicleMf; }
    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
    public String getVehicleReg() { return vehicleReg; }
    public void setVehicleReg(String vehicleReg) { this.vehicleReg = vehicleReg; }
    public String getVehicleTrans() { return vehicleTrans; }
    public void setVehicleTrans(String vehicleTrans) { this.vehicleTrans = vehicleTrans; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
}