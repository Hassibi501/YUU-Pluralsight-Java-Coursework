package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Workshop 6a: Exercises — Traditional Loops
 * EXERCISE 1 - pg 68
 */

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> listOfPeople = new ArrayList<>(List.of(
                new Person("Liam", "Carter", 28),
                new Person("Maya", "Lin", 34),
                new Person("Zoe", "Patel", 22),
                new Person("Elena", "Rostova", 41),
                new Person("Caleb", "Brooks", 19),
                new Person("Zoe", "Kim", 26),
                new Person("Zoe", "Silva", 31),
                new Person("Hannah", "Abbott", 45),
                new Person("Owen", "Murphy", 24),
                new Person("Aria", "Chen", 37)
        ));

        System.out.println("Enter first or last name to search for:");

        String name = scanner.nextLine().trim();

        List<Person> matchedPeople = new ArrayList<>();

        int sum = 0;
        int youngestAge = listOfPeople.get(0).getAge();
        int oldestAge = listOfPeople.get(0).getAge();


        for (Person person : listOfPeople) {
            int age = person.getAge();
            sum += age;
            youngestAge = Math.min(age, youngestAge);
            oldestAge = Math.max(age, oldestAge);


            if (person.getFirstName().equalsIgnoreCase(name)) {
                matchedPeople.add(person);
                System.out.println("Found person: " + person.getFirstName() + " " + person.getLastName());
            }
        }

        System.out.println();

        System.out.println("Average age: " + sum / listOfPeople.size());
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);

        System.out.println("End Of Program.");
    }
}
