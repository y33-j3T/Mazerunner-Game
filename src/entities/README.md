# package - entities

**Entity.java** - This class acts as a base class for all objects in the game. They include Horizontal wall, Vertical wall, Exit, Johnny, Mob, Path, Bullet, Lost Item, HP Regen, Gold and Fog.

**Bullet.java** - This class extends Item Class and implements Runnable. It contains variables and functions for Bullets created. It updates all Bullet movements every 200 milliseconds.

**Item.java** - This class extends Entity Class. It contains variables and functions for Items created. Items created in this game include Horizontal wall, Vertical wall, Exit, Path, Bullet, Lost Item, HP Regen, Gold and Fog.

**Mob.java** - This class extends Entity Class and implements Runnable. It contains variables and functions for Mobs created. There is only one type of Mob created in this game, it is called Zombie. It updates all Zombie movement every 1000 milliseconds.

**Player.java** - This class extends Entity Class. It contains variables and functions for Johnny.

