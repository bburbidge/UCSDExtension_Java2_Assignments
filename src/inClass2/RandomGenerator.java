
package inClass2;

public final class RandomGenerator {

    public static void main(String args[]) {

        if (args.length < 2 || args.length > 3) {
            System.out
                    .println("usage: test lowerbound and upperbound repetition");
            return;
        }

        int lowerBound = Integer.parseInt(args[0]);
        int upperBound = Integer.parseInt(args[1]);
        int repetition = 1;

        if (args.length == 3)
            repetition = Integer.parseInt(args[2]);

        for (int i = 0; i < repetition; i++) {
            System.out.println("Random Value " + i + "= "
                    + generateRandomValue(lowerBound, upperBound));
        }
    }

    private RandomGenerator() {

    }

    public static int generateRandomValue(int lowerB, int upperB) {

        if (upperB < lowerB)
            return 0;

        if (upperB == lowerB)
            return lowerB;

        return (lowerB + (int) (Math.random() * (upperB - lowerB + 1)));
    }
}
