package com.capgemini.billingservice.menu;

import org.testng.Assert;

/**
 * Created by Petros Christou on 03/12/16.
 */
public class MenuItem {
    private final String name;
    private final MenuItemType type;
    private final Double price;

    private MenuItem(String name, MenuItemType type, Double price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuItemType getType() {
        return type;
    }

    public Double getPrice() {
        return price;
    }

    public static class Builder {
        private String name;
        private MenuItemType type;
        private Double price;

        public Builder() {
        }

        Builder forName(String name) {
            this.name = name;
            return this;
        }

        Builder forType(MenuItemType type) {
            this.type = type;
            return this;
        }

        Builder withPrice(Double price) {
            this.price = price;
            return this;
        }

        MenuItem build() {
            Assert.assertNotNull(name, "Menu item name must not be null");
            Assert.assertNotNull(name, "Menu item type must not be null");
            Assert.assertNotNull(name, "Menu item price must not be null");

            return new MenuItem(name, type, price);
        }


    }
}
