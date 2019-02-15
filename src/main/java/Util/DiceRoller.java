package Util;

import java.util.Random;

public class DiceRoller {

        private final Random random = new Random();

        private final int numDice;

        private final int numSides;


        public DiceRoller(int numDice, int numSides) {
            this.numDice = numDice;
            this.numSides = numSides;
        }

        public int roll() {
            int result = 0;
            for (int i = 0; i < numDice; i++)
                result += 1 + random.nextInt(numSides -1);
            return result;
        }

        public int min() {
            return numDice;
        }

        public int max() {
            return (numDice * numSides);
        }

        public double mean() {
            return numDice * (1. + (numSides - 1) / 2.);
        }

        public String toString() {
            final StringBuilder builder = new StringBuilder();
            if (numDice != 1)
                builder.append(numDice);
            builder.append('d');
            builder.append(numSides);
            return builder.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof DiceRoller)) return false;
            DiceRoller that = (DiceRoller) o;
            return numDice == that.numDice && numSides == that.numSides;
        }

        @Override
        public int hashCode() {
            return 31 * (31 * numDice + numSides) + 72;
        }

}
