package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TypeTest {

    private Type type;
    @BeforeEach
    void setUp(){
        type = new Type();
    }
    @Test
    void getId() {
        type.setId(5);
        assertEquals(5, type.getId());
    }

    @Test
    void setId() {
        type.setId(15);
        assertEquals(15, type.getId());
    }

    @Test
    void getDescription() {
        type.setDescription("Test description");
        assertEquals("Test description", type.getDescription());
    }

    @Test
    void setDescription() {
        type.setDescription("Another test description");
        assertEquals("Another test description", type.getDescription());
    }

}