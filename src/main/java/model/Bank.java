package model;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private int money;
    private List<Property> properties;

    public Bank(int money) {
        this.money = money;
        this.properties = new ArrayList<>();
    }

    public Bank() {

    }

    /**getters y setters**/
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    //public List<Property> properties() {return properties;}

    /**Realizar hipotecas**/
   // public void collectRent(Property prop, Player player) {
   //    int price = prop.getPrice();
   //     player.setMoney(player.getMoney() - price);
   // }
   // public void addProperty(Property property) {
   //     properties.add(property);
   // }

    /**añadir o pasar la propiedad a comprar**/
    //public void sellProperty(Property prop, Player player) {
    //    int price = prop.getPrice();
    //    player.setMoney(player.getMoney() - price);
    //    player.buyProperty(player, prop);
    //}

    /**setear valor inicial de $35000**/
    //public void distributeMoney(Player player, int value) {
    //    if (money >= value) {
    //        player.setMoney(value);
    //        this.money -= 35000;
    //    } else {
    //        System.out.println("Insufficient funds in the bank.");
    //    }
    //}

    /**sumar $5000 cada vuelta por salida**/
    //public  void returnExit(Player p) {
    //    p.setMoney(p.getMoney()+5000);
    //}
}
