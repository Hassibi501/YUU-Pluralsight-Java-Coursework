package com.pluralsight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = List.of(
                "Fana", "Jack", "Thuan", "Jofre", "Ronell",
                "Sama", "Alexis", "Hassieb", "Leo",
                "Michael", "Andres", "Zurik", "Shawn"
        );

        names.stream()
                .filter(name -> name.length() > 5)
                .sorted()
                .forEach(System.out::println);

        System.out.println("\nEnd Of Program.");
    }
}