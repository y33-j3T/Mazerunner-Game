package entities;

import static gamepack.Game.BULLET;
import static gamepack.Game.BULLETMAP;
import static gamepack.Game.EXIT;
import static gamepack.Game.EXITMAP;
import static gamepack.Game.GOLD;
import static gamepack.Game.GOLDMAP;
import static gamepack.Game.GOLD_amount;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.HORIZONTALWALLMAP;
import static gamepack.Game.HPREGEN;
import static gamepack.Game.HPREGENMAP;
import static gamepack.Game.LOSTITEM;
import static gamepack.Game.LOSTITEMMAP;
import static gamepack.Game.LOSTITEM_amount;
import static gamepack.Game.LOSTITEM_totalAmount;
import static gamepack.Game.PATH;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.VERTICALWALLMAP;
import static gamepack.Game.ZOMBIE;
import static gamepack.Game.ZOMBIEMAP;
import java.awt.event.KeyEvent;

public class Player extends Entity{
    
    public Player(){
        ICON = " J ";
        HP = 100;
        TOTALHP = 100;
        ATTACKDAMAGE = 5;
        ARMOR = 2;
        VISION = 2;
        SPEED = 500;
    }
   
    public int getUpVisionRange(){
        int visionRange=1;
        while(visionRange<VISION){
            if(VERTICALWALLMAP[this.getX()][this.getY()-visionRange]==true || HORIZONTALWALLMAP[this.getX()][this.getY()-visionRange]==true){
                return visionRange;
            } else {
                visionRange++;
            }
        }
        return visionRange;    
    }
    public int getDownVisionRange(){
        int visionRange=1;
        while(visionRange<VISION){
            if(VERTICALWALLMAP[this.getX()][this.getY()+visionRange]==true || HORIZONTALWALLMAP[this.getX()][this.getY()+visionRange]==true){
                return visionRange;
            } else {
                visionRange++;
            }
        }
        return visionRange;    
    }
    public int getLeftVisionRange(){
        int visionRange=1;
        while(visionRange<VISION){
            if(VERTICALWALLMAP[this.getX()-visionRange][this.getY()]==true || HORIZONTALWALLMAP[this.getX()-visionRange][this.getY()]==true){
                return visionRange;
            } else {
                visionRange++;
            }
        }
        return visionRange;    
    }
    public int getRightVisionRange(){
    int visionRange=1;
    while(visionRange<VISION){
        if(VERTICALWALLMAP[this.getX()+visionRange][this.getY()]==true || HORIZONTALWALLMAP[this.getX()+visionRange][this.getY()]==true){
            return visionRange;
        } else {
            visionRange++;
        }
    }
    return visionRange;    
}
    
    public void executeCollisionAction(KeyEvent input){                          // to be overriden from each child class
        if(getCollidedBlock(input)==ZOMBIE){
            this.subHP(ZOMBIE.getAttackDamage()-this.getArmor());
        }
        if(getCollidedBlock(input)==EXIT){
            if(LOSTITEM_amount<LOSTITEM_totalAmount){
                System.out.println("You haven't collected all items, r u sure?");
                // pause
                // if yes
                    //exitSeq(lost)
                // else
                    // unpause
            } else {
                // clear screen
                // exitSeq(won)
            }
        }
        else if(getCollidedBlock(input)==LOSTITEM){
            move(input);
            LOSTITEM_amount+=1;
            LOSTITEMMAP[this.getX()][this.getY()]=false;
        }
        else if(getCollidedBlock(input)==HPREGEN){
            move(input);
            if(this.TOTALHP-this.getHP()<5)
                this.setHP(this.TOTALHP);
            else
                this.addHP(5);
            HPREGENMAP[this.getX()][this.getY()]=false;
        }
        else if(getCollidedBlock(input)==GOLD){
            move(input);
            GOLD_amount+=5;
            GOLDMAP[this.getX()][this.getY()]=false;
        }
        else if(getCollidedBlock(input)==PATH){
            move(input);
        }
        // else VERTICALWALL & HORIZONTALWALL left
        // so do nothing
    }
    public Entity getCollidedBlock(KeyEvent input){
        switch (input.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                if(ZOMBIEMAP[this.getX()][this.getY()-1])
                    return ZOMBIE;
                else if(VERTICALWALLMAP[this.getX()][this.getY()-1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()-1])
                    return HORIZONTALWALL;
                else if(EXITMAP[this.getX()][this.getY()-1])
                    return EXIT;
                else if(BULLETMAP[this.getX()][this.getY()-1])
                    return BULLET;
                else if(LOSTITEMMAP[this.getX()][this.getY()-1])
                    return LOSTITEM;
                else if(HPREGENMAP[this.getX()][this.getY()-1])
                    return HPREGEN;
                else if(GOLDMAP[this.getX()][this.getY()-1])
                    return GOLD;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                if(ZOMBIEMAP[this.getX()][this.getY()+1])
                    return ZOMBIE;
                else if(VERTICALWALLMAP[this.getX()][this.getY()+1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()+1])
                    return HORIZONTALWALL;
                else if(EXITMAP[this.getX()][this.getY()+1])
                    return EXIT;
                else if(BULLETMAP[this.getX()][this.getY()+1])
                    return BULLET;
                else if(LOSTITEMMAP[this.getX()][this.getY()+1])
                    return LOSTITEM;
                else if(HPREGENMAP[this.getX()][this.getY()+1])
                    return HPREGEN;
                else if(GOLDMAP[this.getX()][this.getY()+1])
                    return GOLD;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                if(ZOMBIEMAP[this.getX()-1][this.getY()])
                    return ZOMBIE;
                else if(VERTICALWALLMAP[this.getX()-1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()-1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXITMAP[this.getX()-1][this.getY()])
                    return EXIT;
                else if(BULLETMAP[this.getX()-1][this.getY()])
                    return BULLET;
                else if(LOSTITEMMAP[this.getX()-1][this.getY()])
                    return LOSTITEM;
                else if(HPREGENMAP[this.getX()-1][this.getY()])
                    return HPREGEN;
                else if(GOLDMAP[this.getX()-1][this.getY()])
                    return GOLD;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                if(ZOMBIEMAP[this.getX()+1][this.getY()])
                    return ZOMBIE;
                else if(VERTICALWALLMAP[this.getX()+1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()+1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXITMAP[this.getX()+1][this.getY()])
                    return EXIT;
                else if(BULLETMAP[this.getX()+1][this.getY()])
                    return BULLET;
                else if(LOSTITEMMAP[this.getX()+1][this.getY()])
                    return LOSTITEM;
                else if(HPREGENMAP[this.getX()+1][this.getY()])
                    return HPREGEN;
                else if(GOLDMAP[this.getX()+1][this.getY()])
                    return GOLD;
        }
        return PATH;
    }
    public void move(KeyEvent input){
        switch (input.getKeyCode()){
            case KeyEvent.VK_W:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setY(this.getY()-1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case KeyEvent.VK_S:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setY(this.getY()+1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case KeyEvent.VK_A:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setX(this.getX()-1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case KeyEvent.VK_D:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setX(this.getX()+1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
        }
    }
}
