package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

/**
 * Workbook-6a : Exercise - Interfaces
 * EXERCISE 2 - pg 38
 */

public class Main {
    public static void main(String[] args) {
        List<Person> aFamily = new ArrayList<Person>();
        aFamily.add( new Person("Dana", "Wyatt", 63) );
        aFamily.add( new Person("Zachary", "Westly", 31) );
        aFamily.add( new Person("Elisha", "Aslan", 14) );
        aFamily.add( new Person("Ian", "Auston", 16) );
        aFamily.add( new Person("Zephaniah", "Hughes", 9) );
        aFamily.add( new Person("Ezra", "Aiden", 17) );

        System.out.println("End Of Program");


    }
}