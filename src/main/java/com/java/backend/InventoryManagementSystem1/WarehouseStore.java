package com.java.backend.InventoryManagementSystem1;

import java.util.ArrayList;
import java.util.List;
public class WarehouseStore<T extends Product> {
    private List<T> inventory;
    public WarehouseStore() {
        inventory = new ArrayList<>();
    }
    //Add product to inventory
    public void addProduct(T product) {
        inventory.add(product);
    }
    //remove product from inventory by id
    public boolean removeProduct(String id) {
        return inventory.removeIf(product -> product.getId().equals(id));
    }
    //search by category
    public List<T> searchByCategory(String category) {
        List<T> products = new ArrayList<>();
        for (T product : inventory) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                products.add(product);
            }
        }
        return products;
    }
   public List<T> getAllProducts() {
        return inventory;
   }

}

