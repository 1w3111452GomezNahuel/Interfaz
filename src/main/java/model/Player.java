package model;

import java.util.List;

public class Player {
    private int id;
    private String name;
    private int money;
    private List<Property> properties;
    private String color;
    private int numberdice;
    private StatePlayer state;



    private int position;
    private String UserType; // TODO: definir tipo persona, bot

    public Player(String name, int money, List<Property> properties, String color, int position,
                  String userType, int numberdice, StatePlayer state) {
        this.name = name;
        this.money = money;
        this.properties = properties;
        this.color = color;
        this.position = position;
        this.numberdice = numberdice;
        UserType = userType;
        this.state = state;
    }

    public Player() {
    }

    public Player(String name) {
        this.name = name;
    }

    // getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public int getNumberDice() {
        return numberdice;
    }

    public void setNumberDice(int number) {
        this.numberdice = number;
    }
    public String getUserType() {
        return UserType;
    }

    public void setUserType(String userType) {
        UserType = userType;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    public StatePlayer getState() {
        return state;
    }

    public void setState(StatePlayer state) {
        this.state = state;
    }

    /**
     * @return Este metodo proporciona la funcionalidad para obtener los datos del jugador
     */
    public String getPlayerInfo() {
        StringBuilder playerInfo = new StringBuilder();
        // Datos del jugador
        playerInfo.append("Player ID: ").append(id).append("\n");
        playerInfo.append("Name: ").append(name).append("\n");
        playerInfo.append("Money: ").append(money).append("\n");
        playerInfo.append("Color: ").append(color).append("\n");
        playerInfo.append("Position: ").append(position).append("\n");
        playerInfo.append("User Type: ").append(UserType).append("\n");

        // Propiedades del jugador
        playerInfo.append("Properties: \n");
        for (Property property : properties) {
            playerInfo.append("\t- ").append(property.getName()).append("\n");
        }

        return playerInfo.toString();
    }

    /**
     * Este metodo proporciona la funcionalidad para eliminar una propiedad vendida al jugador
     * @param player jugador que vende la propiedad
     * @param property propiedad que se esta vendiendo
     */
    public void sellProperty(Player player, Property property) {
        if (properties.contains(property) ) {
            properties.remove(property);
            player.receiveMoney(property.getPrice());
            property.setOwner(null); // libera la propiedad del jugador
        } else {
            // Manejo de error al intentar vender una propiedad que no posee
            throw new IllegalArgumentException("The player does not own the property he is trying to sell.");
        }
    }

    /**
     * @param amount cantidad de dinero que le ingresa al jugador
     */
    public void receiveMoney(int amount) {
        money += amount;
    }

    /**
     * Este metodo proporciona la funcionalidad para añadir una propiedad comprada al jugador
     * @param player jugador que compra la propiedad
     * @param property propiedad que se esta comprando
     */
    public void buyProperty(Player player, Property property) {
        if (player.getProperties().contains(property) && money >= property.getPrice()) {
            properties.add(property); // Agrega la propiedad al jugador
            player.payMoney(property.getPrice()); // Resta al dinero del jugador el valor de la propiedad
            property.setOwner(this); // Se asigna la propiedad al jugador
        } else {
            // Manejo de error en el caso de que el jugador no pueda comprar la propiedad
            throw new IllegalArgumentException("The player cannot buy the property.");
        }
    }

    /**
     * @param amount cantidad de dinero que le descuenta al jugador
     */
    public void payMoney(int amount) {
        money -= amount;
    }

    /**
     * @param steps Este metodo proporciona la funcionalidad para actualizar la posicion del jugador
     */
    public void move(int steps) {
        position += steps;
    }
}
