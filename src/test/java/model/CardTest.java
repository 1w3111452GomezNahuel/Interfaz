package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CardTest {
    private Card card;
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    @BeforeEach
    public void setUp() {
        card = new Card(1, "Luck", "go to prison directly");
    }
    @Test
    void getId(){
        assertEquals(1, card.getId());
    }
    @Test
    void getTypeCard() {
        assertEquals("Luck", card.getTypeCard());
    }
    @Test
    void getDescription(){
        assertEquals("go to prison directly", card.getDescription());
    }
    @Test
    void setId(){
        card.setId(2);
        assertEquals(2, card.getId());
    }
    @Test
    void setTypeCard(){
        card.setTypeCard("Destiny");
        assertEquals("Destiny", card.getTypeCard());
    }
    @Test
    void setDescription(){
        card.setDescription("inherits two thousand");
        assertEquals("inherits two thousand", card.getDescription());
    }

    @Test
    public void testViewCard() {

        System.setOut(new PrintStream(testOut));
        Card card = new Card(1, "SpecialCard", "marche preso directamente");

        Card.viewCard(card.getDescription(), card.getType());
        System.setOut(systemOut);
        String printedOutut = testOut.toString().trim();
        String expectOutPut = "description : marche preso directamente"+System.lineSeparator()+"Type : SpecialCard";
        assertEquals(expectOutPut, printedOutut);
    }
    @Test
    public void checkCardType() {
        card = new Card(1, "specialCard", "marche preso directamente");

        assertTrue(card.checkCardType("specialCard"));
    }
}