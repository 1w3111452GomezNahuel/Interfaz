# <u>TPI Estanciero Laboratorio III</u>



## _Class Player_

### Attributes:

-  <u>**namePlayer**</u> : User name
-  <u>**money** </u>: Amount of money the player has.
-  <u>**color** </u>: Color of the pawn the player uses.
-  <u>**userType**[Jugador, bot] </u>: if it is a player type or a bot type.
-  <u>**virtualProfile** [Conservador,Equilibrado,Agresivo] </u> : defines the type of profile that the player will have if it will be conservative, balanced or aggressive.

### Methods:
- <u>**meetPlayer()** </u>: Know the player`s data such as color and money he has, etc.
- <u>**buyProperty()** </u>: The action of purchasing a property if it is available for sale.
- <u>**sellProperty()** </u>: The action of selling a property, if it is owned can be sold.
- <u>**payRent()** </u>: Perform the action of paying rent for passing through a property that does not belong to you.
---

---
## _Class Box_

### Attributes:
- <u>**boxType**</u> : Indicates the type of box you are in, whether it is property, luck, rest, etc.
- <u>**propertyReference**</u> : Refers to the property whether it contains a property or not. 


### Methods:
- <u>**readBox()**</u> : Read the contents of the square where the player braked.
- <u>**action()**</u> : performs the action according to the square you are in, for example: march to prison, rest, etc.
- <u>**countLap()**</u> : Count if the player has finished making the full turn and performing the corresponding actions.
- <u>**currentPlayerStatus()**</u> : refreshes and display the player`s current status data upon reaching the box.
----

---
## _Class Property_

### Attributes: 
- <u>**nameProperty**</u> : Indicates the name of the property.
- <u>**purchaseValue**</u> : Indicates the price at which the property is for sale.
- <u>**player**</u> : If the house is purchased, it will mark the name of the player who bought it or will mark available.
- <u>**type**</u> : The property to be acquired can be a field, a farm, or a ranch.

### Methods:
- <u>**calculateRent()**</u> : Calculate the rental price according to the conditions of the property.
- <u>**transferProperty()**</u> : Transfer ownership from one player to another if purchased.
- <u>**upgradeProperty()**</u> : If the conditions are met, perform the action of improving the property.
---

---
## _Class Bank_

### Attributes:
- <u>**Money**</u> : It is the currency they will use to buy and pay.
- <u>**limitBank**</u> : It will indicate the limit of money that the bank holds.

### Methods:
- <u>**checkLimit()**</u> : Verify if the bank has reached the established money limit.
- <u>**movePlayer()**</u> : Performs the action of moving the player around the squares.
- <u>**handleTransaction**</u> : The purchase of properties and types thereof.
- <u>**distributeMoney**</u> : At the beginning of the estancieroGame the amount of money is distributed to each player.
- <u>**collectingTaxes**</u> : Collect taxes such as those from the luck/destiny cards or those corresponding to the boxes.
- <u>**manageBankingMoney**</u> : Payment of prizes to players.
- <u>**mortgageProperty**</u> : When the player needs or decides, he can mortgage the house with the bank.
---

---
## _Class Board_

### Attributes:
- <u>**boxList**</u> : A board has several squares.
- <u>**position**</u> : Indicate the position of the square you are on, that is, the number of the square.

### Methods:
- <u>**getBoxPosition()**</u> : Fetches the players' current positions and stores them.
---

---
## _Class Game_

### Attributes:
- <u>**playerList**</u> :  a estancieroGame has several players.
- <u>**statePlay**</u> :

### Methods:
- <u>**start()**</u> : coordinates the start of the play (money, position, number of players).
- <u>**nextTurn()**</u> : coordinates the estancieroGame turns (next turn).
- <u>**handleEvents()**</u> : from boxes how to buy a property, draw a luck/destiny card.
- <u>**lastGameState()**</u> : saves the latest position values, money, properties, of the players.
---

---
## _Class Dice_

### Attributes:
- <u>**value**</u> : Indicates the value of the dice.
- <u>**diceCounter**</u> : Counts the number of times double rolls have been made.

### Methods:
- <u>**launch()**</u> : Perform the action of rolling the dice.
- <u>**doubleRoller**</u> : Check if the rolled dice are doubles or not, and perform the corresponding actions.
---

---
## **Attached is the corresponding diagram with the relationships.**

![Class Diagram Image](\_images\imgMarkdown.png)


