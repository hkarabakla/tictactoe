# TicTacToe Command Line

Implementation of [TicTacToe](https://en.wikipedia.org/wiki/Tic-tac-toe) Game with Java 8 and Gradle on command line

## Tech Stack
* Gradle : 4.8.1
* Java 8
* Junit

## Building the Application
In order to build the game just run the command below in the root folder of the application

    ./gradlew clean build

## Running Executable
In order to start playing firstly project must be built with the command shared above.
A configuration file must be created in the format below before starting the game. 
After that created jar must be run with the command below and created config file path must be given to javac command.

``
java -jar tictactoe-1.0-SNAPSHOT.jar config-3x3.properties
``

### Configuration File

Configuration file is important to initialize the game and format of the file is highly strict.
An example file content is depicted below; 

```
size=4
humanPlayer1=x
humanPlayer2=o
computer=+
```

* size         : Size of the nxn tictactoe board. Min value = 3, Max value = 10
* humanPlayer1 : First human player's character definition
* humanPlayer1 : Second human player's character definition
* computer     : Third player's character definition, this is a special player which is managed by the game itself randomly

## How to Play
1. Printer prints the initial board and first player is being selected randomly
2. Input collector waits for the player's slot choice (Randomly or from console)
3. Chosen slot is filled with the player's special character
4. Printer prints the latest situation of the board
5. 2, 3, 4 repeats until one player wins or running out of empty slot on the board 

## Decisions
1. The player managed by computer has no sophisticated AI.
2. This is not a networked game, therefore the two human players have to interact with the game via the same console.
3. JUnit tests only cover some of the top-most classes because the code topology is quite simple.
4. Logging is made with simple console prints due to external library limitations
