package entities;

import static gamepack.Game.BULLET;
import static gamepack.Game.BULLETMAP;
import static gamepack.Game.EXIT;
import static gamepack.Game.FOG;
import static gamepack.Game.FOGMAP;
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
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bullet extends Item implements Runnable{
    protected int dir;
    
    public Bullet(String ICON, int x, int y, int dir) {
        super(ICON, x, y);
        this.dir = dir;
    }

    public Bullet() {
        
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    @Override
    public void run() {
        while (!BULLETMAP.isEmpty()){
            try {
                synchronized( this ){
                    try{
                        for(int i=0 ; i<BULLETMAP.size() ; i++){
                            int dir = BULLETMAP.get(i).getDir();

                            if(BULLETMAP.get(i).getCollidedBlock(dir)==ZOMBIE){
                                BULLETMAP.get(i).move(dir);
                                for(int j=0 ; j<ZOMBIEMAP.size() ; j++){
                                    if(ZOMBIEMAP.get(j).getX()==BULLETMAP.get(i).getX() && ZOMBIEMAP.get(j).getY()==BULLETMAP.get(i).getY()){
                                        ZOMBIEMAP.get(j).setHP(ZOMBIEMAP.get(j).getHP()-JOHNNY.getATTACKDAMAGE()+ZOMBIEMAP.get(j).getARMOR());
                                        BULLETMAP.remove(i);
                                    } 

                                    if(ZOMBIEMAP.get(j).getHP()<=0){
                                        ZOMBIEMAP.remove(j);
                                    }
                                }
                            }
                            else if(BULLETMAP.get(i).getCollidedBlock(dir)==VERTICALWALL){
                                BULLETMAP.remove(i);
                            }
                            else if(BULLETMAP.get(i).getCollidedBlock(dir)==HORIZONTALWALL){
                                BULLETMAP.remove(i);
                            }
                            else if(BULLETMAP.get(i).getCollidedBlock(dir)==EXIT){
                                BULLETMAP.remove(i);
                            }   
                            else if(BULLETMAP.get(i).getCollidedBlock(dir)==FOG){
                                BULLETMAP.remove(i);
                            }
                            else {
                                BULLETMAP.get(i).move(dir);
                            }
                        }
                    } catch (IndexOutOfBoundsException e){
                        
                    }
                    
                    this.wait(200);
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Bullet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (NullPointerException e){
                
            }
        }
    }
    
    public Entity getCollidedBlock(int input){
        switch (input) {
            case 0:
                if(VERTICALWALLMAP[this.getX()][this.getY()-1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()-1])
                    return HORIZONTALWALL;
                else if(FOGMAP[this.getX()][this.getY()-1])
                    return FOG;
                else if(EXIT.getX()==this.getX() && EXIT.getY()==this.getY()-1)
                    return EXIT;
                else {
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
                    return PATH;
                }
            case 1:
                if(VERTICALWALLMAP[this.getX()][this.getY()+1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()+1])
                    return HORIZONTALWALL;
                else if(FOGMAP[this.getX()][this.getY()+1])
                    return FOG;
                else if(EXIT.getX()==this.getX() && EXIT.getY()==this.getY()+1)
                    return EXIT;
                else {
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
                    return PATH;
                }
            case 2:
                if(VERTICALWALLMAP[this.getX()-1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()-1][this.getY()])
                    return HORIZONTALWALL;
                else if(FOGMAP[this.getX()-1][this.getY()])
                    return FOG;
                else if(EXIT.getX()==this.getX()-1 && EXIT.getY()==this.getY())
                    return EXIT;
                else {
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
                    return PATH;
                }
            case 3:
                if(VERTICALWALLMAP[this.getX()+1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()+1][this.getY()])
                    return HORIZONTALWALL;
                else if(FOGMAP[this.getX()+1][this.getY()])
                    return FOG;
                else if(EXIT.getX()==this.getX()+1 && EXIT.getY()==this.getY())
                    return EXIT;
                else {
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
                    return PATH;
                }
        }
        return PATH;
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
}
