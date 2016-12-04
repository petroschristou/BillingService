package com.capgemini.billingservice.menu;

import com.capgemini.billingservice.exception.MenuItemNotFoundException;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class MenuTest {

    @Test
    public void testCalculateTotalOfValidPurchase() throws Exception {
        Menu testMenu = new Menu();
        // Reusing main data, really should have a test data set for this
        testMenu.init();

        String[] testPurchases = {"2"};
        Double totalPrice = testMenu.calculateTotalOf(testPurchases);

        Assert.assertEquals(totalPrice, 1D);
    }

    @Test
    public void testCalculateTotalOfValidPurchases() throws Exception {
        Menu testMenu = new Menu();
        // Reusing main data, really should have a test data set for this
        testMenu.init();

        String[] testPurchases = {"1", "1", "3", "4"};
        Double totalPrice = testMenu.calculateTotalOf(testPurchases);

        Assert.assertEquals(totalPrice, 7.5D);
    }

    @Test(expectedExceptions = MenuItemNotFoundException.class)
    public void testCalculateTotalOfUnknownPurchase() throws Exception {
        Menu testMenu = new Menu();
        // Reusing main data, really should have a test data set for this
        testMenu.init();

        String[] testPurchases = {"21111"};
        testMenu.calculateTotalOf(testPurchases);
    }


}