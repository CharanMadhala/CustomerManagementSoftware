/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.adda.customermanagementsoftware;

/**
 *
 * @author chara
 */
public class OrderDetail {
    private int quality;
    private int quantity;
    private String taxStatus;
    private Item item;

    public OrderDetail(int quality, String taxStatus, Item item, int quantity) {
        this.quality = quality;
        this.taxStatus = taxStatus;
        this.item = item;
        this.quantity = quantity;
    }

    public double calcSubTotal() {
        return item.getPriceForQuantity(quantity);
    }

    public double calcWeight() {
        return item.getShippingWeight() * quantity;
    }

    public double calcTax() {
        return calcSubTotal() * 0.1; // Assuming 10% tax rate
    }
}
