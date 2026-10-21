import java.util.Arrays;

/**
 * Workbook-2a: Exercises – Test Statistics
 * EXERCISE 3 - pg 79
 */
public class Main {
    public static void main(String[] args) {
        int testScores[] = {85, 90, 78, 92, 88, 91};

        int sum = Arrays.stream(testScores).sum();
        Arrays.sort(testScores);

        int average = sum / testScores.length;

        int highestScore = testScores[testScores.length - 1];
        int lowestScore = testScores[0];

        int middleIndex = testScores.length / 2;

        float median;
        if (testScores.length % 2 == 0) {
            median = (testScores[middleIndex - 1] + testScores[middleIndex]) / 2;
        } else {
            median = testScores[middleIndex];
        }

        System.out.printf("""
                Test Scores: %s
                Average Score: %d
                Highest Score: %d
                Lowest Score: %d
                Median Score: %d
                """, Arrays.toString(testScores), average, highestScore, lowestScore, (int) median);
    }
}
