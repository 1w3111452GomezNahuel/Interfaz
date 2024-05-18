package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;

    @BeforeEach
    void setUp(){
        bank = new Bank(350000);
    }

    @Test
    void getMoney() {
        assertEquals(350000, bank.getMoney());
    }

    @Test
    void setMoney() {
        bank.setMoney(5000);
        assertEquals(5000, bank.getMoney());
    }

   // @Test
   // void properties() {
   // }

   // @Test
   // void collectRent() {
   // }
//
   // @Test
   // void sellProperty() {
   // }
//
   // @Test
   // void distributeMoney() {
   // }
//
   // @Test
   // void returnExit() {
   // }
}