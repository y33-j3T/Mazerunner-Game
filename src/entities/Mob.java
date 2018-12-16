package entities;

import gamepack.Game;
import static gamepack.Game.BULLET;
import static gamepack.Game.BULLETMAP;
import static gamepack.Game.EXIT;
import static gamepack.Game.GOLD;
import static gamepack.Game.GOLDMAP;
import static gamepack.Game.HORIZONTALWALL;
import static gamepack.Game.HORIZONTALWALLMAP;
import static gamepack.Game.HPREGEN;
import static gamepack.Game.HPREGENMAP;
import static gamepack.Game.JOHNNY;
import static gamepack.Game.LOSTITEM;
import static gamepack.Game.LOSTITEMMAP;
import static gamepack.Game.PATH;
import static gamepack.Game.VERTICALWALL;
import static gamepack.Game.VERTICALWALLMAP;
import static gamepack.Game.ZOMBIE;
import static gamepack.Game.ZOMBIEMAP;
import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Mob extends Entity implements Runnable {
    protected int HP;
    protected int TOTALHP;
    protected int ATTACKDAMAGE;
    protected int ARMOR;
    protected int VISION;
    
    public Mob(String ICON, int x, int y){
        this.ICON = ICON;
        HP = 5;
        TOTALHP = 5;
        ATTACKDAMAGE = 5;
        ARMOR = 1;
        VISION = 5;
        this.x = x;
        this.y = y;
    }

    public Mob() {
        
    }

    public int getHP() {
        return HP;
    }
    public int getTOTALHP() {
        return TOTALHP;
    }
    public int getATTACKDAMAGE() {
        return ATTACKDAMAGE;
    }
    public int getARMOR() {
        return ARMOR;
    }
    public int getVISION() {
        return VISION;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    public void setTOTALHP(int TOTALHP) {
        this.TOTALHP = TOTALHP;
    }
    public void setATTACKDAMAGE(int ATTACKDAMAGE) {
        this.ATTACKDAMAGE = ATTACKDAMAGE;
    }
    public void setARMOR(int ARMOR) {
        this.ARMOR = ARMOR;
    }
    public void setVISION(int VISION) {
        this.VISION = VISION;
    }
    
    @Override
    public void run() {
        Random r = new Random();
        while(!ZOMBIEMAP.isEmpty()){
            try {
                for(int i=0 ; i<ZOMBIEMAP.size(); i++){
                    int a = r.nextInt(4);
                    ZOMBIEMAP.get(i).executeCollisionAction(a);
                }
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Mob.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void executeCollisionAction(int a){
        Random r = new Random();
        if(this.getCollidedBlock(a)==ZOMBIE)
        if(this.getCollidedBlock(a)==VERTICALWALL)
        if(this.getCollidedBlock(a)==HORIZONTALWALL)
        if(this.getCollidedBlock(a)==EXIT){
            this.executeCollisionAction(r.nextInt(4));
        } else {
            this.move(a);
        }
    }
    public void move(int input){
        switch (input){
            case 0:
                this.setY(this.getY()-1);
                break;
            case 1:
                this.setY(this.getY()+1);
                break;
            case 2:
                this.setX(this.getX()-1);
                break;
            case 3:
                this.setX(this.getX()+1);
                break;
        }
    }
    public Entity getCollidedBlock(int input){
        switch (input) {
            case 0:
                if(VERTICALWALLMAP[this.getX()][this.getY()-1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()-1])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX() && EXIT.getY()==this.getY()-1)
                    return EXIT;
                else if(JOHNNY.getX()==this.getX() && JOHNNY.getY()==this.getY()-1)
                    return JOHNNY;
                for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                    if(this.getX()==ZOMBIEMAP.get(i).getX() && this.getY()-1==ZOMBIEMAP.get(i).getY()){
                        return ZOMBIE;
                    }
                }
                for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                    if(this.getX()==LOSTITEMMAP.get(i).getX() && this.getY()-1==LOSTITEMMAP.get(i).getY()){
                        return LOSTITEM;
                    }
                }
                for(int i=0 ; i<HPREGENMAP.size() ; i++){
                    if(this.getX()==HPREGENMAP.get(i).getX() && this.getY()-1==HPREGENMAP.get(i).getY()){
                        return HPREGEN;
                    }
                }
                for(int i=0 ; i<GOLDMAP.size() ; i++){
                    if(this.getX()==GOLDMAP.get(i).getX() && this.getY()-1==GOLDMAP.get(i).getY()){
                        return GOLD;
                    }
                }
                for(int i=0 ; i<BULLETMAP.size() ; i++){
                    if(this.getX()==BULLETMAP.get(i).getX() && this.getY()-1==BULLETMAP.get(i).getY())                                   
                        return BULLET;
                }
            case 1:
                if(VERTICALWALLMAP[this.getX()][this.getY()+1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()+1])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX() && EXIT.getY()==this.getY()+1)
                    return EXIT;
                else if(JOHNNY.getX()==this.getX() && JOHNNY.getY()==this.getY()+1)
                    return JOHNNY;
                for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                    if(this.getX()==ZOMBIEMAP.get(i).getX() && this.getY()+1==ZOMBIEMAP.get(i).getY()){
                        return ZOMBIE;
                    }
                }
                for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                    if(this.getX()==LOSTITEMMAP.get(i).getX() && this.getY()+1==LOSTITEMMAP.get(i).getY()){
                        return LOSTITEM;
                    }
                }
                for(int i=0 ; i<HPREGENMAP.size() ; i++){
                    if(this.getX()==HPREGENMAP.get(i).getX() && this.getY()+1==HPREGENMAP.get(i).getY()){
                        return HPREGEN;
                    }
                }
                for(int i=0 ; i<GOLDMAP.size() ; i++){
                    if(this.getX()==GOLDMAP.get(i).getX() && this.getY()+1==GOLDMAP.get(i).getY()){
                        return GOLD;
                    }
                }
                for(int i=0 ; i<BULLETMAP.size() ; i++){
                    if(this.getX()==BULLETMAP.get(i).getX() && this.getY()+1==BULLETMAP.get(i).getY())                                   
                        return BULLET;
                }
            case 2:
                if(VERTICALWALLMAP[this.getX()-1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()-1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX()-1 && EXIT.getY()==this.getY())
                    return EXIT;
                else if(JOHNNY.getX()==this.getX()-1 && JOHNNY.getY()==this.getY())
                    return JOHNNY;
                for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                    if(this.getX()-1==ZOMBIEMAP.get(i).getX() && this.getY()==ZOMBIEMAP.get(i).getY()){
                        return ZOMBIE;
                    }
                }
                for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                    if(this.getX()-1==LOSTITEMMAP.get(i).getX() && this.getY()==LOSTITEMMAP.get(i).getY()){
                        return LOSTITEM;
                    }
                }
                for(int i=0 ; i<HPREGENMAP.size() ; i++){
                    if(this.getX()-1==HPREGENMAP.get(i).getX() && this.getY()==HPREGENMAP.get(i).getY()){
                        return HPREGEN;
                    }
                }
                for(int i=0 ; i<GOLDMAP.size() ; i++){
                    if(this.getX()-1==GOLDMAP.get(i).getX() && this.getY()==GOLDMAP.get(i).getY()){
                        return GOLD;
                    }
                }
                for(int i=0 ; i<BULLETMAP.size() ; i++){
                    if(this.getX()-1==BULLETMAP.get(i).getX() && this.getY()==BULLETMAP.get(i).getY())                                   
                        return BULLET;
                }
            case 3:
                if(VERTICALWALLMAP[this.getX()+1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()+1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX()+1 && EXIT.getY()==this.getY())
                    return EXIT;
                else if(JOHNNY.getX()==this.getX()+1 && JOHNNY.getY()==this.getY())
                    return JOHNNY;
                for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                    if(this.getX()+1==ZOMBIEMAP.get(i).getX() && this.getY()==ZOMBIEMAP.get(i).getY()){
                        return ZOMBIE;
                    }
                }
                for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                    if(this.getX()+1==LOSTITEMMAP.get(i).getX() && this.getY()==LOSTITEMMAP.get(i).getY()){
                        return LOSTITEM;
                    }
                }
                for(int i=0 ; i<HPREGENMAP.size() ; i++){
                    if(this.getX()+1==HPREGENMAP.get(i).getX() && this.getY()==HPREGENMAP.get(i).getY()){
                        return HPREGEN;
                    }
                }
                for(int i=0 ; i<GOLDMAP.size() ; i++){
                    if(this.getX()+1==GOLDMAP.get(i).getX() && this.getY()==GOLDMAP.get(i).getY()){
                        return GOLD;
                    }
                }
                for(int i=0 ; i<BULLETMAP.size() ; i++){
                    if(this.getX()+1==BULLETMAP.get(i).getX() && this.getY()==BULLETMAP.get(i).getY())                                   
                        return BULLET;
                }
        }
        return PATH;
    }

}
