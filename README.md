# Mazerunner Game
Action maze game with mob fighting and player upgrade mechanics made with vanilla Java.

## Contents
- [Introduction](#Introduction)
- [Game details](#Game-details)
  - [Story](#Story)
  - [Objective](#Objective)
  - [Settings](#Settings)
  - [UI styling](#UI-styling)
  - [Flow](#Flow)
  - [Controls](#Controls)
- [Installation](#Installation)
- [Usage](#Usage)
- [Contributing](#Contributing)
- [Credits](#Credits)
- [License](#License)

## Introduction
Mazerunner game is my assignment for a Java programming course.

## Game details
### Story
Johnny, a renowned Maze Runner, is experienced in hunting for valuables. However, on his previous expedition, he was attacked by the scary Some Tribe in Some Island. When he woke up, he found himself in the middle of a dark scary night. He has no idea where he is.
Judging from his intuition, Johnny believes that he is being trapped in the famous GG Maze of Some Island. He needs to escape Some Island as soon as possible but needs to collect all his lost valueables in GG Maze. As the player, you are Johnny.

summary, h3 {display:inline}
<details>
  <summary><h3 style = "display:inline-block">Objective</h3></summary>
  
  - Collect all lost items.
  - Navigate to the exit after collecting all lost items.
  - Survive.

</details>

### Settings
- A maze of size 20 x 20.
- The maze will always have an exit <kbd>E</kbd> for Johnny to escape.
- Other than what is visible by Johnny, the maze is be blacked out with <kbd>#</kbd>. (Johnny cannot see through walls)
- Johnny is able to move up, down, left and right in the maze depending on whether there are any obstacles or not.
- The lost items/valuables are randomly scattered around the maze, represented by <kbd>@</kbd>.
- If Johnny leaves the maze without all the lost items, Johnny is considered a disgrace to the Maze Runner’s community.

### UI styling 
- Simple. 
- Vintage.
- Console game look-alike.
- Every game component only uses keyboard characters. 
Features such as upgrades for Johnny, Zombies and Zombie shooting using Bullets are added as part of an action game.The right side of the window should display Johnny’s stats, game explanations and instructions as well as an option to trigger game sound. 

### Flow
1. Input the dimensions for the maze. (20 x 20 - 100 x 100). It would then show the game window after players are done. Every time Johnny’s gold amount reaches 40, a pop-up would show for players to upgrade Johnny. As Johnny attempts to exit the maze, a pop-up would also show depending on Johnny’s current stats.

### Controls
In the window, players can control Johnny using W, A, S, D keys and use Johnny to shoot zombie mobs using Up, Down, Left, Right keys. 

## Installation

## Usage

## Contributing

## Credits

## License
Mazerunner-Game is licensed under the [Apache License 2.0](./LICENSE)
