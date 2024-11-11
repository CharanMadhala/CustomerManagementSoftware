/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vit.adda.customermanagementsoftware;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author chara
 */
public class Order {
    private Date date;
    private String status;
    private List<OrderDetail> orderDetails;

    public Order(Date date, String status) {
        this.date = date;
        this.status = status;
        this.orderDetails = new ArrayList<>();
    }

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetails.add(orderDetail);
    }

    
    public double calcSubTotal() { 
        double subTotal = 0;
        for (OrderDetail detail : orderDetails) {
            subTotal += detail.calcSubTotal();
        }
        return subTotal;
    }

    public double calcTax() {
        return calcSubTotal() * 0.1; // Assuming 10% tax rate
    }

    public double calcTotal() {
        return calcSubTotal() + calcTax();
    }
    //Calculating total weight of all orders
    public double calcTotalWeight() {
        double totalWeight = 0;
        for (OrderDetail detail : orderDetails) {
            totalWeight += detail.calcWeight();
        }
        return totalWeight;
    }
    public Date getDate(){
        return date;
    }
    public String setOrderStatus(){
        return this.status = "successful";
    }
}
