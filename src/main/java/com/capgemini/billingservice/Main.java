package com.capgemini.billingservice;

import com.capgemini.billingservice.exception.MenuItemNotFoundException;
import com.capgemini.billingservice.menu.Menu;

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
            Double total = menu.calculateTotalOf(purchases);
            System.out.println("Total: £" + DECIMAL_FORMATTER.format(total));
            Double serviceCharges = menu.calculateServiceCharges(purchases);
            System.out.println("Service Charges: £" + DECIMAL_FORMATTER.format(serviceCharges));

        } catch (MenuItemNotFoundException e){
            System.err.println("Unable to calculate purchase total, reason: " + e.getMessage());
        }
    }

}
