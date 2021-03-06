package com.capgemini.billingservice.menu;

import com.capgemini.billingservice.exception.MenuItemNotFoundException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.capgemini.billingservice.util.MenuUtils.DECIMAL_FORMATTER;
import static com.capgemini.billingservice.util.MenuUtils.SERVICE_CHARGE_FOOD;
import static com.capgemini.billingservice.util.MenuUtils.SERVICE_CHARGE_HOT_FOOD;

/**
 * Created by Petros Christou on 03/12/16.
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

    public void display(String[] purchases){
        // Traverse the map and output the key and it's item
        Arrays.stream(purchases).forEach((key) -> {
            MenuItem item = menu.get(key);
            System.out.println(key + " : " + item.getName() + " £" + DECIMAL_FORMATTER.format(item.getPrice()));
        });
    }

    public Double calculateTotalOf(String[] purchases) throws MenuItemNotFoundException {
        Double total = 0D;
        // Used traditional for loop here as lamda expressions need final automatic variables and I didn't want to set the total at a class level.
        for(String purchase : purchases){
            MenuItem item = menu.get(purchase);

            if(item == null) {
                throw new MenuItemNotFoundException("Unable to find menu item with key reference: " + purchase);
            }

            total += item.getPrice();
        }
        return total;
    }

    public Double calculateServiceCharges(String[] purchases) throws MenuItemNotFoundException {
        Double serviceCharge = 0.0D;
        for(String purchase : purchases){
            MenuItem item = menu.get(purchase);
            if(item.getType() == MenuItemType.HotFood) {
                return SERVICE_CHARGE_HOT_FOOD; // Send this straight back as the highest charge
            }
            if(item.getType() == MenuItemType.ColdFood) {
                serviceCharge = SERVICE_CHARGE_FOOD; // Keep this in case while iterating there may be hot food purchased
            }
        }
        return serviceCharge;
    }

}
