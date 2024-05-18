package model;

import java.util.Random;

public class Dice {
    //Attributes----------------

    private int id;
    private int numberFace;
    private int counter;

    //Constructor----------------
    public Dice(int id, int numberFace) {
        this.id = id;
        this.numberFace = numberFace;
    }

    public Dice() {
    }

    //getter and setter----------------
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberFace() {
        return numberFace;
    }

    public void setNumberFace(int numberFace) {
        this.numberFace = numberFace;
    }

    //Methods----------------
    public void rollDice() {

        Random rand = new Random();
        int dado1 = 0;
        int dado2 = 0;

        for (int i = 0; i < 2; i++) {
            int randomNumber = rand.nextInt(6) + 1;
            System.out.println("Random number " + (i + 1) + ": " + randomNumber);
            if (i == 0) {
                dado1 = randomNumber;
            }
            if (i == 1) {
                dado2 = randomNumber;
            }
        }
        dobleDice(dado2,dado2);
    }

    public void dobleDice(int dado1, int dado2) {

        if (dado1==dado2){
            counter += 1;
        }else counter = 0;

        if (counter == 3){
            System.out.println("It came out 3 times the repeated number, you go to the police station.");
        }
    }

}




