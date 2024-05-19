package model.MainMenu;

import services.IMainMenuStrategy;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class EstancieroInstruction implements IMainMenuStrategy {
    private Image backgroundImage;

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

        // Cargar la imagen de fondo
        backgroundImage = new ImageIcon(getClass().getResource("/instructions2.jpg")).getImage();

        // Crear el panel personalizado con la imagen de fondo
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImage != null) {
                    g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Crear un JTextPane para mostrar las instrucciones con el texto formateado
        JTextPane textPane = new JTextPane();
        textPane.setEditable(false);
        textPane.setOpaque(false);  // Hacer el JTextPane transparente
        textPane.setForeground(Color.BLACK);  // Cambiar el color del texto para mayor visibilidad

        // Añadir márgenes de 30px a los lados
        textPane.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 30));

        // Crear el documento y los estilos
        StyledDocument doc = textPane.getStyledDocument();
        SimpleAttributeSet regular = new SimpleAttributeSet();
        StyleConstants.setFontFamily(regular, "SansSerif");
        StyleConstants.setFontSize(regular, 14);

        SimpleAttributeSet bold = new SimpleAttributeSet(regular);
        StyleConstants.setBold(bold, true);

        // Agregar texto con estilos
        try {
            doc.insertString(doc.getLength(), "Instructions for the board game El Estanciero.\n\n", bold);
            doc.insertString(doc.getLength(), "Objective of the game:\n", bold);
            doc.insertString(doc.getLength(), "Be the last player standing after all others have gone bankrupt.\n\n", regular);

            doc.insertString(doc.getLength(), "Setup:\n", bold);
            doc.insertString(doc.getLength(), "1. Each player selects a token and places it on the starting square.\n", regular);
            doc.insertString(doc.getLength(), "2. Choose a banker who will manage the money and unsold properties.\n", regular);
            doc.insertString(doc.getLength(), "3. Each player receives an initial amount of money (ad determined by the game rules).\n\n", regular);

            doc.insertString(doc.getLength(), "Gameplay:\n", bold);
            doc.insertString(doc.getLength(), "1. Players roll the dice to determine the order of play.\n", regular);
            doc.insertString(doc.getLength(), "2. On each turn, a player rolls the two dice and moves their token the number of spaces equal to the sum of the dice.\n", regular);
            doc.insertString(doc.getLength(), "3. If a player rolls doubles (the same number on both dice), they get an extra turn. However, if a player rolls couples three times in a row, they must go directly to jail.\n", regular);
            doc.insertString(doc.getLength(), "4. Depending on the square where the player lands, the following actions may occur:\n", regular);
            doc.insertString(doc.getLength(), "   - Buying properties: If the square is unowned, the player can buy it from the bank.\n", regular);
            doc.insertString(doc.getLength(), "   - Paying rent: If the property is owned by another player, the player must pay the corresponding rent.\n", regular);
            doc.insertString(doc.getLength(), "   - Special squares: The player may land on squares like 'Ir a la carcel', 'Suerte', 'Destino', etc.\n\n", regular);

            doc.insertString(doc.getLength(), "Properties:\n", bold);
            doc.insertString(doc.getLength(), "1. Players can buy properties when they land on them and they are available.\n", regular);
            doc.insertString(doc.getLength(), "2. If a player buys a property, they receive the corresponding property card.\n", regular);
            doc.insertString(doc.getLength(), "3. Properties can be improved by buying chacras and estancias (according to the game rules).\n\n", regular);

            doc.insertString(doc.getLength(), "Rent:\n", bold);
            doc.insertString(doc.getLength(), "1. Players must pay rent when they land on a property that belongs to another player.\n", regular);
            doc.insertString(doc.getLength(), "2. The amount of rent depends on the type of property and whether it has chacras or estancias.\n\n", regular);

            doc.insertString(doc.getLength(), "Bankruptcy:\n", bold);
            doc.insertString(doc.getLength(), "1. A player goes bankrupt when they cannot pay what they owe.\n", regular);
            doc.insertString(doc.getLength(), "2. When a player goes bankrupt, they must give all their properties and remaining money to the creditor (player or bank).\n", regular);
            doc.insertString(doc.getLength(), "3. The bankrupt player is out of the game.\n\n", regular);

            doc.insertString(doc.getLength(), "End of the game:\n", bold);
            doc.insertString(doc.getLength(), "The game ends when only one player remains who has not gone bankrupt.\n\n", regular);

            doc.insertString(doc.getLength(), "Tips:\n", bold);
            doc.insertString(doc.getLength(), "1. Manage your money wisely and buy properties strategically.\n", regular);
            doc.insertString(doc.getLength(), "2. Build chacras and estancias on high-traffic properties to increase your income.\n", regular);
            doc.insertString(doc.getLength(), "3. Negotiate with other players to trade or sell properties.\n\n", regular);
            doc.insertString(doc.getLength(), "Have fun playing El Estanciero!\n\n", regular);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }

        // Añadir el JTextPane a un panel de desplazamiento
        JScrollPane scrollPane = new JScrollPane(textPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setOpaque(false);  // Hacer el JScrollPane transparente
        scrollPane.getViewport().setOpaque(false);

        // Crear un botón para cerrar la ventana
        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        closeButton.addActionListener(e -> instructionsFrame.dispose());
        // Personalizar el botón
        closeButton.setBackground(new Color(210, 180, 140)); // Marrón clarito
        closeButton.setForeground(Color.BLACK);
        closeButton.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 3, true),  // Borde grueso y redondeado
                BorderFactory.createEmptyBorder(10, 20, 10, 20)));   // Margen

        // Añadir el área de desplazamiento, el botón y el espacio al panel
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(scrollPane);
        panel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre el área de desplazamiento y el botón
        panel.add(closeButton);
        panel.add(Box.createRigidArea(new Dimension(0, 20))); // Espacio debajo del botón

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
                "Have fun playing El Estanciero!\n\n";
    }
}