/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to handle file loading and saving operations.
 */
public class FileLoader {
    // Loads customer data from the specified file and returns a list of strings
    public static List<String> loadCustomerData(String fileName) {
        List<String> customerData = new ArrayList<>();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                customerData.add(line);
            }
            System.out.println("Customer data loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return customerData;
    }

    // Writes the final value and discount applied to a file
    public static void writeToFile(Customer customer, double finalValue) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customerdiscount.txt", true))) {
            writer.write(customer.getFirstName() + " - " + customer.getSecondName() + "\n");
            writer.write(String.format("Final Value: %.2f\n", finalValue));
            writer.write(String.format("Discount Applied: %.0f%%\n", customer.getDiscountRate() * 100));  // Corrigido: substituído \\n por \n
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
