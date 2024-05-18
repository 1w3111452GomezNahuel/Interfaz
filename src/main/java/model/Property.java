package model;

public class Property {
    private int id;
    private String name;
    private int price;
    private Player owner;
    private String Type; // TODO: definir tipos chacra, estancia
    private int rentalCost;

    public Property(int id, String name, int price, Player owner, String type, int rentalCost) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.owner = owner;
        Type = type;
        this.rentalCost = rentalCost;
    }


    public Property() {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public int getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(int rentalCost) {
        this.rentalCost = rentalCost;
    }

    /**
     * @return Este metodo proporciona la funcionalidad para obtener los datos de la propiedad
     */
    public String getPropertyInfo() {
        StringBuilder propertyInfo = new StringBuilder();
        propertyInfo.append("Property ID: ").append(id).append("\n");
        propertyInfo.append("Name: ").append(name).append("\n");
        propertyInfo.append("Price: ").append(price).append("\n");
        propertyInfo.append("Type: ").append(Type).append("\n");
        propertyInfo.append("Rental Cost: ").append(rentalCost).append("\n");
        if (owner != null) {
            propertyInfo.append("Owner: ").append(owner.getName()).append("\n");
        } else {
            propertyInfo.append("Owner: None").append("\n");
        }
        return propertyInfo.toString();
    }
}
