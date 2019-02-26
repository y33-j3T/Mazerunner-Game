# Mazerunner Game
Action maze game with mob fighting and player upgrade mechanics made with vanilla Java

## Table of contents
- [Introduction](#Introduction)
- [Game story](#Game-story)
- [Game objective](#Game-objective)
- [Game settings](#Game-settings)
- [Approach taken](#Approach-taken)

### Introduction
Mazerunner game is my assignment for a Java programming course.

### Game story
Johnny, a renowned Maze Runner is experienced in hunting for valuables. However, during his previous expedition, he was attacked by the scary Some Tribe in Some Island. The moment when he woke up, it is in the middle of a dark scary night. He has no idea where he is.
Judging from his intuition, Johnny believes that he is being trapped in the famous GG Maze of Some Island. Johnny needs to escape Some Island as soon as possible but he needs to collect all the valuables that he has lost from GG Maze.

### Game objective
- Navigate Johnny to collect all lost items.
- Navigate Johnny to exit the maze.

### Game settings
1. A maze of size 20 x 20.
2. The maze will always have an exit <kbd>E</kbd> for Johnny to escape.
3. Other than what is visible by Johnny, the maze must be blacked out with <kbd>#</kbd>. (Johnny cannot see through walls)
4. Johnny should be able to move up, down, left and right in the maze depending on whether there are any obstacles or not.
5. The lost items/valuables should be randomly scattered around the maze, represented by <kbd>@</kbd>.
6. If Johnny leaves the maze without all the lost items, Johnny is considered a disgrace to the Maze Runner’s community.

### Approach taken 
My approach was to create an action maze game that looked vintage like a console game, integrated within a simple user interface (UI). Every game component should only use keyboard characters. Features such as upgrades for Johnny, Zombies and Zombie shooting using Bullets are added as part of an action game.

The game should start by asking players to input the dimensions for the maze, which has a range from 20 x 20 to 100 x 100. It would then show the game window after players are done. In the window, players can control Johnny using W, A, S, D keys and use Johnny to shoot zombie mobs using Up, Down, Left, Right keys. The right side of the window should display Johnny’s stats, game explanations and instructions as well as an option to trigger game sound. Every time Johnny’s gold amount reaches 40, a pop-up would show for players to upgrade Johnny. As Johnny attempts to exit the maze, a pop-up would also show depending on Johnny’s current stats.
