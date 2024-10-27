/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca1;

/**
 * Class to calculate discount based on customer class and last purchase year.
 */
public class DiscountCalculator {
    
    public static double calculateDiscountedValue(Customer customer) {
        double discountRate = 0;
        int customerClass = customer.getCustomerClass();
        int lastPurchaseYear = customer.getLastPurchaseYear();
        
        switch (customerClass) {
            case 1:
                if (lastPurchaseYear == 2024) discountRate = 0.30;
                else if (lastPurchaseYear < 2024 && lastPurchaseYear >= 2019) discountRate = 0.20;
                else discountRate = 0.10;
                break;
            case 2:
                if (lastPurchaseYear == 2024) discountRate = 0.15;
                else if (lastPurchaseYear < 2024 && lastPurchaseYear >= 2019) discountRate = 0.13;
                else discountRate = 0.05;
                break;
            case 3:
                if (lastPurchaseYear == 2024) discountRate = 0.03;
                else discountRate = 0.00;
                break;
        }
        
        customer.setDiscountRate(discountRate);
        return customer.getTotalPurchase() - (customer.getTotalPurchase() * discountRate);
    }
}

    

