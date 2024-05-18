package model;

import java.util.List;

public class Board {
    private List<Box> boxList;
    private Player[] player;
    private int position;

    public Board(List<Box> boxList, Player[] player) {
        this.boxList = boxList;
        this.player = player;
        this.position = 0;
    }

    public Board() {

    }

    public int getBoxPosition(){
        return position;
    }

    public void setPlayerPosition(int playerIndex, int newPosition){
        // verifico que la posicion nueva es una posicion valida
        if(newPosition >= 0 && newPosition < boxList.size()){
            // actualizamos la posicion del jugador
            player[playerIndex].setPosition(newPosition);
        } else {
            System.out.println("Invalid position!!");
        }
    }
    public boolean isValidMove(int playerIndex, int steps){
        // verificamos si el movimiento es valido segun las reglas del juego
        int newPosition = player[playerIndex].getPosition() + steps;

        return newPosition >= 0 && newPosition < boxList.size();
    }

    public void movePlayer(int playerIndex, int steps){
        if (isValidMove(playerIndex,steps)){
            // mover el jugador a la siguiente posicion
            player[playerIndex].move(steps);
            position += steps;
        } else {
            System.out.println("Invalid move!!");
        }

    }


    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    public Player[] getPlayer() {
        return player;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setPlayer(int playerIndex, Player realPlayer) {
        this.player[playerIndex] = realPlayer;
    }
}
