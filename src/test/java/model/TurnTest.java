package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TurnTest {

    Turn turn;
    List<Player> players;
    @BeforeEach
    void setUp(){
        turn = new Turn();
        players = new ArrayList<>();
    }
    @Test
    void assignPlayerOrder() {
        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();

        players.add(player1);
        players.add(player2);
        players.add(player3);

        int dice = 6;

        turn.assignPlayerOrder(players, dice);

        assertEquals(6, player1.getNumberDice());
        assertEquals(6, player2.getNumberDice());
        assertEquals(6, player3.getNumberDice());

    }
}