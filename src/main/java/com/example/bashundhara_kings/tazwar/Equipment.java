package model;

import java.io.Serializable;

public class Equipment implements Serializable {
    private String equipmentName;
    private String category;
    private int availableStock;
    private int maxQtyPerRequest;

    public Equipment(String equipmentName, String category, int availableStock, int maxQtyPerRequest) {
        this.equipmentName = equipmentName;
        this.category = category;
        this.availableStock = availableStock;
        this.maxQtyPerRequest = maxQtyPerRequest;
    }

    public String getEquipmentName() { return equipmentName; }
    public void setEquipmentName(String equipmentName) { this.equipmentName = equipmentName; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getAvailableStock() { return availableStock; }
    public void setAvailableStock(int availableStock) { this.availableStock = availableStock; }

    public int getMaxQtyPerRequest() { return maxQtyPerRequest; }
    public void setMaxQtyPerRequest(int maxQtyPerRequest) { this.maxQtyPerRequest = maxQtyPerRequest; }

    @Override
    public String toString() {
        return equipmentName + " [" + category + "]";
    }
}
