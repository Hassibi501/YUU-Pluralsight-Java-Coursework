/**
 * Workbook 2a - Exercises - Looping
 * EXERCISE 2 - 66
 */

public class Main {
    public static void main(String[] args) {
        Dice dice = new Dice();

        int rollOne;
        int rollTwo;

        int countRolledTwo = 0;
        int countRolledFour = 0;
        int countRolledSix = 0;
        int countRolledSeven = 0;

        for (int i = 0; i < 100; i++) {
            rollOne = dice.roll();
            rollTwo = dice.roll();

            int sum = rollOne + rollTwo;

            System.out.printf("Roll Number %d: %d - %d  Sum: %d%n", i + 1, rollOne, rollTwo,sum);

            if (sum == 2) {
                countRolledTwo++;
            }
            else if (sum == 4) {
                countRolledFour++;
            }
            else if (sum == 6) {
                countRolledSix++;
            }
            else if (sum == 7) {
                countRolledSeven++;
            }
        }


        System.out.printf("""
            
            Total number of times rolled 2: %d
            Total number of times rolled 4: %d
            Total number of times rolled 6: %d
            Total number of times rolled 7: %d
            """,countRolledTwo, countRolledFour, countRolledSix, countRolledSeven);

    }
}
