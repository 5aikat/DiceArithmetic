import static java.text.MessageFormat.format;
import Exception.DiceParserException;
import Util.DiceRoller;
import Util.diceParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws DiceParserException {

      String[] examples = {"4D6 + 3D4", "4D6 + 3D25", "0D6 - 1D4", "3D8 - 2D4", "3D8 - 2D4 + 4D6",
              "4D11 + 3D4", "4D6+3D4", "4 D 6 + 3D4", "4d6 + 3D4"};

        //String[] examples = {"3D8 - 2D4 + 4D6"};

        //handling command line inputs
       /** Scanner scanner = new Scanner(System.in);
        ArrayList<String> examples = new ArrayList<String>();
        System.out.println("Enter the number of expressions to evaluate");
        int number = scanner.nextInt();
        for(int i=0; i<number; i++) {
            System.out.println("Enter the dice arithmetic expression to evaluate");
            String input = scanner.next();
            examples.add(input);
        } **/
        for (String example : examples) {
            try {
                System.out.println("---------------------------------");
                System.out.println(format("Pattern to evaluate dice arithmetic : {0}", example));
                System.out.println();
                List<DiceRoller> rollers = diceParser.valueOf(example);
                ArrayList<Character> operations = diceParser.getOperations();
                ArrayList<Integer> random_roll_list = new ArrayList<Integer>();
                int j = 0;
                double random_outcome = 0;
                for (DiceRoller roller : rollers) {
                    System.out.println(format(" {0} -> (expected min={1}, max={2}, mean={3})",
                            roller, roller.min(), roller.max(), roller.mean()));
                    final int repeats = 5;
                    int sum = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                    for (int i = 0; i < repeats; i++) {
                        int roll = roller.roll();
                        min = Math.min(min, roll);
                        max = Math.max(max, roll);
                        sum += roll;
                        System.out.print(roll + " ");
                    }
                    System.out.println();
                    System.out.println(format("After 5 random repeats -> estimate min={0}, max={1}, mean={2}",
                            min, max, ((double) sum / repeats)));
                    System.out.println();
                    int random_roll = roller.roll();
                    System.out.println(format("Random Roll : {0}", random_roll));
                    random_roll_list.add(random_roll);
                }

                //todo
                //make sure order of precedence of operations are maintained, currently (+/-) won't make much difference
                random_outcome = random_roll_list.get(0);
                for (int i = 0; i < operations.size(); i++) {
                    if (operations.get(i) == '+')
                        random_outcome += random_roll_list.get(i + 1);
                    else
                        random_outcome -= random_roll_list.get(i + 1);
                }
                System.out.println(format("Random outcome result of the dice arithmetic on : \"{0}\" is -> {1}"
                        , example, random_outcome));
            } catch (DiceParserException e) {
                System.out.println(format("Caught exception in pattern : {0}",example));
                System.out.println(e.getMessage());
                System.out.println("Handling exception and proceeding with the next example");
                System.out.println();
                continue;
            }
        }
    }
}
