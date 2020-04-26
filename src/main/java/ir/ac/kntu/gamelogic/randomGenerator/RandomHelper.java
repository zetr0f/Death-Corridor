package ir.ac.kntu.gamelogic.randomGenerator;

import java.util.Random;

public final class RandomHelper {

    private static final Random RANDOM_GENERATOR = new Random(System.currentTimeMillis());

    private RandomHelper() {
    }

    public static double nextDouble() {
        return RANDOM_GENERATOR.nextDouble();
    }

    public static boolean nextBoolean() {
        return RANDOM_GENERATOR.nextBoolean();
    }

    public static int nextInt() {
        return RANDOM_GENERATOR.nextInt();
    }

    public static int nextInt(int bound) {
        return RANDOM_GENERATOR.nextInt(bound);
    }

}
