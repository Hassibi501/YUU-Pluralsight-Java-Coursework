public class Dice {
    public int roll() {
        int maxValue = 6;
        int minValue = 1;
        return (int)(Math.random() * (maxValue - minValue + 1)) + minValue;
    }
}
