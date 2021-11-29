# package - gamepack
* **Main.java** - This class contains the main method, which will launch a mazeDimensionDialog Class to get input from user to initialize the game.

* **Game.java** - This class controls the game progression. It first updates the maze dimension by taking values from the mazeDimensionDialog Class and passes it to the MazeGenerator Class to generate a random maze. It then updates the values taken from the input obtained using the KeyListener in gameFrame Class and executes the corresponding actions, to invoke areYouSureDialog, winDialog, loseDialog or upgradeDialog Class. This class is called by the gameFrame class to initialize the maze and every 70 milliseconds subsequently to update the maze and display.

* **gameFrame.java** - This class launches a JFrame. It runs the game, displays the map, player stats, game instructions, game explanation and game sound controls. It also takes input from users using KeyListener. In this window, users can control Johnny using W, A, S, D keys and make Johnny shoot mobs using UP, DOWN, LEFT, RIGHT keys. It consists of 3 sub threads, one to update the map every 70 milliseconds;
one to update the automatic movement of zombie mobs every 1000 milliseconds; one to update the movement of Bullets every 200 milliseconds.

* **winDialog.java** - This class launches a JDialog when users reaches the maze exit, “E”, after collecting all lost items, “@”. It indicates that the user has won the game and exits the game after the “Quit” button is clicked on.

* **loseDialog.java** - This class launches a JDialog when users click on “Yes” from the areYouSureDialog Class or dying after all of Johnny’s lives are used up. It indicates that the user has lost the game and exits the game after the “Quit” button is clicked on.

* **pauseDialog.java** - This class launches a JDialog when users press on the P key and pauses the game. The game will only continue after the "Continue" button is clicked on.

* **upgradeDialog.java** - This class launches a JDialog when Johnny’s gold amount reaches 40. It will prompt the user to purchase an upgrade to level up Johnny’s attributes. It consists of 4 buttons for each of Johnny’s attributes, namely TotalHP, Armor, Vision and Attack Damage. After the user clicks on anyone of them, the attribute is upgraded, Johnny’s gold is deducted by 40 and the JDialog is disposed.

* **areYouSureDialog.java** - This class launches a JDialog to reconfirm if users want to exit the maze and end the game as they reach the maze exit, “E”. It will only launch if users have not collected all the lost items, “@”. It consists of two buttons, “Yes” and “No”. If the user picks “Yes”, an instance of loseDialog Class will be launched, else if the user picks “No”, the dialog is disposed and the user can continue gameplay.

* **mazeDimensionDialog.java** - This class launches a JDialog to take input from user for the width and height of maze using two
JSpinner. It will launch the game frame after users click on the “Done” button.

---

* **gameFrame.form** - Form design. IDE generated.

* **winDialog.form** -  Form design. IDE generated.

* **loseDialog.form** - Form design. IDE generated.

* **pauseDialog.form** - Form design. IDE generated.

* **upgradeDialog.form** - Form design. IDE generated.

* **areYouSureDialog.form** - Form design. IDE generated.

* **mazeDimensionDialog.form** - Form design. IDE generated.



