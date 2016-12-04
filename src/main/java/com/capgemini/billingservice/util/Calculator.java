package com.capgemini.billingservice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class Calculator {

    public static BigDecimal calculateTotalServiceChargesToDecimalPlaces(Double total, Double serviceCharge, int decimalPlaces){
        Double val = serviceCharge != 0.0D ? total * serviceCharge : 0.0D;
        BigDecimal decimal = new BigDecimal(val);
        return decimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
    }


}
