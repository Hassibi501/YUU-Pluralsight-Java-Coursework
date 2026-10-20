package com.pluralsight;

import java.util.Scanner;

/**
 * Workbook-2a: Exercises – High Score Wins
 * EXERCISE 3 - pg 20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the game score: ");
        String gameScore = scanner.nextLine().trim();

        String[] scoreParts = gameScore.split("\\|");

        String[] teams = scoreParts[0].split(":");
        String[] teamScores = scoreParts[1].split(":");

        String homeTeam = teams[0];
        String visitingTeam = teams[1];

        int homeScore = Integer.parseInt(teamScores[0]);
        int visitingScore = Integer.parseInt(teamScores[1]);

        if (homeScore > visitingScore) {
            System.out.println("Winner: " + homeTeam);
        } else if (visitingScore > homeScore) {
            System.out.println("Winner: " + visitingTeam);
        } else {
            System.out.println("Winner: Tie!");
        }



    }
}