# Overview

Mastermind was inspired by the old pencil and paper game called Bulls and Cows, and was put into board form by Mordecai Meirowitz in 1970.
The goal of the game is to guess the code created by the mastermind, and it comes in various configurations when it comes to the number of available colors and slots.

# Gameplay
The game starts off with the mastermind choosing their combination and hiding it, after which, the code breaker must guess a combination.
Then, the mastermind must respond to the guess with appropriate hints, in the form of coloured balls, that tell the code breaker how many colours they guessed in the right spots, and how many they guessed in the wrong spots.
A red ball means the player placed a color in the right spot, a white ball means they placed a color in the wrong spot. 	The order of the hints does not matter, but the order of the guess colors does.
The game progresses like this until either the code breaker guesses the right combination or they run out of space on the board.

# Implementation and Features

Java Development Kit 16.0.2 was used to implement this digital version of the game which came to life by modifying the existing classes provided by the Java Swing package.
The mastermind player was removed in the process to allow a more easy-to-setup game involving only one player.
We used a 10 by 4 game board with 6 possible colors, meaning 2 colors will always be missing from the code.
We also allow the player to pick identical colors in their guess.
A save-load feature is also in the game in case the player needs to quit and come back.
 
# Installation
	
-Download and install JDK 16.0.2 https://www.oracle.com/java/technologies/downloads/#jdk17-windows
-Download the folder "Mastermind" from the master branch in the repository and save it anywhere on your local machine
-Play by double clicking the "Play Mastermind.bat" file

# Known issues

-Currently the game can only run in fullscreen because of windows display scaling issues.
-The code can be deduced from the save file.
