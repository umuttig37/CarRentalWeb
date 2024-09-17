package CarRentalWeb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicles")
public class Vehicle {
    @Id
    private String vehicleId;
    private String vehicleReg;
    private boolean vehicleAvailable;
    private String vehicleColor;
    private String vehicleType;
    private double vehiclePrice;
    private String vehicleModel;
    private String vehicleMF;
    private String vehicleTrans;

    public String getVehicleId() { return vehicleId; }
    public void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    public String getVehicleReg() { return vehicleReg; }
    public void setVehicleReg(String vehicleReg) { this.vehicleReg = vehicleReg; }
    public boolean isVehicleAvailable() { return vehicleAvailable; }
    public void setVehicleAvailable(boolean vehicleAvailable) { this.vehicleAvailable = vehicleAvailable; }
    public String getVehicleColor() { return vehicleColor; }
    public void setVehicleColor(String vehicleColor) { this.vehicleColor = vehicleColor; }
    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }
    public double getVehiclePrice() { return vehiclePrice; }
    public void setVehiclePrice(double vehiclePrice) { this.vehiclePrice = vehiclePrice; }
    public String getVehicleModel() { return vehicleModel; }
    public void setVehicleModel(String vehicleModel) { this.vehicleModel = vehicleModel; }
    public String getVehicleMF() { return vehicleMF; }
    public void setVehicleMF(String vehicleMF) { this.vehicleMF = vehicleMF; }
    public String getVehicleTrans() { return vehicleTrans; }
    public void setVehicleTrans(String vehicleTrans) { this.vehicleTrans = vehicleTrans; }
}