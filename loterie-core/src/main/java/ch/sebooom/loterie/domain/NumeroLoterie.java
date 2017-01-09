package ch.sebooom.loterie.domain;

import java.util.*;

/**
 * Created by seb on .
 * <p>
 * ${VERSION}
 */
public class NumeroLoterie{

        private final Set<Integer> numbers;

        public static final int MIN_NUMBER = 1;
        public static final int MAX_NUMBER = 20;
        public static final int NUM_NUMBERS = 4;

        /**
         * Constructor. Creates random lottery numbers.
         */
        private NumeroLoterie() {
            numbers = new HashSet<>();
            generateRandomNumbers();
        }

        /**
         * Constructor. Uses given numbers.
         */
        private NumeroLoterie(Set<Integer> givenNumbers) {
            numbers = new HashSet<>();
            numbers.addAll(givenNumbers);
        }

        /**
         * @return random LotteryNumbers
         */
        public static NumeroLoterie createRandom() {
            return new NumeroLoterie();
        }

        /**
         * @return given LotteryNumbers
         */
        public static NumeroLoterie create(Set<Integer> givenNumbers) {
            return new NumeroLoterie(givenNumbers);
        }

        /**
         * @return lottery numbers
         */
        public Set<Integer> getNumbers() {
            return Collections.unmodifiableSet(numbers);
        }

        /**
         * @return numbers as comma separated string
         */
        public String getNumbersAsString() {
            List<Integer> list = new ArrayList<>();
            list.addAll(numbers);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < NUM_NUMBERS; i++) {
                builder.append(list.get(i));
                if (i < NUM_NUMBERS - 1) {
                    builder.append(",");
                }
            }
            return builder.toString();
        }

        /**
         * Generates 4 unique random numbers between 1-20 into numbers set.
         */
        private void generateRandomNumbers() {
            numbers.clear();
            RandomNumberGenerator generator = new RandomNumberGenerator(MIN_NUMBER, MAX_NUMBER);
            while (numbers.size() < NUM_NUMBERS) {
                int num = generator.nextInt();
                if (!numbers.contains(num)) {
                    numbers.add(num);
                }
            }
        }

        @Override
        public String toString() {
            return "LotteryNumbers{" + "numbers=" + numbers + '}';
        }

/**
 *
 * Helper class for generating random numbers.
 *
 */
private static class RandomNumberGenerator {

    private PrimitiveIterator.OfInt randomIterator;

    /**
     * Initialize a new random number generator that generates random numbers in the range [min, max]
     *
     * @param min the min value (inclusive)
     * @param max the max value (inclusive)
     */
    public RandomNumberGenerator(int min, int max) {
        randomIterator = new Random().ints(min, max + 1).iterator();
    }

    /**
     * @return a random number in the range (min, max)
     */
    public int nextInt() {
        return randomIterator.nextInt();
    }
}

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (getClass() != obj.getClass()) {
            return false;
        }
        final NumeroLoterie other = (NumeroLoterie) obj;

        return Objects.equals(this.numbers,other.numbers);
    }
}
