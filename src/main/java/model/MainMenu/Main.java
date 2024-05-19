package model.MainMenu;

import services.IMainMenuStrategy;
import javax.swing.border.EmptyBorder;
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
        setTitle("Estanciero Menu");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon(getClass().getResource("/FondoEstanciero.jpg")).getImage();

        // Crear el panel principal con BorderLayout
        JPanel contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Crear el panel para los botones con un borde vacío en la parte superior
        mainMenuPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // Dibujar la imagen de fondo
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        mainMenuPanel.setLayout(new BoxLayout(mainMenuPanel, BoxLayout.Y_AXIS));
        mainMenuPanel.setBorder(new EmptyBorder(150, 0, 0, 0)); // Espacio en la parte superior

        // Crear botones con íconos (los íconos pueden ser configurados como quieras)
        JButton loadGameButton = createButton("Load Game", "/load_icon.png");
        JButton newGameButton = createButton("New Game", "/new_icon.png");
        JButton instructionsButton = createButton("See Instructions", "/info_icon.png");
        JButton exitButton = createButton("Exit", "/exit.png");

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

        // Añadir panel de botones al centro del panel principal
        contentPane.add(mainMenuPanel, BorderLayout.CENTER);
    }

    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 50));
        button.setMaximumSize(new Dimension(200, 50));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Cargar el icono
        ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
        button.setIcon(icon);

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
        setVisible(true);
    }

    public static void main(String[] args) {
        IMainMenuStrategy mainMenuStrategy = new IMainMenuStrategy() {
            @Override
            public void adjustMainMenu() {
                // Implementar la lógica inicial si es necesario
            }
        };

        MainPlayer mainPlayer = new MainPlayer(mainMenuStrategy);
        SwingUtilities.invokeLater(() -> new Main(mainPlayer).showMainMenu());
    }
}