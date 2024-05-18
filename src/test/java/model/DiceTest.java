package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class DiceTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;
    private Dice dice;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    public void setUp() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
        dice = new Dice(1, 4);
    }

    @AfterEach
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    void getId(){
        assertEquals(1, dice.getId());
    }
    @Test
    void setId() {
        dice.setId(5);
        assertEquals(5, dice.getId());
    }
    @Test
    void getNumberFace() {
        assertEquals(4, dice.getNumberFace());
    }
    @Test
    void setNumberFace() {
        dice.setNumberFace(5);
        assertEquals(5, dice.getNumberFace());
    }


    @Test
    void rollDice() {
        Dice dice = new Dice();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        dice.rollDice();
        String output = outputStream.toString().trim();
        assertTrue(output.contains("Random number 1: "));
        assertTrue(output.contains("Random number 2: "));
    }

    @Test
    void dobleDice() {
        Dice dice = new Dice();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        dice.dobleDice(3,3);
        dice.dobleDice(3,3);
        dice.dobleDice(3,3);

        String output = outputStream.toString().trim();
        assertTrue(output.contains("It came out 3 times the repeated number, you go to the police station."));
    }

    /**
     * Esta clase representa el estado que puede tener un jugador
     *
     * Los estados del jugador son ENABLED (habilitado para jugar),
     * DISABLE (deshabilitado por perder el juego) o SUSPENDED (suspendido por perder un turno)
     *
     * @see Player
     *
     */
    public enum StatePlayer {
         ENABLED, DISABLE, SUSPENDED
    }
}