package model.MainMenu;

import services.IMainMenuStrategy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private MainPlayer mainPlayer;
    private JPanel mainMenuPanel;
    private Image backgroundImage;

    public Main(MainPlayer mainPlayer) {
        this.mainPlayer = mainPlayer;
        setTitle("Estanciero");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon(getClass().getResource("/FondoEstanciero.jpg")).getImage();

        // Crear el panel principal con BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Crear el panel principal
        mainMenuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));

        // Crear botones con íconos (los íconos pueden ser configurados como quieras)
        JButton loadGameButton = createCustomButton("Load Game");
        JButton newGameButton = createCustomButton("New Game");
        JButton instructionsButton = createCustomButton("See Instructions");
        JButton exitButton = createCustomButton("Exit");

        // Añadir espacio entre los botones
        mainMenuPanel.add(Box.createVerticalGlue());

        // Añadir botones al panel
        mainMenuPanel.add(loadGameButton);
        mainMenuPanel.add(Box.createVerticalStrut(20));
        mainMenuPanel.add(newGameButton);
        mainMenuPanel.add(Box.createVerticalStrut(20));
        mainMenuPanel.add(instructionsButton);
        mainMenuPanel.add(Box.createVerticalStrut(20));
        mainMenuPanel.add(exitButton);
        mainMenuPanel.add(Box.createVerticalGlue()); // Añadir espacio al final

        // Añadir panel al frame
        //add(mainMenuPanel);
        contentPane.add(mainMenuPanel, BorderLayout.CENTER);
    }

    private JButton createCustomButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Personalizar el botón
        button.setBackground(new Color(210, 180, 140)); // Marrón clarito
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3, true),  // Borde grueso y redondeado
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));   // Margen

        button.setFocusPainted(false);
        button.addActionListener(new ButtonClickListener());
        return button;
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
