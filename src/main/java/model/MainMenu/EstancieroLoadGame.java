package model.MainMenu;

import services.IMainMenuStrategy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.List;

public class EstancieroLoadGame extends JPanel implements IMainMenuStrategy {
    private Image backgroundImage;
    private JList<String> savedGamesList;
    private Main mainFrame;

    public EstancieroLoadGame(Main mainFrame) {
        this.mainFrame = mainFrame;
        initializeUI();
        loadBackgroundImage();
    }

    private void initializeUI() {
        setOpaque(false);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setOpaque(false);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(100, 50, 50, 50));

        JLabel titleLabel = new JLabel("<html><b><font size='+2' color='black'>Load Game</font></b></html>");
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        inputPanel.add(titleLabel);

        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        savedGamesList = new JList<>();
        populateSavedGamesList();
        inputPanel.add(new JScrollPane(savedGamesList));

        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        add(inputPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton backButton = new JButton("<html><b>Go back</b></html>");
        backButton.addActionListener(new BackButtonListener());
        buttonPanel.add(backButton);
        customizeButton(backButton);

        JButton selectButton = new JButton("<html><b>Elegir Partida</b></html>");
        selectButton.addActionListener(new SelectButtonListener());
        buttonPanel.add(selectButton);
        customizeButton(selectButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void customizeButton(JButton button) {
        button.setBackground(new Color(210, 180, 140));
        button.setForeground(Color.BLACK);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3, true),
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));
    }

    private void populateSavedGamesList() {
        LoadGame loadGame = new LoadGame();
        List<String> savedGames = loadGame.mostrarPartidasGuardadas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (String game : savedGames) {
            listModel.addElement(game);
        }
        savedGamesList.setModel(listModel);
    }

    private void loadBackgroundImage() {
        URL imageUrl = getClass().getResource("/FondoEstanciero.jpg");
        if (imageUrl != null) {
            backgroundImage = new ImageIcon(imageUrl).getImage();
        } else {
            System.err.println("No se pudo cargar la imagen de fondo: /FondoEstanciero.jpg");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
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

    private class SelectButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedGame = savedGamesList.getSelectedValue();
            if (selectedGame != null) {
                LoadGame loadGame = new LoadGame();
                loadGame.cargarParida("Load game: " + selectedGame);
                System.out.println("Loading game: " + selectedGame);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Please select a game to load.", "No Game Selected", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private class BackButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mainFrame.showMainMenu();
        }
    }
}
