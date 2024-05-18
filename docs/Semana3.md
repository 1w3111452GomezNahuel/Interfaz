## Interface: GameMenu

### Methods

1. **save Part():** saves the current estancieroGame status data.

 ---
<!-- CORROBORATE THIS INTERFACE AND ITS METHODS-->

## Interface: PropertyManagement

**Property management:** In this screen you can see the properties available to buy, the current properties of each
player and you can mortgage them.

### Methods

1. **viewProperty(): String[]** This method allows the player to see all the properties they have and their
   improvements.

2. **buyProperty(property: Property): boolean** This method allows the player to buy a property.

<!-- THIS METHOD IS OPTIONAL -->

3. **sellProperty(property: Property):** This method allows the player to sell a property.

4. **mortgageProperty(property: Property):** This method allows the player to mortgage a property.

---

## Interface: FinancialStatus

**viewFinancialStatus()** this window shows the player his current financial situation, showing his balance, assets and
properties.

### Methods

1. **statusFinances():** brings the necessary data to show the financial suitability of the player.

---

## Events

## Interface Show cards

**Show cards**: Display a window with the card data and perform the actions indicated.

### Methods

1. **EjecutarAccion():** would execute the action described by the card it obtained.

---

## Interface: commissioner

**Commissioner*: will show a window that will show the player to stop going to jail with the options to pay the fine,
double dice or use card to leave.

### Methods

1. **throw Dados():** when you agree to roll dice and get doubles the player can exit.

2. **UltilizarTarjeta():** to use the card to get out of jail.

3. **DescontarDinero():** Pay the $1,000 fine and get out of jail.

---

## Interface Checkbox Output

**Pay Out**: Displays a window indicating the player who received $5,000 from the bank for finishing the round and going
through the selected box.

#### Methods:

1. **distributedDinero():** delivers $5,000 to the player for passing through that box.

---

## Charging interface

**Pay for rents, services:**‍ Show a window indicating the discount for services and rentals.

### Metodos

1. **pagaAlquiler():** makes the action of paying the rent for the amount of the property and taking it out of your
   pocket.
2. **get Propiedad():*‍ Brings the data of the properties with the amounts of their rents.

---

## Interface of Turn

**Current Turn*: Displays a window indicating the Turn of the player to which it corresponds.

## Methods

1. **throw Dados():** executes the action of rolling the dice.

---

## Interface of rest

**Rest*:Shows a window with the possibility to continue playing or stay another shift resting.*

## Methods

1. **throw Dados():** executes the action of rolling the dice.

2. **take Descanso():** omits the action of rolling dice and passes the turn to the next player.

---

## Free Parking Interface

**Free parking*: Show a window indicating that the player who cannot stop on that box, forcing him to roll the dice
again.

## Methods

1. *throw Dados():** executes the action of rolling the dice.

---

## Interface Show Cards

### Abstraction:
***Show cards**: Display a window with the card data and perform the actions indicated.*

### Card Type:

**Movements cards:**
- Obtaining this type of card allows you to perform movement actions such as: "Continue to Buenos Aires", "Continue
  until you leave", "Return three steps", etc.

**Cards to receive money:**
- When obtaining this type of letters, the actions or events that will be carried out will be to receive payments,
  collections or money for different reasons, for example: "You have won the agricola contest. Receive $2000", “You inherit
  2000”, “You charge 1,000 for bank interest ", "It's your birthday, you collect 200 from each of the players", etc.

**Penalty cars:**
- Upon receiving the penalty cards, the player must pay what is indicated on them, such as: "Your properties have to be
  repaired, pay the bank $500 for each farm and $2500 for each stay," "Fine for speeding. Pay $300", "Pharmacy expenses. Pay
  $1000".

**Special cards:**
- Special cards, as their name indicates, will be different cards, such as: "Go to prison".

### Interface Methods:
1. **executeAction():** This method would execute the action described by the card it obtained.
2. **viewCard():** This method shows a brief description of the card so the player can know how it works.
3. **checkCardType():** This method checks what type of card it is, whether it is luck or destiny.

---

## Boxes Interface

### Abstraction:
*The boxes represent the place where each player is located, with their respective characteristics.*

### Types of boxes:
1.*Property*
2.*Rest*
3.*Commissioner*
4.*Luck*
5.*Destination*
6.*Bonus*
7.*Punishment*
**returnToMainMenu()**: shows the player a screen indicating 3 options to perform save the estancieroGame, return to the estancieroGame and
exit the estancieroGame.
## Interface Methods:
1. **String getDescription():** This method shows the type of box with your information.
2. **void activateAction(Player player):** This method activates the action of the box where the player fell.
3. **boolean hasOwner():** This method indicates whether the box is owned.

---

## Property Interface

### Abstraction:
*Properties in the Estanciero estancieroGame are assets that players can acquire and manage to generate income through rents. Each property has a purchase value, a rental value, and can be improved to increase its worth and profitability. Efficient management of properties is crucial for increasing wealth and outperforming opponents in the estancieroGame.*

### Property Attributes:
1. **Name:** Unique identification of each property in the estancieroGame.
2. **Purchase Value:** Initial price to acquire the property.
3. **Rental Value:** Amount that players must pay to the owner of the property when they land on it.
4. **Owner:** Player who owns the property at any given time.
5. **Improvement Status:** Indicates whether the property has been upgraded and at what level.

### Interface Methods:
1. **String getName():** This methods returns the name of the property. It is used to obtain the name of the property.
2. **int getPurchaseValue():** This methods returns the purchase value of the property. It provides the initial price at which the property was acquired.
3. **int getRentalValue():** This methods returns the rental value of the property. It indicates the amount that players must pay to the owner of the property when they land on it.
4. **Player getOwner():** This methods returns the owner value of the property. It is useful for obtaining information about the player who currently owns the property.
5. **void setOwner(Player player):** This methods sets the owner of the property. It is used to change the ownership of a property from one player to another, such as when a player buys or sells a property.
6. **int getImprovementState():** This methods returns the improvement state of the property. It indicates if the property has been improved and at what level.
7. **void improveProperty():** This methods improves the property, increasing its value and profitability. For example, it could increase the purchase value and rental value of the property.
8. **void degradeProperty():** This methods degrades the property, decreasing its value and profitability. For example, it could decrease the purchase value and rental value of the property.

---

## Player Interface

### Abstraction:

*Players of the estancieroGame acquire and manage properties, carry out financial transactions with other players and with the bank.*

### Player Attributes:

1. **Name:** Identify the player in the estancieroGame.
2. **Money:** Amount of money available to carry out financial transactions and purchase properties.
3. **Properties:** List of properties acquired by the player during the estancieroGame.
4. **ProfilePlayer:** Behavior that players will acquire depending on the difficulty level that the user chooses.

### Interface Methods:

1. **getName():** Returns the player's name.
2. **getMoney():** Returns the amount of player money available to use in the estancieroGame.
3. **setMoney(int amount):** Sets the player's amount of money when starting the estancieroGame, spinning the board, or collecting rent on their properties.
4. **getProperties():** Returns the list of properties the player purchased.
5. **buyProperty(Property property):** Allows the player to purchase an available property.
6. **getBehavior(int dificulty):** allows obtaining the player's behavior according to the difficulty chosen by the player. 
