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

    @Test
    public void testCalculateServiceChargesOfValidPurchase() throws Exception {
        Menu testMenu = new Menu();
        testMenu.init();

        // Test on cold food - in this instance a cheese sandwich
        String[] testPurchases = {"3"};
        Double serviceCharges = testMenu.calculateServiceCharges(testPurchases);

        Assert.assertEquals(serviceCharges, 0.2D);
    }

    @Test
    public void testCalculateServiceChargesOfValidPurchases() throws Exception {
        Menu testMenu = new Menu();
        testMenu.init();

        // Test on cold food and hot food - in this instance a cheese sandwich & steak sandwich
        String[] testPurchases = {"3", "4"};
        Double serviceCharges = testMenu.calculateServiceCharges(testPurchases);

        Assert.assertEquals(serviceCharges, 0.65D);
    }

}