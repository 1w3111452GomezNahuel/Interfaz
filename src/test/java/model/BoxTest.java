package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoxTest {
    private Box box;
    private Board board;
    List<Property> listProperty;
    List<Type> listTypes;
    @BeforeEach
    void setUp(){
        board = new Board();
        listProperty = new ArrayList<>();
        listTypes = new ArrayList<>();
        box = new Box(1, board, listProperty, listTypes, 5);
    }

    @Test
    void getters() {

        assertEquals(1, box.getId());
        assertEquals(board, box.getBoard());
        assertEquals(listProperty, box.getProperties());
        assertEquals(listTypes, box.getType());
        assertEquals(5, box.getPosition());
    }

    @Test
    void setters() {
        box.setId(2);
        assertEquals(2, box.getId());

        box.setBoard(board);
        assertEquals(board, box.getBoard());

        box.setProperties(listProperty);
        assertEquals(listProperty, box.getProperties());

        box.setType(listTypes);
        assertEquals(listTypes, box.getType());

        box.setPosition(6);
        assertEquals(6, box.getPosition());
    }


//    @Test
//    void descriptionAndAction() {
//    }
//
//    @Test
//    void activateAction() {
//    }

    @Test
    void hasOwner() {
        assertFalse(box.HasOwner(1));
    }
}