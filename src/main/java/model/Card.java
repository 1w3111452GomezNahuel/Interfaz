package model;

public class Card {
    public Card(int id, String type, String typeCard, String description) {
        this.id = id;
        this.type = type;
        this.typeCard = typeCard;
        this.description = description;
    }

    //Attributes----------------
    private int id;
    public String type;



    public String typeCard;
    private String description;
    private Board board;
    private Player player;

    //Constructor----------------

   //public Card(List<Card> listCards) {
   //    this.listCards = listCards;
   //}
   public Card(int id, String type, String description) {
       this.id = id;
       this.type = type;
       this.description = description;
   }

    public Card() {

    }

    //getter and setter----------------
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //public List<Card> getListCards() {
    //   return listCards;
   // }

   // public void setListCards(List<Card> listCards) {
   //     this.listCards = listCards;
   // }


    //Methods----------------


    public void executeActtion(String typeCard) {

        switch (typeCard) {
            case ("destiny card"):
                executeDestinyActtion();
                break;
            case ("luck card"):
                executeLuckActtion();
                break;
            default:
                throw new RuntimeException(" wrong card type ");
        }

    }

    private void executeDestinyActtion() {
    }

    private void executeLuckActtion() {
    }


    public void type(int position, int steps, int money) {

        //This method determines the type of card it is according to the methods
        switch (type) {
            case "movementsCards":
                movementsCards(position, steps);
                break;
            case "cardReciveMoney":
                cardReciveMoney(type, money);
                break;
            case "penaltyCards":
                penaltyCards(type, money);
                break;
            case "specialCards":
                specialCards(type);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + type);
        }
    }

    private void specialCards(String type) {
        if (type.equals("specialCards")) {

        }
    }

    private void penaltyCards(String type, int money) {
        if (type.equals("penaltyCards")) {
            if (player.getMoney()>=money){
                player.payMoney(money);
            }else {
                System.out.println(" the player does not have the necessary amount to reduce the money takes action ");
            }

        }
    }

    private void cardReciveMoney(String type, int money) {
        if (type.equals("cardReciveMoney")) {
            player.receiveMoney(money);
        }

    }

    private void movementsCards(int playerIndex, int steps) {
        if (type.equals("movementsCards")) {
            board.movePlayer(playerIndex,steps);
        } else{
            System.out.println(" This cars is not a movement cards.");
        }
    }

    public static void viewCard(String description, String type) {

        System.out.println(" description : " + description);
        System.out.println("Type : " + type);

    }

    public boolean checkCardType(String type) {

        if (type.equals("specialCard")) {
            return true;
        } else {
            return false;
        }

    }


    //Sin base de datos?
//    public void initializedCards() {
//        listCards.add(new Card(1, "movementsCards", "advance 3 spaces"));
//
//    }
}
