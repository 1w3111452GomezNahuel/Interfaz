package model;

import java.util.List;
import java.util.Scanner;

public class Box{
    private int id;
    private Board board;
    private List<Property> properties;
    private List<Type> types;
    private int position;

    public Box(int id, Board board, List<Property> properties, List<Type> types, int position) {
        this.id = id;
        this.board = board;
        this.properties = properties;
        this.types = types;
        this.position = position;
    }

    public Box() {
    }

    public int getId() { return id; }
    public void setId(int id) {this.id=id;}
    public Board getBoard() { return board; }
    public void setBoard(Board board) {this.board=board;}
    public List<Property> getProperties() { return properties; }
    public void setProperties(List<Property> properties) {this.properties=properties;}
    public List<Type> getType() { return types; }
    public void setType(List<Type> types) {this.types=types;}
    public int getPosition() { return position; }
    public void setPosition(int position) {this.position=position;}

    //verifies the type of box, if it is property verifies if it has owner or not, 
    //of having paid rent and if it does not give the option of purchase, otherwise 
    //it verifies the type of box and carries out its action
//    public String descriptionAndAction(Player player, Type type){
//        String description="";//query to the database
//        boolean owner = HasOwner(player.getPosition()); //En el modelo de Player crear un metodo getPosition que devuelva un int de la posicion
//        if(type.getDescription().equals("Property"))   {
//            if(!owner){
//                System.out.println("Want to buy the property? (yes/no)");
//                    Scanner scanner = new Scanner(System.in);
//                    String userInput = scanner.nextLine();
//                if (userInput.equalsIgnoreCase("yes")) {
//                    //method to boy
//                } else {
//
//                    scanner.close();
//                }
//
//                scanner.close();
//                //call method method for purchase
//            }
//            else{
//                System.out.println("You must pay the property owner");
//                //call the method for automatic payment and notification to the player
//            }
//        }
//        else if(type.getDescription().equals("Rest")){
//            //calls the method to Rest
//        }
//        else if(type.getDescription().equals("Commissioner")){
//            //calls the method to Commissioner
//        }
//        else if(type.getDescription().equals("Luck")){
//            //calls the method to Luck
//        }
//        else if(type.getDescription().equals("Destination")){
//            //calls the method to Destination
//        }
//        else if(type.getDescription().equals("Bonus")){
//            //calls the method to Bonus
//        }
//        else{
//            //calls the method to Punishment
//        }
//        return description; //shows the result of the movement
//    }
    //This method performs the actions described in the previous method
//    public void ActivateAction(){
//    }
    //this method is responsible for verifying whether the property has an owner or not
    public boolean HasOwner(int player){
        boolean owner = false;
        return owner;
    }
}