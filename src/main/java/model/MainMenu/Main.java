/*package model.MainMenu;

import services.IMainMenuStrategy;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        IMainMenuStrategy mainMenuStrategy = new IMainMenuStrategy() {
            @Override
            public void adjustMainMenu() {

            }
        };

        MainPlayer mainPlayer = new MainPlayer(mainMenuStrategy);

        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Welcome to Estanciero!");
            System.out.println("1. Load Game");
            System.out.println("2. New Game");
            System.out.println("3. See instructions");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // TODO: Agregar aqui clase a llamar, ejemplo "mainPlayer.changeOptionMain(new NameClass());"

                    mainPlayer.changeOptionMain(new EstancieroLoadGame());
                    break;
                case 2:
                    // TODO: Agregar aqui clase a llamar, ejemplo "mainPlayer.changeOptionMain(new NameClass());"
                    mainPlayer.changeOptionMain(new EstancieroNewGame());
                    break;
                case 3:
                    // TODO: Agregar aqui clase a llamar, ejemplo "mainPlayer.changeOptionMain(new NameClass());"
                    mainPlayer.changeOptionMain(new EstancieroInstruction());
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option, please select a valid option.");
                    break;
            }

            mainPlayer.adjustMainEstanciero();

        } while (opcion != 0);

        scanner.close();
    }
}*/

package model.MainMenu;

import services.IMainMenuStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private MainPlayer mainPlayer;
    private JPanel mainMenuPanel;

    public Main(MainPlayer mainPlayer) {
        this.mainPlayer = mainPlayer;
        setTitle("Estanciero Menu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear el panel principal
        mainMenuPanel = new JPanel();
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        // Crear botones con íconos (los íconos pueden ser configurados como quieras)
        JButton loadGameButton = createButton("Load Game");
        JButton newGameButton = createButton("New Game");
        JButton instructionsButton = createButton("See Instructions");
        JButton exitButton = createButton("Exit");

        // Añadir botones al panel
        mainMenuPanel.add(loadGameButton);
        mainMenuPanel.add(newGameButton);
        mainMenuPanel.add(instructionsButton);
        mainMenuPanel.add(exitButton);

        // Añadir panel al frame
        add(mainMenuPanel);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(new ButtonClickListener());
        return button;
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            switch (source.getText()) {
                case "Load Game":
                    mainPlayer.changeOptionMain(new EstancieroLoadGame());
                    break;
                case "New Game":
                    mainPlayer.changeOptionMain(new EstancieroNewGame(Main.this));
                    break;
                case "See Instructions":
                    mainPlayer.changeOptionMain(new EstancieroInstruction());
                    break;
                case "Exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
            mainPlayer.adjustMainEstanciero();
        }
    }

    public void showMainMenu() {
        setContentPane(mainMenuPanel);
        revalidate();
        repaint();
    }

    public static void main(String[] args) {
        IMainMenuStrategy mainMenuStrategy = new IMainMenuStrategy() {
            @Override
            public void adjustMainMenu() {
                // Implementar la lógica inicial si es necesario
            }
        };

        MainPlayer mainPlayer = new MainPlayer(mainMenuStrategy);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main(mainPlayer).setVisible(true);
            }
        });
    }
}