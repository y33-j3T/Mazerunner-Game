package gamepack;

import entities.*;
import maze.MazeGenerator;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game  {
    public Game(){
        WIDTH = getDimension(0);
        HEIGHT = getDimension(1);
        MAPWIDTH = WIDTH*2+1;
        MAPHEIGHT = HEIGHT*2+1;
        
        MAP = new String[MAPWIDTH][MAPHEIGHT][2];
        
        JOHNNYMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        ZOMBIEMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        VERTICALWALLMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        HORIZONTALWALLMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        PATHMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        LOSTITEMMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        HPREGENMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        GOLDMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        BULLETMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        EXITMAP = new boolean[MAPWIDTH][MAPHEIGHT];
    
        FOGMAP = new boolean[MAPWIDTH][MAPHEIGHT];
        
        MazeGenerator MAZE = new MazeGenerator();                               
        initializeEntity();                                                     
        refresh();
    }
    
    public static int WIDTH;
    public static int HEIGHT;
    public static int MAPWIDTH;
    public static int MAPHEIGHT;
    public static int spawnX;
    public static int spawnY;
    
    public static String[][][] MAP = new String[MAPWIDTH][MAPHEIGHT][2];
    
    public static Player JOHNNY = new Player();
    public static Mob ZOMBIE = new Mob(" Z ");
    public static Item VERTICALWALL = new Item(" | ");
    public static Item HORIZONTALWALL = new Item("---");
    public static Item PATH = new Item("   ");
    public static Item LOSTITEM = new Item(" @ ");
    public static Item HPREGEN = new Item(" + ");  
    public static Item GOLD = new Item(" $ ");
    public static Item BULLET = new Item(" * ");
    public static Item FOG = new Item(" # ");
    public static Item EXIT = new Item(" E ");
    
    public static boolean[][] JOHNNYMAP;
    public static boolean[][] ZOMBIEMAP;
    public static boolean[][] VERTICALWALLMAP;
    public static boolean[][] HORIZONTALWALLMAP;
    public static boolean[][] BULLETMAP;
    public static boolean[][] PATHMAP;
    public static boolean[][] LOSTITEMMAP;
    public static boolean[][] HPREGENMAP;
    public static boolean[][] GOLDMAP;
    public static boolean[][] EXITMAP;
    public static boolean[][] FOGMAP;
    
    public static int LOSTITEM_amount=0;
    public static int LOSTITEM_totalAmount=0;    
    public static int GOLD_amount=0;
    
    public static int getDimension(int a){                                      // get user input for maze dimension
        String str;
        if(a==0)
            str = "Width";
        else 
            str = "Height";
        
        int dimension;
        while(true){
            try{
                Scanner s = new Scanner(System.in);
                
                do{
                    System.out.print(str + " of maze (min 20, max 100): ");
                    dimension = s.nextInt();
                    
                    if(dimension<20){
                        System.out.println("Input is too small. Try again.\n");
                    }
                    else if(dimension>100){
                        System.out.println("Input is too big. Try again\n");
                    }
                } while (dimension<20 || dimension>100);
                
                return dimension;
                
            } catch (InputMismatchException e){
                System.out.println("Input is not an integer. Try again.\n");
            }
        }
    }
        
    public static void refresh(){
        refreshFOGMAP();
        refreshMAP();
    }
    public static void refreshFOGMAP(){
        for(int i=0 ; i<MAPHEIGHT ; i++){
            for(int j=0 ; j<MAPWIDTH ; j++){
                FOGMAP[j][i]=true;
            }
        }
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
    }
    public static void refreshMAP(){
        for(int i=0 ; i<MAPHEIGHT ; i++){
            for(int j=0 ; j<MAPWIDTH ; j++){
                if(FOGMAP[j][i]==true)
                    MAP[j][i][1]=FOG.getIcon();
                else if(EXITMAP[j][i])
                        MAP[j][i][1]=EXIT.getIcon();
                else if(VERTICALWALLMAP[j][i])
                        MAP[j][i][1]=VERTICALWALL.getIcon();
                else if(HORIZONTALWALLMAP[j][i])
                    MAP[j][i][1]=HORIZONTALWALL.getIcon();
                else if(EXITMAP[j][i])
                    MAP[j][i][1]=EXIT.getIcon();
                else if(PATHMAP[j][i]){
                    if(JOHNNYMAP[j][i])                                         //JOHNNYMAP 
                        MAP[j][i][1]=JOHNNY.getIcon();                          //                  NO                    
                    else if(ZOMBIEMAP[j][i])                                    //ZOMBIEMAP
                        MAP[j][i][1]=ZOMBIE.getIcon();                          //                  OVERLAPPING
                    else if(BULLETMAP[j][i])                                    //BULLETMAP
                        MAP[j][i][1]=BULLET.getIcon();                          //
                    else if(LOSTITEMMAP[j][i])
                        MAP[j][i][1]=LOSTITEM.getIcon();
                    else if(HPREGENMAP[j][i])
                        MAP[j][i][1]=HPREGEN.getIcon();
                    else if(GOLDMAP[j][i])
                        MAP[j][i][1]=GOLD.getIcon();
                    else
                        MAP[j][i][1]=PATH.getIcon();
                }
            }
        }
    }
        
    public static void initializeEntity(){
        randomAllocateEntity(JOHNNY);
        for(int i=0 ; i<MAPWIDTH*MAPHEIGHT/30 ; i++){
            randomAllocateEntity(ZOMBIE);
            randomAllocateEntity(HPREGEN);
        }
        for(int i=0 ; i<MAPWIDTH*MAPHEIGHT/60 ; i++){
            randomAllocateEntity(LOSTITEM);
        }
        for(int i=0 ; i<MAPWIDTH*MAPHEIGHT/20 ; i++){
            randomAllocateEntity(GOLD);
        }
    }
    public static void randomAllocateEntity(Entity entity){
        Random r = new Random();
        int a, b;
        do{
            a = r.nextInt(MAPWIDTH-1)+1;
            b = r.nextInt(MAPHEIGHT-1)+1;
        } while (!PATHMAP[a][b] || JOHNNYMAP[a][b] || ZOMBIEMAP[a][b] || LOSTITEMMAP[a][b] || HPREGENMAP[a][b] || GOLDMAP[a][b]);
        entity.setPosition(a, b);
        
        if(entity == JOHNNY){
            JOHNNYMAP[a][b]=true;
            spawnX = a;
            spawnY = b;
        }
        else if(entity == ZOMBIE){
            ZOMBIEMAP[a][b]=true;
        }
        else if(entity == LOSTITEM){
            LOSTITEMMAP[a][b]=true;
            LOSTITEM_totalAmount+=1;
        }
        else if(entity == HPREGEN){
            HPREGENMAP[a][b]=true;
        }
        else if(entity == GOLD){
            GOLDMAP[a][b]=true;
        }
    }    
    
    Thread thread_zombie = new Thread((Runnable) ZOMBIE);
}
