package model.MainMenu;

import services.IMainMenuStrategy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class EstancieroInstruction implements IMainMenuStrategy {
    public EstancieroInstruction() {

    }

    @Override
    public void adjustMainMenu() {
        showInstructions();
    }

    private void showInstructions() {
        // Crear una nueva ventana JFrame para mostrar las instrucciones
        JFrame instructionsFrame = new JFrame("Instructions");
        instructionsFrame.setSize(500, 700);
        instructionsFrame.setLocationRelativeTo(null);
        instructionsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Crear un área de texto para mostrar las instrucciones
        JTextArea textArea = new JTextArea();
        textArea.setText(getInstructionsText());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Añadir el área de texto a un panel de desplazamiento
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Crear un botón para cerrar la ventana
        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(e -> instructionsFrame.dispose());

        // Crear el panel principal y añadir el área de desplazamiento y el botón
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el área de desplazamiento y el botón
        panel.add(closeButton);

        // Añadir el panel al frame
        instructionsFrame.add(panel);

        // Mostrar la ventana
        instructionsFrame.setVisible(true);
    }

    private String getInstructionsText() {
        return "Instructions for the board game El Estanciero.\n\n" +
                "Objective of the game:\n" +
                "Be the last player standing after all others have gone bankrupt.\n\n" +
                "Setup:\n" +
                "1. Each player selects a token and places it on the starting square.\n" +
                "2. Choose a banker who will manage the money and unsold properties.\n" +
                "3. Each player receives an initial amount of money (ad determined by the game rules).\n\n" +
                "Gameplay:\n" +
                "1. Players roll the dice to determine the order of play.\n" +
                "2. On each turn, a player rolls the two dice and moves their token the number of spaces equal to the sum of the dice.\n" +
                "3. If a player rolls doubles (the same number on both dice), they get an extra turn. However, if a player rolls couples three times in a row, they must go directly to jail.\n" +
                "4. Depending on the square where the player lands, the following actions may occur:\n" +
                "   - Buying properties: If the square is unowned, the player can buy it from the bank.\n" +
                "   - Paying rent: If the property is owned by another player, the player must pay the corresponding rent.\n" +
                "   - Special squares: The player may land on squares like 'Ir a la carcel', 'Suerte', 'Destino', etc.\n\n" +
                "Properties:\n" +
                "1. Players can buy properties when they land on them and they are available.\n" +
                "2. If a player buys a property, they receive the corresponding property card.\n" +
                "3. Properties can be improved by buying chacras and estancias (according to the game rules).\n\n" +
                "Rent:\n" +
                "1. Players must pay rent when they land on a property that belongs to another player.\n" +
                "2. The amount of rent depends on the type of property and whether it has chacras or estancias.\n\n" +
                "Bankruptcy:\n" +
                "1. A player goes bankrupt when they cannot pay what they owe.\n" +
                "2. When a player goes bankrupt, they must give all their properties and remaining money to the creditor (player or bank).\n" +
                "3. The bankrupt player is out of the game.\n\n" +
                "End of the game:\n" +
                "The game ends when only one player remains who has not gone bankrupt.\n\n" +
                "Tips:\n" +
                "1. Manage your money wisely and buy properties strategically.\n" +
                "2. Build chacras and estancias on high-traffic properties to increase your income.\n" +
                "3. Negotiate with other players to trade or sell properties.\n\n" +
                "Have fun playing El Estanciero!\n\n" +
                "-------------------------------------------------------------------------------\n" +
                "Precione enter para voler al menu principal";
    }
}