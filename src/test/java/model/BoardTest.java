package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;
    private List<Box> boxList;
    private Player[] players;

    @BeforeEach
    public void setUp(){
        boxList = new ArrayList<>();
        boxList.add(new Box());
        boxList.add(new Box());
        players = new Player[4];
        board = new Board(boxList, players);
    }

    @Test
    void getBoxPosition() {
        int expectedPosition = 0;
        int actualPosition = board.getBoxPosition();

        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void setPlayerPosition_ValidPosition() {
        int playerIndex = 0;
        int newPosition = 5;

        Player realPlayer = new Player();
        board.setPlayer(playerIndex, realPlayer);

        board.setPlayerPosition(playerIndex, newPosition);

        assertEquals(playerIndex, realPlayer.getPosition());
    }
    @Test
    void setPlayerPosition_InvalidPosition() {
        int playerIndex = 0;
        int newPosition = -1;

        Player realPlayer = new Player();
        board.setPlayer(playerIndex, realPlayer);

        board.setPlayerPosition(playerIndex, newPosition);

        assertEquals(0, realPlayer.getPosition());
    }

    @Test
    void isValidMove_ValidMove() {
        int playerIndex = 0;
        int steps = 2;
        int currentPosition = 6;

        players[playerIndex] = new Player();
        players[playerIndex].setPosition(currentPosition);

        boolean isValid = board.isValidMove(playerIndex, steps);
        assertFalse(isValid);
    }

    @Test
    void isValidMove_InvalidMove() {
        int playerIndex = 0;
        int steps = 5;
        int currentPosition = 2;

        players[playerIndex] = new Player();
        players[playerIndex].setPosition(currentPosition);

        boolean isValid = board.isValidMove(playerIndex, steps);
        assertFalse(isValid);

    }
    @Test
    void movePlayer_ValidMove() {
        for (int i = 0; i < 42; i++){
            boxList.add(new Box());
        }

        players[0] = new Player();
        players[1] = new Player();

        board = new Board(boxList, players);

        board.movePlayer(0, 5);

        assertEquals(5, board.getPlayer()[0].getPosition());
        assertEquals(5, board.getPosition());
    }
    @Test
    void movePlayer_InvalidMove() {
        int playerIndex = 0;
        int steps = -5;
        int currentPosition = 7;

        players[playerIndex] = new Player();
        players[playerIndex].setPosition(currentPosition);
        board.movePlayer(playerIndex, steps);
        assertEquals(playerIndex, board.getBoxPosition());
    }

    @Test
    void getBoxList() {
        assertEquals(boxList, board.getBoxList());
    }

    @Test
    void setBoxList() {
        List<Box> newListBox = new ArrayList<>();
        newListBox.add(new Box());
        newListBox.add(new Box());
        board.setBoxList(newListBox);
        assertEquals(newListBox, board.getBoxList());

    }

    @Test
    void getPlayer() {
        assertEquals(players, board.getPlayer());
    }

    @Test
    void setPlayer() {
        Player[] newPlayers = new Player[3];
        newPlayers[0] = new Player();
        newPlayers[1] = new Player();
        newPlayers[2] = new Player();
        board.setPlayer(newPlayers);
        assertEquals(newPlayers, board.getPlayer());
    }

    @Test
    void getPosition() {
        assertEquals(0, board.getPosition());
    }

    @Test
    void setPosition() {
        int position = 10;
        board.setPosition(position);
        assertEquals(position, board.getPosition());
    }

    @Test
    void testSetPlayer() {
        int playerIndex = 1;
        Player realPlayer = new Player();
        board.setPlayer(playerIndex, realPlayer);
        assertEquals(realPlayer, board.getPlayer()[playerIndex]);
    }
}