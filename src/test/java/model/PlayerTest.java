package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player1;
    private Player player2;
    private Property property1;
    private Property property2;


    @BeforeEach
    void setUp() {
        List<Property> properties1 = new ArrayList<>();
        List<Property> properties2 = new ArrayList<>();
        property1 = new Property();
        property1.setName("Property 1");
        property1.setPrice(1000);
        property2 = new Property();
        property2.setName("Property 2");
        property2.setPrice(1500);

        properties1.add(property1);
        properties2.add(property2);

        player1 = new Player("Player 1", 1000, properties1, "Red", 0, "Human", 2, null);
        player2 = new Player("Player 2", 1500, properties2, "Blue", 0, "Console", 1, null);
    }
    @Test
    void getPlayerInfo() {
        String expectedInfo =   "Player ID: 0\n" +
                "Name: Player 1\n" +
                "Money: 1000\n" +
                "Color: Red\n" +
                "Position: 0\n" +
                "User Type: Human\n" +
                "Properties: \n" +
                "\t- Property 1\n";

        String actualInfo = player1.getPlayerInfo();

        assertEquals(expectedInfo, actualInfo);
    }

    @Test
    void testSellProperty_Valid() {
        player1.getProperties().add(property1);
        // comprador
        player1.sellProperty(player2, property1);

        assertEquals(1000, player1.getMoney());
        assertNull(property1.getOwner());
    }
    @Test
    void testSellProperty_Invalid() {
        // intentar vender una propiedad que el jugador no posee
        assertThrows(IllegalArgumentException.class, () -> {
            player2.sellProperty(player2,property1);
        });
    }

    @Test
    void testReceiveMoney() {
        player1.receiveMoney(200);
        assertEquals(1200, player1.getMoney());
    }

    @Test
    void testBuyProperty() {
        Property propertyToBuy = new Property();
        propertyToBuy.setName("Property");
        propertyToBuy.setPrice(1000);

        assertThrows(IllegalArgumentException.class, () -> player1.buyProperty(player2, propertyToBuy));
        assertFalse(player1.getProperties().contains(propertyToBuy));
    }

    @Test
    void testPayMoney() {
        player1.payMoney(200);
        assertEquals(800, player1.getMoney());
    }

    @Test
    void testMove() {
        player1.move(3);
        assertEquals(3, player1.getPosition());
    }


    @Test
    void testGetters() {
        assertEquals("Player 1", player1.getName());
        assertEquals(1000, player1.getMoney());
        assertEquals("Red", player1.getColor());
        assertEquals(0, player1.getPosition());
        assertEquals("Human", player1.getUserType());
        assertEquals(2, player1.getNumberDice());
        assertEquals(null, player1.getState());
    }

    @Test
    void testSetter(){
        Player p = new Player();
        p.setName("Tomas");
        p.setMoney(2000);
        p.setColor("Yellow");
        p.setPosition(0);
        p.setUserType("Human");
        p.setNumberDice(4);
        p.setState(null);

        assertEquals("Tomas", p.getName());
        assertEquals(2000, p.getMoney());
        assertEquals("Yellow", p.getColor());
        assertEquals(0, p.getPosition());
        assertEquals("Human", p.getUserType());
        assertEquals(4, p.getNumberDice());
        assertEquals(null, p.getState());

    }

}