package Util;

import Exception.DiceParserException;
import model.nDs;

import java.util.ArrayList;
import java.util.List;

public class diceParser {

    private CharSequence chars;

    private List<DiceRoller> dices;
    private static ArrayList<Character> operations;

    private int offset;

    public diceParser(CharSequence chars) {
        this.chars = chars;
        offset = 0;
        dices = new ArrayList<DiceRoller>() ;
        operations = new ArrayList<Character>();
    }

    public static List<DiceRoller> valueOf(String string) throws DiceParserException {
        return new diceParser(string).parse();
    }

    public List<DiceRoller> parse() throws DiceParserException {
        while(hasNext()) {
            if (isNextAnyOf(' ')) {
                next();
            }
            nDs obj = isnDsnotion();
            dices.add(new DiceRoller(obj.getNumber_of_dice(), obj.getNumber_of_side()));
            if (isNextAnyOf(' ')) {
                next();
            }
            if (isNextAnyOf('+', '-')) {
                operations.add(chars.charAt(offset));
            }
            offset++;
        }
        return dices;
    }

    public nDs isnDsnotion() throws DiceParserException{
        final int numDice = isDigitNext() ? parseInteger() : 1;
        if (numDice < 1)
            throw new DiceParserException(this, "Not enough dice.");

        if (!isNextAnyOf('d', 'D'))
            throw new DiceParserException(this, "Expecting 'D' character.");
        next();

        final int numSides = parseInteger();
        if(!((numSides == 4) || (numSides == 6) ||(numSides == 8) || (numSides == 10) || (numSides == 12)
                || (numSides == 20))){
            throw new DiceParserException(this, "Expecting 4,6,8,10,12,20 side dices only");
        }
        nDs obj = new nDs(numDice,numSides);
        return obj;
    }

    public int parseInteger() throws DiceParserException {
        if (!isDigitNext())
            throw new DiceParserException(this, "Expecting digit.");
        int value = 0;
        do {
            value = value * 10 + (next() - '0');
        } while (isDigitNext());
        return value;
    }

    public boolean isDigitNext() {
        return hasNext() && Character.isDigit(chars.charAt(offset));
    }

    public boolean isNextAnyOf(char... characters) {
        if (!hasNext())
            return false;
        for (char character : characters)
            if (chars.charAt(offset) == character)
                return true;
        return false;
    }

    public char next() throws DiceParserException {
        if (!hasNext())
            throw new DiceParserException(this, "Unexpected end of character sequence.");
        return chars.charAt(offset++);
    }

    public boolean hasNext() {
        return offset < chars.length();
    }

    public void setChars(CharSequence chars) {
        this.chars = chars;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public CharSequence getChars() {
        return chars;
    }

    public int getOffset() {
        return offset;
    }

    public List<DiceRoller> getDices() {
        return dices;
    }

    public void setDices(List<DiceRoller> dices) {
        this.dices = dices;
    }

    public static ArrayList<Character> getOperations() {
        return operations;
    }

    public void setOperations(ArrayList<Character> operations) {
        this.operations = operations;
    }
}