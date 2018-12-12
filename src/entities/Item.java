package entities;

import static gamepack.Game.BULLET;
import static gamepack.Game.EXIT;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.JOHNNY;
import static gamepack.Game.MAPHEIGHT;
import static gamepack.Game.MAPWIDTH;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.ZOMBIE;
import java.awt.event.KeyEvent;

public class Item extends Entity implements Runnable{
    int input;
    
    public Item(String ICON){
        this.ICON = ICON;
        HP = 0;
        TOTALHP = 0;
        ATTACKDAMAGE = 0;
        ARMOR = 999999999;
        VISION = 0;
    }
    
    public void autoRun(KeyEvent input){
        int a = giveShootDir(input);
        while(true){
            for(int i=0 ; i<MAPHEIGHT ; i++){
                for(int j=0 ; j<MAPWIDTH ; j++){
                    if(this.getOwnMap()[j][i]){
                        try{
                            wait(500);
                            this.executeCollisionAction(a);
                        } catch (InterruptedException e){}   
                    }
                }
            }
        } 
    }
    public int giveShootDir(KeyEvent input){
        switch (input.getKeyCode()){
            case KeyEvent.VK_UP:
                return 0;
            case KeyEvent.VK_DOWN:
                return 1;
            case KeyEvent.VK_LEFT:
                return 2;
            case KeyEvent.VK_RIGHT:
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

    @Override
    public void run() {
        
    }
}
