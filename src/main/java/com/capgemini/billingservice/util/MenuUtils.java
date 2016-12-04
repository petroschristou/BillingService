package com.capgemini.billingservice.util;

import java.text.DecimalFormat;

/**
 * Created by Petros Christou on 04/12/16.
 */
public class MenuUtils {
    // These fields should be stored in a database to modify configuration without needing re-releasing code
    public static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("0.00");

    public static final Double SERVICE_CHARGE = 0.10D;

}
