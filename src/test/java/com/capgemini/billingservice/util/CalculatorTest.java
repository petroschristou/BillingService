package com.capgemini.billingservice.util;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.capgemini.billingservice.util.Calculator.calculateTotalServiceChargesToDecimalPlaces;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class CalculatorTest {
    @Test
    public void testCalculateValidTotalServiceChargesToDecimalPlaces() throws Exception {

        BigDecimal actual = calculateTotalServiceChargesToDecimalPlaces(100D, 0.10D, 2);

        BigDecimal expected = new BigDecimal(10.00);
        expected = expected.setScale(2, RoundingMode.HALF_UP);

        Assert.assertEquals(actual, expected);

    }

}