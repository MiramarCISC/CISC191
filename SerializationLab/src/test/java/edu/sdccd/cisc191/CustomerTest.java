package edu.sdccd.cisc191;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        customer = new Customer(1, "Test", "User");
    }

    @org.junit.jupiter.api.Test
    void getCustomer() {
        assertEquals(customer.toString(), "Customer[id=1, firstName='Test', lastName='User']");
    }

    @org.junit.jupiter.api.Test
    void setCustomer() {
        customer.setFirstName("User");
        customer.setLastName("Test");
        assertEquals(customer.toString(), "Customer[id=1, firstName='User', lastName='Test']");
    }
}