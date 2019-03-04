# Mazerunner Game
Action maze game with mob fighting and player upgrade mechanics made with vanilla Java.

## Contents
- [Introduction](#Introduction)
- [Game details](#Game-Details)
  - [Story](#runner-Story)
  - [Objective](#dart-Objective)
  - [Settings](#hammer_and_wrench-Settings)
  - [UI styling](#computer-UI-Styling)
  - [Flow](#repeat-Flow)
  - [Controls](#keyboard-Controls)
- [Installation](#Installation)
- [Usage](#Usage)
- [Contributing](#Contributing)
- [Credits](#Credits)
- [License](#License)

## Introduction
Mazerunner game was originally an assignment for a Java programming course. :books: My team and I decided to add some action and all to the originally boring maze. :joy: Was our first time to ever code any games. :poop: A little buggy, watch out! :laughing:

## Game Details
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
- Still working on the installation. :pensive:
- Just download the entire repository for now. :innocent:

## Usage
1. Open your IDE.
2. Open one of the `.java` files.
3. Build and run. 

## Contributing
Please refer to [CONTRIBUTE.md](./CONTRIBUTE.md) for details. :heart_eyes:

## Credits
A big shoutout to my seniors and friends who made it all happen. :blush:

- Yeoh Choon Eung [:octocat: @ceyeoh0428](https://github.com/ceyeoh0428)
- Alvin Wong Guan Sheng [:octocat: @alvinwong64](https://github.com/alvinwong64)
- Tan Kian Aun [:octocat: @tankianaun](https://github.com/TANKIANAUN)
- Xu Wai Xiong [:octocat: @waixiong](https://github.com/waixiong)
- Hoe Jiun Tian [:octocat: @jiuntian](https://github.com/jiuntian)

## License
Mazerunner-Game is licensed under the [Apache License 2.0](./LICENSE).
