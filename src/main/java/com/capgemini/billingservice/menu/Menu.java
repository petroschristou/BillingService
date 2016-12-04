package com.capgemini.billingservice.menu;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class Menu {

    // Data structure holding the items within the menu
    private Map<String, MenuItem> menu = new HashMap<>();

    /**
     * Load data into Menu
     */
    public void init() {
        // Should really have this in a database so it's fully configurable etc, but using a builder pattern just to force all input correctly etc
        menu.put("1", new MenuItem.Builder().forName("Cola").forType(MenuItemType.ColdDrink).withPrice(0.50D).build());
        menu.put("2", new MenuItem.Builder().forName("Coffee").forType(MenuItemType.HotDrink).withPrice(1.00D).build());
        menu.put("3", new MenuItem.Builder().forName("Cheese Sandwich").forType(MenuItemType.ColdFood).withPrice(2.00D).build());
        menu.put("4", new MenuItem.Builder().forName("Steak Sandwich").forType(MenuItemType.HotFood).withPrice(4.50D).build());
    }

    /**
     * Simple method to output to the console the menu items and their corresponding selection number
     */
    public void print(){
        System.out.println("Welcome to Cafe X Menu");
        // Traverse the map and output the key and it's item
        menu.forEach((key, value) -> {
            System.out.println(key + " : " + value.getName());
        });
        System.out.println("Please select which item number you wish to purchase from the menu separated by a space: ");
    }
}
