package model.MainMenu;

import services.IMainMenuStrategy;

import java.util.List;
import java.util.Scanner;

public class EstancieroLoadGame implements IMainMenuStrategy {

    @Override
    public void adjustMainMenu() {

        System.out.println("Saved games.");
        System.out.println("-------------------");
        Scanner sc = new Scanner(System.in);

        LoadGame loadGame = new LoadGame();
        List<String> PartidasGuardadas = loadGame.mostrarPartidasGuardadas();
        for (String partida : PartidasGuardadas) {
            System.out.println(partida);
        }


        System.out.println("-------------------");
        System.out.println(" Select a game to loard or \"x\" to go main menu");

        String option = sc.nextLine();
        switch (option) {

            case "1":
                // loadGame.cargarParida("Load Game: " + "1, Nahuel, 11/12/24");
                //break;
            case "2":
                //  loadGame.cargarParida("Load Game: " + "2, Luciano, 11/12/24");
                //  break;
            case "3":
                //  loadGame.cargarParida("Load game: " + "3, Tomi, 11/12/24");
            case "4":
                // loadGame.cargarParida("Load game: " + "4, Fran, 11/12/24");

            case "5":
                //   loadGame.cargarParida("Load game: " + "5, Lautaro, 11/12/24");

                int casePartida = Integer.parseInt(option) - 1;
                loadGame.cargarParida("Load game: " + PartidasGuardadas.get(casePartida));
                break;
            case "x":
                System.out.println("Returning to main menu...");
                return;

            default:
                System.out.println("Invalid option..");
                adjustMainMenu();
                break;

        }
        sc.close();

    }
}
