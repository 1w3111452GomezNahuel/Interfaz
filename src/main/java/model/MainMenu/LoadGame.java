package model.MainMenu;

import java.util.ArrayList;
import java.util.List;

public class LoadGame {
    private int numero;
    private String nombre;
    private String fecha;

    public LoadGame(int numero, String nombre, String fecha) {
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public LoadGame() {

    }
     @Override
     public String toString() {
        return "Game number:" + numero + ", Name:" + nombre + ", Date Time:" + fecha ;
     }

    // TODO : implementar con la base de datos las
    //  partidas guardas y cargarlas
    public void cargarParida(String gameName) {
        System.out.println(gameName);
        System.exit(0);

    }



    public List<String> mostrarPartidasGuardadas() {
        List<String> partidas = new ArrayList<>();
        partidas.add(new LoadGame(1, "Nahuel", "11/12/24").toString());
        partidas.add(new LoadGame(2, "Luciano", "11/12/24").toString());
        partidas.add(new LoadGame(3, "Tomi", "11/12/24").toString());
        partidas.add(new LoadGame(4, "Fran", "11/12/24").toString());
        partidas.add(new LoadGame(5, "Lautaro", "11/12/24").toString());
        return partidas;

    }


}
