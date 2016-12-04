package com.capgemini.billingservice;

import com.capgemini.billingservice.exception.MenuItemNotFoundException;
import com.capgemini.billingservice.menu.Menu;
import com.capgemini.billingservice.util.Calculator;

import java.math.BigDecimal;
import java.util.Scanner;

import static com.capgemini.billingservice.util.MenuUtils.DECIMAL_FORMATTER;

/**
 * Created by Petros Christou on 03/12/16.
 */
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.init();  // Initialise menu data
        menu.print(); // Print menu to console

        // Using Scanner to capture customer purchases
        Scanner scanner = new Scanner(System.in);

        // Read the input delimiting on the spaces
        String[] purchases = scanner.nextLine().split(" ");

        menu.display(purchases);
        try {
            Double subTotal = menu.calculateTotalOf(purchases);
            System.out.println("Sub Total: £" + DECIMAL_FORMATTER.format(subTotal));
            Double serviceCharge = menu.calculateServiceCharges(purchases);
            BigDecimal serviceCharges = Calculator.calculateTotalServiceChargesToDecimalPlaces(subTotal, serviceCharge, 2);
            System.out.println("Service Charges: £" + serviceCharges);
            BigDecimal total = Calculator.calculateOverallTotalIncludingServiceChargesToDecimalPlaces(new BigDecimal(subTotal), serviceCharges, 2);
            System.out.println("Total: £" + total);

        } catch (MenuItemNotFoundException e){
            System.err.println("Unable to calculate purchase total, reason: " + e.getMessage());
        }
    }

}
