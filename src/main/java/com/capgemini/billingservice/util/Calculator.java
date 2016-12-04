package com.capgemini.billingservice.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.capgemini.billingservice.util.MenuUtils.MAX_SERVICE_CHARGE;
import static com.capgemini.billingservice.util.MenuUtils.SERVICE_CHARGE_HOT_FOOD;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class Calculator {

    public static BigDecimal calculateTotalServiceChargesToDecimalPlaces(Double total, Double serviceCharge, int decimalPlaces){
        Double val = serviceCharge != 0.0D ? total * serviceCharge : 0.0D;

        // Ensure max service charge is applied if hot food and over the limit
        if(serviceCharge.compareTo(SERVICE_CHARGE_HOT_FOOD) == 0 && val > MAX_SERVICE_CHARGE) {
            val = MAX_SERVICE_CHARGE;
        }

        BigDecimal decimal = new BigDecimal(val);
        return decimal.setScale(decimalPlaces, RoundingMode.HALF_UP);
    }

    public static BigDecimal calculateOverallTotalIncludingServiceChargesToDecimalPlaces(BigDecimal subTotal, BigDecimal serviceCharges, int decimalPlaces){
        BigDecimal total = subTotal.add(serviceCharges);
        return total.setScale(decimalPlaces, RoundingMode.HALF_UP);
    }


}
