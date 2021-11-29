# Mazerunner Game
Action maze game with mob fighting and player upgrade mechanics made with vanilla Java.

## Contents
- [Mazerunner Game](#mazerunner-game)
  - [Contents](#contents)
  - [Introduction](#introduction)
  - [Program Description](#program-description)
    - [:runner: Story](#runner-story)
    - [:dart: Objective](#dart-objective)
    - [:hammer_and_wrench: Settings](#hammer_and_wrench-settings)
    - [:computer: UI Styling](#computer-ui-styling)
    - [:repeat: Flow](#repeat-flow)
    - [:ghost: Entities](#ghost-entities)
    - [:keyboard: Controls](#keyboard-controls)
  - [Installation](#installation)
  - [Usage](#usage)
  - [Contributing](#contributing)
  - [Credits](#credits)
  - [License](#license)

## Introduction
Mazerunner game was originally an assignment for a Java programming course. :books: My team and I decided to add some action and all to the originally boring maze. :joy: Was our first time to ever code any games. :poop: A little buggy, watch out! :laughing:

## Program Description
### :runner: Story
<details>
<summary>Details</summary>
  
Johnny, a renowned Maze Runner, is experienced in hunting for valuables. However, on his previous expedition, he was attacked by the scary Some Tribe in Some Island. When he woke up, he found himself in the middle of a dark scary night. He has no idea where he is. Judging from his intuition, Johnny believes that he is being trapped in the famous GG Maze of Some Island. He needs to escape Some Island as soon as possible but needs to collect all his lost items in GG Maze. As the player, you are Johnny.

</details>

### :dart: Objective
<details>
<summary>Details</summary>
  
- Collect all lost items.
- Navigate to the exit after collecting all lost items.
- Survive.

</details>

### :hammer_and_wrench: Settings
<details>
<summary>Details</summary>
  
- A maze of size 20 x 20.
- The maze will always have an exit <kbd>E</kbd> for Johnny to escape.
- Other than what is visible by Johnny, the maze is be blacked out with <kbd> # </kbd>. (Johnny cannot see through walls)
- Johnny is able to move up, down, left and right in the maze depending on whether there are any obstacles or not.
- The lost items are randomly scattered around the maze, represented by <kbd> @ </kbd>.
- If Johnny leaves the maze without all the lost items, Johnny is considered a disgrace to the Maze Runner’s community.

</details>

### :computer: UI Styling
<details>
<summary>Details</summary>
  
- Simple. 
- Vintage.
- Console game look-alike.
- Every game component only uses keyboard characters. 
- Game screen on the left.
- Game panel on the right.

</details>

### :repeat: Flow
<details>
<summary>Details</summary>

![Maze Runner Flow Chart](./Maze%20Runner%20Flow%20Chart.jpg)

</details>

### :ghost: Entities
<details>
<summary>Details</summary> 

- <kbd> J </kbd> Johnny
- <kbd> Z </kbd> Zombie
- <kbd> * </kbd> Bullet
- <kbd> # </kbd> Fog
- <kbd>   </kbd> Path
- <kbd> E </kbd> Exit
- <kbd> | </kbd> Vertical Wall
- <kbd>---</kbd> Horizontal Wall
- <kbd> @ </kbd> +1 Lost Item
- <kbd> $ </kbd> +5 Gold
- <kbd> + </kbd> +5 HP
  
</details>

### :keyboard: Controls
<details>
<summary>Details</summary> 
  
- <kbd>W</kbd> Move Up
- <kbd>A</kbd> Move Down
- <kbd>S</kbd> Move Right
- <kbd>D</kbd> Move Left
- <kbd>↑</kbd> Shoot Up
- <kbd>↓</kbd> Shoot Down
- <kbd>→</kbd> Shoot Right
- <kbd>←</kbd> Shoot Left
- <kbd>P</kbd> Pause

</details>

## Installation
- [Java SE Development Kit 8 (JDK 8)](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [NetBeans IDE 8.0.1](https://netbeans.org/downloads/8.0.1/)

## Usage
1. Download this repository in a zip file by clicking [here](https://github.com/y33-j3T/Mazerunner-Game/archive/master.zip) or execute this from the terminal:
```
git clone https://github.com/y33-j3T/Mazerunner-Game.git
```
2. Open your IDE.
3. Open the project with your IDE.
4. Build and run. 

## Contributing
Please refer to [CONTRIBUTE.md](./CONTRIBUTE.md) for details. :heart_eyes:

## Credits
A big shoutout to my seniors and friends who made it all happen. :blush:

- [:octocat: @ceyeoh0428](https://github.com/ceyeoh0428)
- [:octocat: @alvinwong64](https://github.com/alvinwong64)
- [:octocat: @tankianaun](https://github.com/TANKIANAUN)
- [:octocat: @waixiong](https://github.com/waixiong)
- [:octocat: @jiuntian](https://github.com/jiuntian)

## License
Mazerunner Game is released under the [Apache License 2.0](./LICENSE).