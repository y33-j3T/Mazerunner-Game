package gamepack;

import entities.*;
import java.util.ArrayList;
import maze.MazeGenerator;

import java.util.Random;

public class Game  {
    public Game(){
        MAPWIDTH = WIDTH*2+1;
        MAPHEIGHT = HEIGHT*2+1;
        
        MAP = new String[MAPWIDTH][MAPHEIGHT];
        
        FOGMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        VERTICALWALLMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        HORIZONTALWALLMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        PATHMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        
        LOSTITEMMAP = new ArrayList<>();
        HPREGENMAP = new ArrayList<>();
        GOLDMAP = new ArrayList<>();
        BULLETMAP = new ArrayList<>();
        ZOMBIEMAP = new ArrayList<>();
        
        
        MazeGenerator MAZE = new MazeGenerator();     
        initializeEntity();  
        refresh();
    }
    
    public static int WIDTH;
    public static int HEIGHT;
    public static int MAPWIDTH;
    public static int MAPHEIGHT;
    
    public static String[][] MAP = new String[MAPWIDTH][MAPHEIGHT];
    
    public static Player JOHNNY = new Player();
    public static Item EXIT = new Item (" E ", 0, 0);
    public static Item HORIZONTALWALL = new Item("---", 0, 0);
    public static Item VERTICALWALL = new Item(" | ", 0, 0);
    public static Item PATH = new Item("   ", 0, 0);
    public static Item BULLET = new Item(" * ", 0, 0);
    public static Item HPREGEN = new Item (" + ", 0, 0);
    public static Item LOSTITEM = new Item(" @ ", 0, 0);
    public static Item GOLD = new Item(" $ ", 0, 0);
    public static Item FOG = new Item(" # ", 0, 0);
    public static Mob ZOMBIE = new Mob(" Z ", 0, 0);
    
    public static boolean[][] FOGMAP;
    public static boolean[][] VERTICALWALLMAP;
    public static boolean[][] HORIZONTALWALLMAP;
    public static boolean[][] PATHMAP;

    public static ArrayList<Item> HPREGENMAP;
    public static ArrayList<Item> LOSTITEMMAP;
    public static ArrayList<Item> GOLDMAP;
    public static ArrayList<Bullet> BULLETMAP;
    public static ArrayList<Mob> ZOMBIEMAP;
    
    public void refresh(){
        refreshFOGMAP();
        refreshMAP();
    }
    public void refreshFOGMAP(){
        for(int i=0 ; i<MAPHEIGHT ; i++){
            for(int j=0 ; j<MAPWIDTH ; j++){
                FOGMAP[j][i]=true;
            }
        }
        try {
            FOGMAP[JOHNNY.getX()][JOHNNY.getY()]=false;
            for(int i=1 ; i<=JOHNNY.getUpVisionRange() ; i++){
                FOGMAP[JOHNNY.getX()-1][JOHNNY.getY()-i]=false;
                FOGMAP[JOHNNY.getX()][JOHNNY.getY()-i]=false;
                FOGMAP[JOHNNY.getX()+1][JOHNNY.getY()-i]=false;
            }
            for(int i=1 ; i<=JOHNNY.getDownVisionRange() ; i++){
                FOGMAP[JOHNNY.getX()-1][JOHNNY.getY()+i]=false;
                FOGMAP[JOHNNY.getX()][JOHNNY.getY()+i]=false;
                FOGMAP[JOHNNY.getX()+1][JOHNNY.getY()+i]=false;
            }
            for(int i=1; i<=JOHNNY.getLeftVisionRange() ; i++){
                FOGMAP[JOHNNY.getX()-i][JOHNNY.getY()] = false;
                FOGMAP[JOHNNY.getX()-i][JOHNNY.getY()-1] = false;
                FOGMAP[JOHNNY.getX()-i][JOHNNY.getY()+1] = false;
            }
            for(int i=1; i<=JOHNNY.getRightVisionRange() ; i++){
                FOGMAP[JOHNNY.getX()+i][JOHNNY.getY()] = false;
                FOGMAP[JOHNNY.getX()+i][JOHNNY.getY()-1] = false;
                FOGMAP[JOHNNY.getX()+i][JOHNNY.getY()+1] = false;
            }
        } catch (ArrayIndexOutOfBoundsException e){
            
        }
    }
    public void refreshMAP(){
            for(int i=0 ; i<MAPHEIGHT ; i++){
                for(int j=0 ; j<MAPWIDTH ; j++){
                    try{
                        if(FOGMAP[j][i]==true)
                            MAP[j][i]=" # ";
                        else if(EXIT.getX()==j && EXIT.getY()==i)
                            MAP[j][i]=EXIT.getIcon();
                        else if(VERTICALWALLMAP[j][i])
                            MAP[j][i]=" | ";
                        else if(HORIZONTALWALLMAP[j][i])
                            MAP[j][i]="---";
                        else if(PATHMAP[j][i]){
                            if(JOHNNY.getX()==j && JOHNNY.getY()==i)                                         
                                MAP[j][i]=JOHNNY.getIcon();
                            else {
                                // must be arranged from Icon to be put at layers from back to front
                                MAP[j][i]="   ";

                                for(int k=0 ; k<LOSTITEMMAP.size() ; k++){
                                    if(LOSTITEMMAP.get(k).getX()==j && LOSTITEMMAP.get(k).getY()==i)                                   
                                        MAP[j][i]=LOSTITEMMAP.get(k).getIcon(); 
                                }
                                for(int k=0 ; k<HPREGENMAP.size() ; k++){
                                    if(HPREGENMAP.get(k).getX()==j && HPREGENMAP.get(k).getY()==i)                                   
                                        MAP[j][i]=HPREGENMAP.get(k).getIcon(); 
                                }
                                for(int k=0 ; k<GOLDMAP.size() ; k++){
                                    if(GOLDMAP.get(k).getX()==j && GOLDMAP.get(k).getY()==i)                                   
                                        MAP[j][i]=GOLDMAP.get(k).getIcon(); 
                                }
                                for(int k=0 ; k<BULLETMAP.size() ; k++){
                                    if(BULLETMAP.get(k).getX()==j && BULLETMAP.get(k).getY()==i)                                   
                                        MAP[j][i]=BULLETMAP.get(k).getIcon(); 
                                }
                                for(int k=0 ; k<ZOMBIEMAP.size() ; k++){
                                    if(ZOMBIEMAP.get(k).getX()==j && ZOMBIEMAP.get(k).getY()==i)                                   
                                        MAP[j][i]=ZOMBIEMAP.get(k).getIcon(); 
                                }
                            }
                        }
                    } catch (NullPointerException e){
                        MAP[j][i]="   ";
                    }   
                }
            }
            
    }
        
    public static void randomAllocateEntity(Entity entity){
        Random r = new Random();
        int a, b;
        boolean canAllocate = true;
        
        do{
            do{
                a = r.nextInt(MAPWIDTH-1)+1;
                b = r.nextInt(MAPHEIGHT-1)+1;
            } while (!PATHMAP[a][b]);

            if(a==JOHNNY.getX() && b==JOHNNY.getY()){
                canAllocate = false;
            } else {
                if(canAllocate){
                    for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                        if(a==ZOMBIEMAP.get(i).getX() && b==ZOMBIEMAP.get(i).getY()){
                            canAllocate = false;
                            break;
                        }
                    }
                }
                if(canAllocate){
                    for(int i=0 ; i<HPREGENMAP.size() ; i++){
                        if(a==HPREGENMAP.get(i).getX() && b==HPREGENMAP.get(i).getY()){
                            canAllocate = false;
                            break;
                        }
                    }
                }
                if(canAllocate){
                    for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                        if(a==LOSTITEMMAP.get(i).getX() && b==LOSTITEMMAP.get(i).getY()){
                            canAllocate = false;
                            break;
                        }
                    }
                }
                if(canAllocate){
                    for(int i=0 ; i<GOLDMAP.size() ; i++){
                        if(a==GOLDMAP.get(i).getX() && b==GOLDMAP.get(i).getY()){
                            canAllocate = false;
                            break;
                        }
                    }
                }
            }

            if(canAllocate){
                if(entity == ZOMBIE){
                    Mob zombie = new Mob(" Z ", a, b);
                    ZOMBIEMAP.add(zombie);
                }
                else if(entity == HPREGEN){
                    Item hpregen = new Item(" + ", a, b);
                    HPREGENMAP.add(hpregen);
                }
                else if(entity == LOSTITEM){
                    Item lostitem = new Item(" @ ", a, b);
                    LOSTITEMMAP.add(lostitem);
                }
                else if(entity == GOLD){
                    Item gold = new Item(" $ ", a, b);
                    GOLDMAP.add(gold);
                }
            }
        } while (canAllocate==false);
    }
    
    public static void initializeEntity() {
        Random r = new Random();
        int a, b, totalEntity, mapArea;
        ArrayList<Entity> posAdded = new ArrayList<>();
        
        mapArea = MAPWIDTH*MAPHEIGHT;
        totalEntity = (mapArea*2)/15+1;
        
        while(posAdded.size() < totalEntity){
            boolean canAdd = true;
            // check if it's a PATH
            do{
                a = r.nextInt(MAPWIDTH-1)+1;
                b = r.nextInt(MAPHEIGHT-1)+1;
            } while (!PATHMAP[a][b]);
            
            // check if other ENTITY exists on PATH
            for(int i=0 ; i<posAdded.size() ; i++){
                if(posAdded.get(i).getX()==a && posAdded.get(i).getY()==b){
                    break;
                } 
            }
            
            if(canAdd){
                Entity toAdd = new Entity();
                toAdd.setPosition(a, b);
                posAdded.add(toAdd);
            }            
        }
        
        JOHNNY.setPosition(posAdded.get(0).getX(), posAdded.get(0).getY());
        JOHNNY.setSpawn(posAdded.get(0).getX(), posAdded.get(0).getY());
        
        for(int i=1 ; i<=mapArea/30 ; i++){
            Mob zombie = new Mob(" Z ", 0, 0);
            zombie.setPosition(posAdded.get(i).getX(), posAdded.get(i).getY());
            ZOMBIEMAP.add(zombie);
        }
        
        for(int i=mapArea/30+1 ; i<=mapArea/15 ; i++){
            Item hpregen = new Item(" + ", 0, 0);
            hpregen.setPosition(posAdded.get(i).getX(), posAdded.get(i).getY());
            HPREGENMAP.add((Item) hpregen);
        }
        
        for(int i=mapArea/15+1 ; i<=mapArea/12 ; i++){
            Item lostitem = new Item(" @ ", 0, 0);
            lostitem.setPosition(posAdded.get(i).getX(), posAdded.get(i).getY());
            LOSTITEMMAP.add((Item) lostitem);
            JOHNNY.setLOSTITEM_totalAmount((mapArea/12)-(mapArea/15+1));
        }
        
        for(int i=mapArea/12+1 ; i<=mapArea*2/15 ; i++){
            Item gold = new Item(" $ ", 0, 0);
            gold.setPosition(posAdded.get(i).getX(), posAdded.get(i).getY());
            GOLDMAP.add((Item) gold);
        }
    }
    
    public String toString(){
        String strMAP = "";
        for(int i=0 ; i<MAPHEIGHT ; i++){
            for(int j=0 ; j<MAPWIDTH ; j++){
                strMAP = strMAP.concat(MAP[j][i]);
            }
            strMAP = strMAP.concat("\n");
        }
        return strMAP;
    }
}
