package model.MainMenu;

import model.Player;
import model.Property;
import services.IMainMenuStrategy;

import java.util.Scanner;

public class EstancieroNewGame implements IMainMenuStrategy {
    private Player player;
    private Scanner scanner = new Scanner(System.in);

    public EstancieroNewGame(){

    }

    @Override
    public void adjustMainMenu() {
        System.out.println("--Set up your game--");

        System.out.println("Name:");
        player.setName(scanner.nextLine());

        System.out.println("Amount players (2-6):");
        int numberPlayers = scanner.nextInt();
        //Implementar bot con valores randoms

        scanner.nextLine(); // Limpiar el buffer del scanner

        System.out.println("Difficulty:");
        String difficultyGame = scanner.nextLine();

        System.out.println("\nColor:");
        player.setColor(scanner.nextLine());

        System.out.println("\nGoal to win:");
        System.out.println("1. Number of properties owned");
        System.out.println("2. Amount of money accumulated");
        int option = scanner.nextInt();

        String goal;
        if(option == 1) {
            goal = "Number of properties owned";
        } else {
            goal = "Amount of money accumulated";
        }

        // Imprimir los datos ingresados por el jugador
        System.out.println("\nData entered:");
        System.out.println("Player name: " + player.getName());
        System.out.println("Amount players: " + numberPlayers);
        System.out.println("Difficulty game: " + difficultyGame);
        System.out.println("Player color: " + player.getColor());
        System.out.println("Goal to win: " + goal);
        System.out.println();
        System.out.println("Do you wish continue?");
        System.out.println("1. Continue");
        System.out.println("2. Go back");
        int optionStateGame = scanner.nextInt();

        if(optionStateGame == 1) {
            System.out.println("Starting game...");
            System.exit(0);
        } else {
            clearConsole();
            return;
        }
        scanner.close();
    }
    private void clearConsole() {
        try {
            //new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            for (int i = 0; i < 50; ++i) System.out.println();
        } catch (Exception e) {
            // Manejo de excepciones si algo sale mal al limpiar la consola
            e.printStackTrace();
        }
    }
}
