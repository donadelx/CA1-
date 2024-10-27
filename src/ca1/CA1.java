/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1;

import java.util.List;

/**
 * Main class to handle customer discount calculations.
 * GitHub Repository Link: https://github.com/donadelx/CA1-
 */
public class CA1 {

    public static void main(String[] args) {
        
        // Load customer data from file
        List<String> customerData = FileLoader.loadCustomerData("customers.txt");
        
        // Process each customer in blocks of 4 lines
        for (int i = 0; i + 3 < customerData.size(); i += 4) {  // Check if there are at least 4 lines remaining
            String fullName = customerData.get(i);
            String totalPurchaseStr = customerData.get(i + 1);
            String classStr = customerData.get(i + 2);
            String lastPurchaseYearStr = customerData.get(i + 3);
            
            // Split the full name into first and second names
            String[] nameParts = fullName.split(" ", 2);
            String firstName = nameParts[0];
            String secondName = nameParts.length > 1 ? nameParts[1] : "";

            // Create Customer object and validate data
            Customer customer = new Customer(firstName, secondName, totalPurchaseStr, classStr, lastPurchaseYearStr);
            if (customer.isValid()) {
                // Valid data - calculate final value with discount
                double finalValue = DiscountCalculator.calculateDiscountedValue(customer);
                
                // Write the result to the output file
                FileLoader.writeToFile(customer, finalValue);
                
                // Display result in console for verification
                System.out.printf("%s %s - Final Value: %.2f, Discount Applied: %.0f%%%n",
                                  customer.getFirstName(), customer.getSecondName(), finalValue, customer.getDiscountRate() * 100);
            } else {
                // Invalid data - display detailed error message
                System.out.println("Error with customer data:\n" + customer.getValidationMessage());
            }
        }
        
        System.out.println("Processing complete. Discounts calculated, saved, and displayed in console.");
    }
}
