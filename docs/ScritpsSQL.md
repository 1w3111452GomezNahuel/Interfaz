# <u> SQL CLASS SCRIPTS </U>

Here is the database script that will be used for the estancieroGame "the estanciero".

### Create base date

Create  DATABASE el_estanciero ;
---
### Create table ("Cards")
CREATE TABLE Cards(
id_card INT AUTO_INCREMENT PRIMARY KEY,
type VARCHAR(50),
id_typeCard INT,
description VARCHAR (255),
FOREIGN KEY (id_typeCard) REFERENCES cards(id)

)
---
### Insert of table ("Cards")
- INSERT INTO Cards (type,typeCard ,description) VALUES ('1,'luck','go back three steps');
- INSERT INTO Cards (type,typeCard ,description) VALUES ('1,'luck','siga hasta santa Fè, zona norte. si pasa por la salida cobre 5.000');
- INSERT INTO Cards (type,typeCard ,description) VALUES ('3','luck','pay 3000 for school expenses');
- INSERT INTO Cards (type,typeCard ,description) VALUES ('2','destiny','tax refund, collect 400');
- INSERT INTO Cards (type,typeCard ,description) VALUES ('2','destiny','He has won an agricultural contest. collect 2,000');

---
### Create table ("Dice")
CREATE TABLE Dice (
id_dice INT AUTO_INCREMENT PRIMARY KEY,
numberFace INT,
)
### Insert of table ("Dice")
-INSERT INTO Dice (numberFace,counter) VALUES (1,0);
-INSERT INTO Dice (numberFace,counter) VALUES (4,1);

### Create table ("TypeCards")
CREATE TABLE TypeCard(
id_typeCard INT AUTO_INCREMENT PRIMARY KEY,
description VARCHAR (250)
)
### Insert of table ("TypeCards")
- INSERT INTO Cards (typeCard ) VALUES ('movementscards');
- INSERT INTO Cards (typeCard ) VALUES ('cardReciveMoney');
- INSERT INTO Cards (typeCard ) VALUES ('penaltyCards');
- INSERT INTO Cards (typeCard ) VALUES ('specialCards');

---
### Create table ("Player")
CREATE TABLE Player (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
money INT NOT NULL,
color VARCHAR(50),
position INT DEFAULT 0,
UserType VARCHAR(50)
);

### Insert of table ("Player")

- INSERT INTO Player (name, money, color, UserType) VALUES ('Jugador1', 35000, 'Rojo', 'Persona');
- INSERT INTO Player (name, money, color, UserType) VALUES ('Jugador2', 35000, 'Azul', 'Bot');
- INSERT INTO Player (name, money, color, UserType) VALUES ('Jugador3', 35000, 'Verde', 'Bot');
- INSERT INTO Player (name, money, color, UserType) VALUES ('Jugador4', 35000, 'Amarillo', 'Bot');
---

### Create table ("StatePlayer")
CREATE TABLE StatePlayer (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
);

### Insert of table ( "State Player")
- INSERT INTO StatePlayer (name) VALUES ('enabled') ('disabled'), ('Suspendido');

---

---
### Create table ("Property")
CREATE TABLE Property (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
price INT NOT NULL,
owner_id INT,
Type VARCHAR(50),
rentalCost INT
);

### Insert of table ("Property")
- INSERT INTO Property (name, price, Type, rentalCost) VALUES ('Chacra 1', 500, 'Chacra', 50);
- INSERT INTO Property (name, price, Type, rentalCost) VALUES ('Estancia 1', 1000, 'Estancia', 100);
- INSERT INTO Property (name, price, Type, rentalCost) VALUES ('Chacra 2', 600, 'Chacra', 60);
- INSERT INTO Property (name, price, Type, rentalCost) VALUES ('Estancia 2', 1200, 'Estancia', 120);
---

---

### Create table ("Board")
CREATE TABLE Board (
idBoard INT IDENTITY(1,1),
idPlayer INT,     // id de player
position INT,
idBox INT,
CONSTRAINT pk_board PRIMARY KEY(idBoard),
CONSTRAINT fk_board_player FOREIGN KEY(idPlayer) REFERENCES Player(id),
CONSTRAINT fk_board_box FOREIGN KEY(idBox) REFERENCES Box(id)
)
---

---
### Create table ( "Bank")
CREATE TABLE BANK
(
id_bank INT IDENTITY(1,1),
money INT
)
---

---
### Create table ("Box")
CREATE TABLE Box (
id INT AUTO_INCREMENT PRIMARY KEY,
idBoard INT FOREIGN KEY,
idProperty INT FOREIGN KEY,
idType INT FOREIGN KEY,
position INT
CONSTRAINT pk_box PRIMARY KEY(id),
CONSTRAINT fk_board FOREIGN KEY(idBoard) REFERENCES Board(idBoard)
CONSTRAINT pk_box PRIMARY KEY(id),
CONSTRAINT fk_property FOREIGN KEY(idProperty) REFERENCES Property(id)
CONSTRAINT pk_box PRIMARY KEY(id),
CONSTRAINT fk_type FOREIGN KEY(idType) REFERENCES Type(id)
);

---

---
### Create table ("Type")
CREATE TABLE Box (
id INT AUTO_INCREMENT PRIMARY KEY,
description STRING
);

### Insert of table ("Type")
- INSERT INTO Type (description) VALUES ('Property');
- INSERT INTO Type (description) VALUES ('Rest');
- INSERT INTO Type (description) VALUES ('Commissioner');
- INSERT INTO Type (description) VALUES ('Luck');
- INSERT INTO Type (description) VALUES ('Destination');
- INSERT INTO Type (description) VALUES ('Bonus');
- INSERT INTO Type (description) VALUES ('Punishment');
---
