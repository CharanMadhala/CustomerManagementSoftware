/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package vit.adda.customermanagementsoftware;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 *
 * @author chara
 */
public class CustomerManagementSoftware {

    public static void main(String[] args) {
        // Sample customer
        Customer customer = new Customer("Alex Selman", "Andhra Pradesh, India");

        // Sample order
        Order order = new Order(new Date(), "Processing");
        System.out.println("------- Order Details -------");
        System.out.println("Customer name: " + customer.getName());
        System.out.println("Billing Address: " + customer.getAddress());
        System.out.println("Oder date: " + order.getDate());
        
        // Sample item's and order detail
        Item item1 = new Item(2.5, "Laptop");
        OrderDetail orderDetail = new OrderDetail(5, "Taxable", item1, 2);
        order.addOrderDetail(orderDetail);
        
        Item item2 = new Item(3.5, "Desktop");
        OrderDetail orderDetail2 = new OrderDetail(4, "Taxable", item2, 1);
        order.addOrderDetail(orderDetail2);

        // Calculate order totals
        //assuming each item (1 quanntity) costs 10rs
        System.out.println("Subtotal: " + order.calcSubTotal());
        System.out.println("Tax: " + order.calcTax());
        System.out.println("Total Amount: " + order.calcTotal());
        System.out.println("Total Weight: " + order.calcTotalWeight());

        // Sample payment
        Payment payment = new Cash((float)order.calcTotal(), 100.0f);
        System.out.println("Payment Authorized: " + payment.authorized());
        
        //updating order Status
        
        System.out.println("Order status: "+ order.setOrderStatus());
    }
}
