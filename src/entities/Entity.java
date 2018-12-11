package entities;

import static gamepack.Game.*;
import java.awt.event.KeyEvent;

public class Entity {
    protected int x, y;
    protected String ICON;
    protected int HP;
    protected int TOTALHP;
    protected int ATTACKDAMAGE;
    protected int ARMOR;
    protected int VISION;
    
    // getters
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getIcon(){
        return ICON;
    }
    public int getHP(){
        return HP;
    }
    public int getTotalHP(){
        return TOTALHP;
    }
    public int getAttackDamage(){
        return ATTACKDAMAGE;
    }
    public int getArmor(){
        return ARMOR;
    }
    public int getVision(){
        return VISION;
    }
    public int getSpeed(){
        return SPEED;
    }
    public boolean[][] getOwnMap(){
        if (this == JOHNNY)
            return JOHNNYMAP;
        else if(this == ZOMBIE)
            return ZOMBIEMAP;
        else if(this == VERTICALWALL)
            return VERTICALWALLMAP;
        else if(this == HORIZONTALWALL)
            return HORIZONTALWALLMAP;
        else if(this == BULLET)
            return BULLETMAP;
        else if(this == EXIT)
            return EXITMAP;
        else if(this == LOSTITEM)
            return LOSTITEMMAP;
        else if(this == HPREGEN)
            return HPREGENMAP;
        else if(this == GOLD)
            return GOLDMAP;
        else if(this == PATH)
            return PATHMAP;
        else if(this == FOG)
            return FOGMAP;
        return null;
    }
    
    // setters
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setIcon(String ICON){
        this.ICON = ICON;
    }
    public void setHP(int HP){
        this.HP = HP;
    }
    public void setTotalHP(int TOTALHP){
        this.TOTALHP = TOTALHP;
    }
    public void setAttackDamage(int ATTACKDAMAGE){
        this.ATTACKDAMAGE = ATTACKDAMAGE;
    }
    public void setArmor(int ARMOR){
        this.ARMOR = ARMOR;
    }
    public void setVision(int VISION){
        this.VISION = VISION;
    }
    
    // some entity method
    public void addHP(int amountOfHP){
        this.HP += amountOfHP;
    }
    public void subHP(int amountOfHP){
        this.HP -= amountOfHP;
    }
    public void addTotalHP(int amountOfTotalHP){
        this.TOTALHP += amountOfTotalHP;
    }
    public void addAttackDamage(int amountofAttackDamage){
        this.ATTACKDAMAGE += amountofAttackDamage;
    }
    public void addArmor(int amountOfArmor){
        this.ARMOR += amountOfArmor;
    }
    public void addVision(int amountOfVision){
        this.VISION += amountOfVision;
    }
    
    public void move(int a){
        switch (a){
            case 0:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setY(this.getY()-1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case 1:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setY(this.getY()+1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case 2:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setX(this.getX()-1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            case 3:
                this.getOwnMap()[this.getX()][this.getY()]=false;
                this.setX(this.getX()+1);
                this.getOwnMap()[this.getX()][this.getY()]=true;
                break;
            default:
                break;
        }
    }
    
    public Entity getCollidedBlock(int a){
        switch (a) {
            case 0:
                if(JOHNNYMAP[this.getX()][this.getY()-1])
                    return JOHNNY;
                else if(ZOMBIEMAP[this.getX()][this.getY()-1])
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
            case 1:
                if(JOHNNYMAP[this.getX()][this.getY()+1])
                    return JOHNNY;
                else if(ZOMBIEMAP[this.getX()][this.getY()+1])
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
            case 2:
                if(JOHNNYMAP[this.getX()-1][this.getY()])
                    return JOHNNY;
                else if(ZOMBIEMAP[this.getX()-1][this.getY()-1])
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
            case 3:
                if(JOHNNYMAP[this.getX()+1][this.getY()])
                    return JOHNNY;
                else if(ZOMBIEMAP[this.getX()+1][this.getY()-1])
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
            default:
                break;
        }
        return PATH;
    }                       
}

    // entity collision
//    public boolean checkIfCollided(KeyEvent input){
//        if((input.getKeyCode()==KeyEvent.VK_UP||input.getKeyCode()==KeyEvent.VK_W) && MAP[this.getX()][this.getY()-1][1].equals("   "))
//            return false;
//        else if((input.getKeyCode()==KeyEvent.VK_DOWN||input.getKeyCode()==KeyEvent.VK_S)&& MAP[this.getX()][this.getY()+1][1].equals("   "))
//            return false;
//        else if((input.getKeyCode()==KeyEvent.VK_LEFT||input.getKeyCode()==KeyEvent.VK_A)&& MAP[this.getX()-1][this.getY()][1].equals("   "))
//            return false;
//        else if((input.getKeyCode()==KeyEvent.VK_RIGHT||input.getKeyCode()==KeyEvent.VK_D)&& MAP[this.getX()+1][this.getY()][1].equals("   "))
//            return false;
//        return true;
//    }