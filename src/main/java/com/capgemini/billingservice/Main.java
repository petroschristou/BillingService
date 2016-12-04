package com.capgemini.billingservice;

import com.capgemini.billingservice.menu.Menu;
import java.util.Scanner;

/**
 * Created by Petros Christou on 04/12/16.
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
    }

}
