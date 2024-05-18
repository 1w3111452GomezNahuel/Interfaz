package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyTest {

    Property property;
    Player player;

    @BeforeEach
    void setUp(){
        property = new Property(1, "Test property", 1000, null, "chacra", 200);
        player = new Player();
    }
    @Test
    void testGetPropertyInfo() {
        property.setId(1);
        property.setName("Cordoba 1");
        property.setPrice(100000);
        property.setOwner(player);
        property.setType("Chacra");
        property.setRentalCost(5000);
        property.setOwner(null);

        String propertyInfo = property.getPropertyInfo();

        String expectedInfo = "Property ID: 1\n" +
                "Name: Cordoba 1\n" +
                "Price: 100000\n" +
                "Type: Chacra\n" +
                "Rental Cost: 5000\n" +
                "Owner: None\n";
        assertEquals(expectedInfo, propertyInfo);
    }

    @Test
    void getters(){

        assertEquals(1, property.getId());
        assertEquals("Test property", property.getName());
        assertEquals(1000, property.getPrice());
        assertEquals(null, property.getOwner());
        assertEquals("chacra", property.getType());
        assertEquals(200, property.getRentalCost());
    }
    @Test
    void setters(){

        property.setId(1);
        property.setName("tomas");
        property.setPrice(2000);
        property.setOwner(player);
        property.setType("Estanncia");
        property.setRentalCost(250);

        assertEquals(1, property.getId());
        assertEquals("tomas", property.getName());
        assertEquals(2000, property.getPrice());
        assertEquals(player, property.getOwner());
        assertEquals("Estanncia", property.getType());
        assertEquals(250, property.getRentalCost());

    }
}