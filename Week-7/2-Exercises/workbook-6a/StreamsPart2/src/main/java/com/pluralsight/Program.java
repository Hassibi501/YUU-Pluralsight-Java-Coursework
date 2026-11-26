package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Workshop 6a: Exercises - Streams
 * EXERCISE 2 - pg 83
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

        double averageAge = listOfPeople.stream()
                .mapToInt(Person::getAge)
                .average()
                .orElse(0);

        int oldestAge = listOfPeople.stream()
                .mapToInt(Person::getAge)
                .max()
                .orElse(0);

        int youngestAge = listOfPeople.stream()
                .mapToInt(Person::getAge)
                .min()
                .orElse(0);


        System.out.print("Enter first or last name to search for: ");

        String name = scanner.nextLine().trim();


        List<Person> matchedPeople = listOfPeople.stream()
                .filter(person -> person.getFirstName().equalsIgnoreCase(name))
                .toList();

        System.out.println();
        matchedPeople.forEach(person -> System.out.println("Found person: " + person.getFirstName() + " " + person.getLastName()));

        System.out.println();

        System.out.println("Average age: " + averageAge);
        System.out.println("Oldest age: " + oldestAge);
        System.out.println("Youngest age: " + youngestAge);

        System.out.print("\nEnd Of Program.");
        scanner.close();
    }
}
