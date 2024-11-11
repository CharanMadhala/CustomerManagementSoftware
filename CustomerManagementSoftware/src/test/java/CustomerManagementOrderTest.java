/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.Date;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import vit.adda.customermanagementsoftware.Cash;

import vit.adda.customermanagementsoftware.Customer;
import vit.adda.customermanagementsoftware.Item;
import vit.adda.customermanagementsoftware.OrderDetail;
import vit.adda.customermanagementsoftware.Order;
import vit.adda.customermanagementsoftware.Payment;


/**
 *
 * @author chara
 */
public class CustomerManagementOrderTest {
     private Customer customer;
     private Order order;
     private Item item;
     private OrderDetail orderDetail;
     
    public CustomerManagementOrderTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    // Concrete subclass of Order for testing purposes
    
    @BeforeEach
    public void setUp() {
        customer = new Customer("Alex", "Andhra Pradesh, India");
        order = new Order(new Date(), "Processing");
        item = new Item(2.5, "Laptop");
        orderDetail = new OrderDetail(2, "Taxable", item, 2);
        order.addOrderDetail(orderDetail);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @Test
    public void testCustomerDetails(){
        assertEquals("Alex", customer.getName());
        assertEquals("Andhra Pradesh, India", customer.getAddress());
    }
    
    @Test
    void testCalcSubTotal() {
        double expectedSubTotal = item.getPriceForQuantity(2); // Quantity 2
        assertEquals(expectedSubTotal, order.calcSubTotal(), 0.01);
    }
    
    @Test
    void testCalcTax() {
        double expectedTax = order.calcSubTotal() * 0.1; // Assuming 10% tax rate
        assertEquals(expectedTax, order.calcTax(), 0.01);
    }
    
    @Test
    void testCalcTotal() {
        double expectedTotal = order.calcSubTotal() + order.calcTax();
        assertEquals(expectedTotal, order.calcTotal(), 0.01);
    }
    
    @Test
    void testCalcTotalWeight() {
        double expectedWeight = item.getShippingWeight() * 2; // Quantity 2
        assertEquals(expectedWeight, order.calcTotalWeight(), 0.01);
    }
    
    @Test
    void testCashPaymentAuthorization() {
        Payment cashPayment = new Cash(100.0f, 150.0f); // Cash > total amount
        assertTrue(cashPayment.authorized());
    }
    
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
