<<<<<<< HEAD
# CPSC 210 Personal Project

## Chess Database 

As someone who is planning on getting into chess again,
<br> I have been looking for a chess database to study and,
<br> strategize my approach to different lines and openings.<br>
However, most databases are either online (chess.com, ...), or paid via a one-time or subscription payments.
<br>
As such, I thought it would be a great idea to code a chess database application of my own.<br>

*User stories*:
- As a user, I want to be able to add multiple game into the database using FIDE notation.
- As a user, I want to be able to determine the winner of a game based on the notation and moves entered.
- As a user, I want to be able to add multiple players to the database with their name, title, and win/loss record.
- As a user, I want to be able to see the players of the match, the rankings of the players.
- As a user, I want to be able to save all the newly added players and games upon exiting.
- As a user, I want to be able to load all the saved data and use it again.
- As a user, I want to be able to add multiple Players to the Database via the GUI.
- As a user, I want to be able to load and save the state of the application
- User **cannot** determine the best move from a certain position. This is **NOT** a chess engine.

# Instructions for Grader

- You can generate the first required event related to adding Xs to a Y by adding a Player and then clicking on Search Player button.
- You can generate the second required event related to adding Xs to a Y by...
- You can locate my visual component by...
- You can save the state of my application by clicking on the save button.
- You can reload the state of my application by clicking on the load button.

# Phase 4: Task 2
Sample events that are logged:
New Game was added has been added to database.
Player X has been added to database.
Player X was looked up.

# Phase 4: Task 3
Now looking at the UML graph, I could have done a better job with the GUI.
I should have put all the GUI in one large class instead of separating into 4 different Frames.
Besides that, there are some of the other design principals that I could have applied to my project to make the code
less chunky.
Citations:
- Persistence, WriterTest, and ReaderTest were inspired from the example file.

=======
# Chess Database
A program used to add and lookup a Player's matches and records.
## Description
This app was developed to help with keeping records of the moves made in previous games for analysis of chess lines and strategies.
You can add the game's moves, present players and other information to the interface, and later retrieve them using the GameID.
Similarly, the players you may have played against of interested in analyzing can be added alongside their records.

## Dependencies
Java 11 and its standard libraries

## How to run
Simply install JRE and run Main.java

## License
This project is licensed to Mohsen Bakhit [@TheStormBird](https:///github.com/thestormbird) under the MIT License.

## Version History
0.1 - Initial release

### P.S
This project was made as part of UBC CPSC 210: Software Construction
>>>>>>> 7c51fb892c8c4d90344e5e5de8725140ea5e6f19
