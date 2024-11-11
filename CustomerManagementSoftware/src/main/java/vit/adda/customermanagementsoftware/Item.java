/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.adda.customermanagementsoftware;

/**
 *
 * @author chara
 */
public class Item {
    private double shippingWeight;
    private String description;

    public Item(double shippingWeight, String description) {
        this.shippingWeight = shippingWeight;
        this.description = description;
    }

    public double getShippingWeight() {
        return shippingWeight;
    }
    

    public double getPriceForQuantity(int quantity) {
        return 10.0 * quantity; // Assuming each item costs 10.0 units
    }

    public boolean inStock() {
        return true; 
    }
}
