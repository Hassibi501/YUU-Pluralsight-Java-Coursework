package com.pluralsight;

import java.math.BigDecimal;

/**
 * Workbook 4a: Exercise - BigDecimal
 * EXERCISE 3 - pg 72
 */

public class Main {
    public static void main(String[] args) {
        float aFloat = 0f;
        double aDouble = 0;
        BigDecimal aBigDecimal = new BigDecimal("0");

        System.out.printf("""
                Original Value of Variables (before the loop):
                aFloat = %s
                aDouble = %s
                aBigDecimal = %s
                
                """, aFloat, aDouble, aBigDecimal);

        System.out.println("Value of Variables (during first loop):");
        for(int i = 0; i < 10; i++) {
            aFloat += 0.10f;
            aDouble += 0.10;
            aBigDecimal = aBigDecimal.add(new BigDecimal("0.10"));

            System.out.printf("| aFloat = %s | aDouble = %s | aBigDecimal = %s |%n", aFloat, aDouble, aBigDecimal);
        }

        System.out.printf("""
                
                Value of Variables (after first loop):
                aFloat = %s
                aDouble = %s
                aBigDecimal = %s
                """, aFloat, aDouble, aBigDecimal);

        aFloat = 0f;
        aDouble = 0;
        aBigDecimal = new BigDecimal("0");

        for(int i = 0; i < 1000; i++) {
            aFloat += 19.99f;
            aDouble += 19.99;
            aBigDecimal = aBigDecimal.add(new BigDecimal("19.99"));
        }

        System.out.printf("""
                
                Value of Variables (after second loop and reset back to 0 before second loop started):
                aFloat = %s
                aDouble = %s
                aBigDecimal = %s
                """, aFloat, aDouble, aBigDecimal);



    }
}
