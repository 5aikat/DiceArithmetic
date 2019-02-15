package model;

public class nDs {

    private int number_of_dice;
    private int number_of_side;

    public nDs(int number_of_dice, int number_of_side){
        this.number_of_dice=number_of_dice;
        this.number_of_side=number_of_side;
    }

    public int getNumber_of_dice() {
        return number_of_dice;
    }

    public void setNumber_of_dice(int number_of_dice) {
        this.number_of_dice = number_of_dice;
    }

    public int getNumber_of_side() {
        return number_of_side;
    }

    public void setNumber_of_side(int number_of_side) {
        this.number_of_side = number_of_side;
    }

    @Override
    public String toString() {
        return "nDs{" +
                "number_of_dice=" + number_of_dice +
                ", number_of_side=" + number_of_side +
                '}';
    }
}
