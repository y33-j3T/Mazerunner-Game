package entities;

import gamepack.Game;
import static gamepack.Game.BULLET;
import static gamepack.Game.EXIT;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.JOHNNY;
import static gamepack.Game.MAPHEIGHT;
import static gamepack.Game.MAPWIDTH;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.ZOMBIE;
import java.util.Random;

public class Mob extends Entity implements Runnable {
    public Mob(String ICON ){
        this.ICON = ICON;
        HP = 5;
        TOTALHP = 5;
        ATTACKDAMAGE = 5;
        ARMOR = 1;
        VISION = 5;
    }
    
    public void autoRun(){
        Random r = new Random();
        while(true){
            for(int i=0 ; i<MAPHEIGHT ; i++){
                for(int j=0 ; j<MAPWIDTH ; j++){
                    if(this.getOwnMap()[j][i]){
                        try{
                            wait(1000);
                            this.executeCollisionAction(r.nextInt(4));
                        } catch (InterruptedException e){}   
                    }
                }
            }
        } 
    }
    public void executeCollisionAction(int a){
        Random r = new Random();
        if(getCollidedBlock(a)==ZOMBIE)
        if(getCollidedBlock(a)==VERTICALWALL)
        if(getCollidedBlock(a)==HORIZONTALWALL)
        if(getCollidedBlock(a)==EXIT)
            this.executeCollisionAction(r.nextInt(4));
        else if(getCollidedBlock(a)==BULLET){
            this.subHP(JOHNNY.getAttackDamage()-this.getArmor());
            if(this.getHP()<=0){
                this.getOwnMap()[this.getX()][this.getY()]=false;
                Game.randomAllocateEntity(this);
            }
        }
        else
            move(a);
    }

    @Override
    public void run() {
        this.autoRun();
    }
}
