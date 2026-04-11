package com.example.bashundhara_kings.tazwar;

import com.example.bashundhara_kings.tazwar.Equipment;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerRequestEquipmentController {

    @FXML private TableView<Equipment> equipmentTable;
    @FXML private TableColumn<Equipment, String> equipNameCol;
    @FXML private TableColumn<Equipment, String> categoryCol;
    @FXML private TableColumn<Equipment, Integer> stockCol;
    @FXML private TableColumn<Equipment, Integer> maxQtyCol;
    @FXML private Label selectedItemLabel;
    @FXML private TextField quantityField;
    @FXML private Label statusLabel;

    private final String EQUIPMENT_FILE = "equipment.dat";

    @FXML
    public void initialize() {
        equipNameCol.setCellValueFactory(new PropertyValueFactory<>("equipmentName"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        stockCol.setCellValueFactory(new PropertyValueFactory<>("availableStock"));
        maxQtyCol.setCellValueFactory(new PropertyValueFactory<>("maxQtyPerRequest"));

        List<Equipment> items = loadFromFile();
        if (items.isEmpty()) {
            // Load sample data if file is empty
            items.add(new Equipment("Football", "Ball", 10, 2));
            items.add(new Equipment("Shin Guards", "Protective", 20, 2));
            items.add(new Equipment("Training Cones", "Gear", 50, 5));
            items.add(new Equipment("Goalkeeper Gloves", "Gear", 8, 1));
            items.add(new Equipment("Training Bib", "Gear", 30, 3));
        }
        equipmentTable.setItems(FXCollections.observableArrayList(items));

        // Update label when row is selected
        equipmentTable.getSelectionModel().selectedItemProperty().addListener((obs, old, selected) -> {
            if (selected != null) {
                selectedItemLabel.setText(selected.getEquipmentName());
            }
        });
    }

    @FXML
    public void submitRequest(ActionEvent event) {
        Equipment selected = equipmentTable.getSelectionModel().getSelectedItem();
        String qtyText = quantityField.getText().trim();

        if (selected == null) {
            statusLabel.setText("Please select an equipment item.");
            return;
        }
        if (qtyText.isEmpty()) {
            statusLabel.setText("Please enter a quantity.");
            return;
        }

        int qty;
        try {
            qty = Integer.parseInt(qtyText);
        } catch (NumberFormatException e) {
            statusLabel.setText("Quantity must be a number.");
            return;
        }

        if (qty <= 0) {
            statusLabel.setText("Quantity must be greater than zero.");
            return;
        }
        if (qty > selected.getAvailableStock()) {
            statusLabel.setText("Insufficient stock. Available: " + selected.getAvailableStock());
            return;
        }
        if (qty > selected.getMaxQtyPerRequest()) {
            statusLabel.setText("Exceeds max allowed per request: " + selected.getMaxQtyPerRequest());
            return;
        }

        // Deduct stock and save
        selected.setAvailableStock(selected.getAvailableStock() - qty);
        saveToFile(new ArrayList<>(equipmentTable.getItems()));
        equipmentTable.refresh();
        quantityField.clear();
        statusLabel.setText("Equipment request submitted successfully!");
    }

    private void saveToFile(List<Equipment> items) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(EQUIPMENT_FILE))) {
            out.writeObject(items);
        } catch (IOException e) { e.printStackTrace(); }
    }

    @SuppressWarnings("unchecked")
    private List<Equipment> loadFromFile() {
        File file = new File(EQUIPMENT_FILE);
        if (!file.exists()) return new ArrayList<>();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(EQUIPMENT_FILE))) {
            return (List<Equipment>) in.readObject();
        } catch (Exception e) { return new ArrayList<>(); }
    }
}
