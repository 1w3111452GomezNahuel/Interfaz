# <u> Desing Patterns </U>

Here are the design patterns that will be used for the estancieroGame "el estanciero".


---

# 1. Design Pattern: Singleton

### Explanation:
*The Singleton pattern will be used to ensure that certain classes, such as the deck of cards or the estancieroGame board,
have a single inst instance throughout the application. This ensures that all interactions with these elements are
consistent throughout the estancieroGame.*

### Problem it aims to solve:
*Avoiding the creation of multiple instances of objects that should be unique in the estancieroGame,
such as the deck of cards or the board, and ensuring that all parts of the estancieroGame work,
with the same instance of these objects.*

---

# 2. Design Pattern: Factory

### Explanation:
*The Factory Method pattern one of the ways we are going to use them is to create different types of cards (for example, property cards, event cards) flexibly. Each type of letter could instantiate the patron as needed.*

### Problem it aims to solve:
*It will allow the creation of different types of cards independently, without the code depending on the specific classes of each type of card, which facilitates the extensibility of the estancieroGame.*

---

# 3. Disign Pattern: 
## Observer

### Explanation:
*The Observer pattern will be used to notify players when important events occur in the estancieroGame, such as purchasing a property or executing an event card. Interested players will register as observers and will be notified when these events occur.*

### Problem It Aims to Solve:
*Facilitating communication between different parts of the estancieroGame, such as the board and the players, without directly coupling them, thus improving code modularity and scalability.*

---

# 4. Design Pattern: Strategy

### Explanation:
*We chose the Strategy design pattern because it provides a flexible and scalable solution.
to manage the different options of the main menu.
By separating each option into its own class, we can modify or extend the behavior.
from the menu easily without having to change the main code structure.*

### Problem it aims to solve:
*The Strategy pattern allows us to easily add new options to the main menu without modifying
the existing code. If in the future we wish to include new functionalities,
This helps us keep the code modular and maintainable as the estancieroGame evolves.*

---

## 5.Design Pattern : Template Method

### Explanation:

*The Template Method will be used to establish a framework for the basic actions that a player can perform during their
turn, such as playing card, obtaining a property, or playing rent. These actions can be carried out using methods form a
subclass.*

### Problem it aims to solve:

*To promote code reause by implementing a common structure of the actions that the player will perform during their turn,
allowing each action performed to adapt to the specific need represented by each type of card or property*






