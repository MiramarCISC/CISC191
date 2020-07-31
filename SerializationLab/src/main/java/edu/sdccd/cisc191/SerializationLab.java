package edu.sdccd.cisc191;

import java.io.File;

public class SerializationLab {

    public static void main(String[] args) {
        Customer customer = new Customer(1, "Jack", "Bauer");

        File customerFile = new File("customer.json");
        try {
            Customer.saveJSON(customerFile, customer);
            Customer loadedCustomer = Customer.loadJSON(customerFile);
            System.out.println(loadedCustomer.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}