package entities;

import static gamepack.Game.BULLET;
import static gamepack.Game.EXIT;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.JOHNNY;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.ZOMBIE;
import java.awt.event.KeyEvent;

public class Item extends Entity{
    public Item(String ICON){
        this.ICON = ICON;
        HP = 0;
        TOTALHP = 0;
        ATTACKDAMAGE = 0;
        ARMOR = 999999999;
        VISION = 0;
        SPEED = 0;
    }
    
    public int giveShootDir(KeyEvent input){
        switch (input.getKeyCode()){
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                return 0;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                return 1;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                return 2;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                return 3;
        }
        return -1;
    }
    public void executeCollisionAction(int a){
        if(getCollidedBlock(a)==JOHNNY)
        if(getCollidedBlock(a)==ZOMBIE)
        if(getCollidedBlock(a)==EXIT)
        if(getCollidedBlock(a)==VERTICALWALL)
        if(getCollidedBlock(a)==HORIZONTALWALL)
        if(getCollidedBlock(a)==BULLET)
            this.getOwnMap()[this.getX()][this.getY()]=false;
        else
            this.move(a);
    }
    
    public void autoRun(){
        
    }
}
