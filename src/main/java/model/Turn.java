package model;

import java.util.Collections;
import java.util.List;

public class Turn {
    public void assignPlayerOrder(List<Player> tempPlayers, int dice) {
        // Asigna a cada jugador el valor de los dados
        for (int i = 0; i < tempPlayers.size(); i++) {
            tempPlayers.get(i).setNumberDice(dice);
        }
        // Ordenar los jugadores por el resultado de los dados (de mayor a menor)
        Collections.sort(tempPlayers, (p1, p2) -> Integer.compare(p2.getNumberDice(), p1.getNumberDice()));
    }
}
