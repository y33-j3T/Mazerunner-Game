package entities;

import static gamepack.Game.spawnX;
import static gamepack.Game.spawnY;
import static gamepack.Game.BULLET;
import static gamepack.Game.BULLETMAP;
import static gamepack.Game.EXIT;
import static gamepack.Game.EXITMAP;
import static gamepack.Game.GOLD;
import static gamepack.Game.GOLDMAP;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.HORIZONTALWALLMAP;
import static gamepack.Game.HPREGEN;
import static gamepack.Game.HPREGENMAP;
import static gamepack.Game.LOSTITEM;
import static gamepack.Game.LOSTITEMMAP;
import static gamepack.Game.PATH;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.VERTICALWALLMAP;
import static gamepack.Game.ZOMBIE;
import static gamepack.Game.ZOMBIEMAP;
import java.awt.event.KeyEvent;

public class Player extends Entity{
    private int LIVES = 3;
    private int LOSTITEM_amount=0;
    private int LOSTITEM_totalAmount=0;    
    private int GOLD_amount=0;
    
    public Player(){
        ICON = " J ";
        HP = 100;
        TOTALHP = 100;
        ATTACKDAMAGE = 5;
        ARMOR = 2;
        VISION = 2;
    }
   
    public int getLives(){
        return this.LIVES;
    }
    public int getLostItemAmount(){
        return this.LOSTITEM_amount;
    }
    public int getTotalLostItemAmount(){
        return this.LOSTITEM_totalAmount;
    }
    public int getGoldAmount(){
        return this.GOLD_amount;
    }

    public void setLIVES(int LIVES) {
        this.LIVES = LIVES;
    }
    public void setLOSTITEM_amount(int LOSTITEM_amount) {
        this.LOSTITEM_amount = LOSTITEM_amount;
    }
    public void setLOSTITEM_totalAmount(int LOSTITEM_totalAmount) {
        this.LOSTITEM_totalAmount = LOSTITEM_totalAmount;
    }
    public void setGOLD_amount(int GOLD_amount) {
        this.GOLD_amount = GOLD_amount;
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
    
    public void executeCollisionAction(KeyEvent input){                          
        if(this.getCollidedBlock(input)==ZOMBIE){
            this.subHP(ZOMBIE.getAttackDamage()-this.getArmor());
            if(this.getHP()<=0){
                if(LIVES>0){
                    LIVES--;
                    this.getOwnMap()[this.getX()][this.getY()]=false;
                    this.setPosition(spawnX, spawnY);
                    this.getOwnMap()[this.getX()][this.getY()]=true;
                } else {
//                    exitSeq(1);
                }
            }
        }
        if(this.getCollidedBlock(input)==EXIT){
            if(LOSTITEM_amount<LOSTITEM_totalAmount){
                System.out.println("You haven't collected all items, r u sure?");
                // pop out 
                // if yes
                    //exitSeq(0)
                // else
                    // unpause
            } else {
                // clear screen
                // exitSeq(won)
            }
        }
        else if(this.getCollidedBlock(input)==LOSTITEM){
            move(input);
            LOSTITEM_amount+=1;
            LOSTITEMMAP[this.getX()][this.getY()]=false;
        }
        else if(this.getCollidedBlock(input)==HPREGEN){
            move(input);
            if(this.TOTALHP-this.getHP()<5)
                this.setHP(this.TOTALHP);
            else
                this.addHP(5);
            HPREGENMAP[this.getX()][this.getY()]=false;
        }
        else if(this.getCollidedBlock(input)==GOLD){
            move(input);
            GOLD_amount+=5;
            GOLDMAP[this.getX()][this.getY()]=false;
        }
        else if(this.getCollidedBlock(input)==PATH){
            move(input);
        }
        // else VERTICALWALL & HORIZONTALWALL left
        // so do nothing
    }
    public Entity getCollidedBlock(KeyEvent input){
        switch (input.getKeyCode()) {
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
