package model.MainMenu;

import model.Player;
import model.Property;
import services.IMainMenuStrategy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Scanner;

public class EstancieroNewGame extends JPanel implements IMainMenuStrategy {
    private Player player;
    private JTextField nameField;
    private JComboBox<String> numPlayersField;
    private JComboBox<String> difficultyField;
    private JComboBox<String> colorField;
    private JComboBox<String> goalComboBox;
    private Main mainFrame;
    private Image backgroundImage;

    public EstancieroNewGame(Main mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        loadBackgroundImage();
    }

    private void initializeUI() {
        // Configurar el panel principal para ser transparente
        setOpaque(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        // Panel para los campos de entrada y el combo box
        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false); // Hacer el panel transparente
        inputPanel.setLayout(new GridLayout(6, 2, 5, 5)); // Cuadrícula de 6 filas y 2 columnas

        // Agregar un borde con espacio superior de 20 píxeles al inputPanel
        inputPanel.setBorder(new EmptyBorder(200, 0, 0, 0));

        inputPanel.add(new JLabel("<html><b><font size='+1' color='black'>Name:</font></b></html>"));
        nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("<html><b><font size='+1' color='black'>Players:</font></b></html>"));
        numPlayersField = new JComboBox<>(new String[]{"2", "3", "4", "5", "6"});
        inputPanel.add(numPlayersField);

        inputPanel.add(new JLabel("<html><b><font size='+1' color='black'>Difficulty:</font></b></html>"));
        difficultyField = new JComboBox<>(new String[]{"Easy", "Medium", "Hard"});
        inputPanel.add(difficultyField);

        inputPanel.add(new JLabel("<html><b><font size='+1' color='black'>Color:</font></b></html>"));
        colorField = new JComboBox<>(new String[]{"Blue", "Yellow", "Red", "Green", "Black", "Violet"});
        inputPanel.add(colorField);

        inputPanel.add(new JLabel("<html><b><font size='+1' color='black'>Goal to win:</font></b></html>"));
        goalComboBox = new JComboBox<>(new String[]{"Number of properties owned", "Amount of money accumulated"});
        inputPanel.add(goalComboBox);

        add(inputPanel, BorderLayout.CENTER);

        // Panel para los botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // Hacer el panel transparente
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton backButton = new JButton("<html><b>Go back</b></html>");
        backButton.addActionListener(new BackButtonListener());
        buttonPanel.add(backButton);
        // Personalizar el botón
        backButton.setBackground(new Color(210, 180, 140)); // Marrón clarito
        backButton.setForeground(Color.BLACK);
        backButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3, true),  // Borde grueso y redondeado
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));   // Margen

        JButton continueButton = new JButton("<html><b>Continue</b></html>");
        continueButton.addActionListener(new ContinueButtonListener());
        buttonPanel.add(continueButton);
        // Personalizar el botón
        continueButton.setBackground(new Color(210, 180, 140)); // Marrón clarito
        continueButton.setForeground(Color.BLACK);
        continueButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3, true),  // Borde grueso y redondeado
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));   // Margen

        add(buttonPanel, BorderLayout.SOUTH);
    }



    private void loadBackgroundImage() {
        // Cargar la imagen de fondo desde un archivo
        ImageIcon icon = new ImageIcon(getClass().getResource("/FondoEstanciero.jpg"));
        backgroundImage = icon.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar la imagen de fondo
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    @Override
    public void adjustMainMenu() {
        mainFrame.setContentPane(this);
        mainFrame.revalidate();
        mainFrame.repaint();
    }

    private class ContinueButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Collect data and proceed with the game setup
            String name = nameField.getText();
            int numPlayers = Integer.parseInt((String) goalComboBox.getSelectedItem());
            String difficulty = (String) difficultyField.getSelectedItem();
            String color = (String) colorField.getSelectedItem();
            String goal = (String) goalComboBox.getSelectedItem();

            // For demonstration, print the data to the console
            System.out.println("Player name: " + name);
            System.out.println("Amount players: " + numPlayers);
            System.out.println("Difficulty game: " + difficulty);
            System.out.println("Player color: " + color);
            System.out.println("Goal to win: " + goal);

            // Proceed with the game
            System.out.println("Starting game...");
            System.exit(0);  // Exit for now
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.showMainMenu();
        }
    }
}