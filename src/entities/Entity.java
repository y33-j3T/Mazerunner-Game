package entities;

import static gamepack.Game.*;
import java.util.ArrayList;

public class Entity {
    
    protected int x, y;
    protected String ICON;

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public String getIcon(){
        return ICON;
    }
    public ArrayList<Mob>getZOMBIEMAP(){
        return ZOMBIEMAP;
    }
    public ArrayList<Item>getLOSTITEMMAP(){
            return LOSTITEMMAP;
    }
    public ArrayList<Item>getHPREGENMAP(){
            return LOSTITEMMAP;
    }
    public ArrayList<Item>getGOLDMAP(){
            return GOLDMAP;
    }
//    public boolean[][] getOwnFinalMap(){
//        if(this == VERTICALWALL)
//            return VERTICALWALLMAP;
//        else if(this == HORIZONTALWALL)
//            return HORIZONTALWALLMAP;
//        else if(this == PATH)
//            return PATHMAP;
//        else if(this == FOG)
//            return FOGMAP;
//        return null;
//    }
    
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
}