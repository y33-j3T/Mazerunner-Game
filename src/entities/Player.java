package entities;

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
import gamepack.areYouSureDialog;
import gamepack.gameFrame;
import static gamepack.gameFrame.goldProgressBar;
import static gamepack.gameFrame.hpProgressBar;
import static gamepack.gameFrame.livesProgressBar;
import static gamepack.gameFrame.lostItemProgressBar;
import gamepack.loseDialog;
import gamepack.upgradeDialog;
import gamepack.winDialog;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player extends Entity{
    private int LIVES = 3;
    private int LOSTITEM_amount=0;
    private int LOSTITEM_totalAmount=0;    
    private int GOLD_amount=0;
    private int spawnX, spawnY;
    protected int HP;
    protected int TOTALHP;
    protected int ATTACKDAMAGE;
    protected int ARMOR;
    protected int VISION;

    public Player(){
        ICON = " J ";
        HP = 100;
        TOTALHP = 100;
        ATTACKDAMAGE = 5;
        ARMOR = 2;
        VISION = 2;
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
    public int getSpawnX(){
        return spawnX;
    }
    public int getSpawnY(){
        return spawnY;
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
    
    public void setSpawn(int x, int y){
        this.spawnX = x;
        this.spawnY = y;
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
//        System.out.println("check col " + this.getCollidedBlock(input).getIcon());
        if(this.getCollidedBlock(input)==ZOMBIE){
            this.setHP(this.getHP()-ZOMBIE.getATTACKDAMAGE()+this.getARMOR());
            hpProgressBar.setValue(JOHNNY.getHP());
            if(this.getHP()<=0){
                if(LIVES>0){
                    LIVES--;
                    livesProgressBar.setValue(JOHNNY.getLives());
                    this.setHP(this.getTOTALHP());
                    hpProgressBar.setValue(JOHNNY.getHP());
                    this.setPosition(spawnX, spawnY);
                } else {
                    loseDialog lose = new loseDialog();
                    lose.start();
                    try {
                        wait();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else if(this.getCollidedBlock(input)==EXIT){
            if(LOSTITEM_amount<LOSTITEM_totalAmount){
                try {
                    areYouSureDialog areYouSure = new areYouSureDialog();
                    areYouSure.start();
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                winDialog win = new winDialog();
                win.start();
            }
        }
        else if(this.getCollidedBlock(input)==LOSTITEM){
            this.move(input);
            LOSTITEM_amount+=1;
            lostItemProgressBar.setValue(JOHNNY.getLostItemAmount());
            for(int i=0 ; i<LOSTITEMMAP.size() ; i++){
                if(LOSTITEMMAP.get(i).getX()==this.getX() && LOSTITEMMAP.get(i).getY()==this.getY())
                    LOSTITEMMAP.remove(i);
            }
        }
        else if(this.getCollidedBlock(input)==HPREGEN){
            this.move(input);
            if(this.TOTALHP-this.getHP()<5){
                this.setHP(this.TOTALHP);
                hpProgressBar.setValue(JOHNNY.getHP());
            }
            else {
                this.setHP(this.getHP()+5);
                hpProgressBar.setValue(JOHNNY.getHP());
            }
            for(int i=0 ; i<HPREGENMAP.size() ; i++){
                if(HPREGENMAP.get(i).getX()==this.getX() && HPREGENMAP.get(i).getY()==this.getY())
                    HPREGENMAP.remove(i);
            }
        }
        else if(this.getCollidedBlock(input)==GOLD){
            this.move(input);
            GOLD_amount+=5;
            goldProgressBar.setValue(JOHNNY.getGoldAmount());
            for(int i=0 ; i<GOLDMAP.size() ; i++){
                if(GOLDMAP.get(i).getX()==this.getX() && GOLDMAP.get(i).getY()==this.getY())
                    GOLDMAP.remove(i);
            }
            
            if(JOHNNY.getGoldAmount()==40){
                upgradeDialog dialog = new upgradeDialog();
                dialog.start();
            }
        }
        else if(this.getCollidedBlock(input)==VERTICALWALL || this.getCollidedBlock(input)==HORIZONTALWALL){
            // do nothing
        } else {
            this.move(input);
        }
    }
    public Entity getCollidedBlock(KeyEvent input){
        switch (input.getKeyCode()) {
            case KeyEvent.VK_W:
                if(VERTICALWALLMAP[this.getX()][this.getY()-1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()-1])
                    return HORIZONTALWALL;
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
                
            case KeyEvent.VK_S:
                if(VERTICALWALLMAP[this.getX()][this.getY()+1])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()][this.getY()+1])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX() && EXIT.getY()==this.getY()+1)
                    return EXIT;
                else{
                    for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                        if(this.getX()==ZOMBIEMAP.get(i).getX() && this.getY()+1==ZOMBIEMAP.get(i).getY()){
                            return ZOMBIE;
                        }
                    }
                    for(int i=0 ; i<BULLETMAP.size() ; i++){
                        if(this.getX()==BULLETMAP.get(i).getX() && this.getY()+1==BULLETMAP.get(i).getY())                                   
                            return BULLET;
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
                    return PATH;
                }
                
            case KeyEvent.VK_A:
                if(VERTICALWALLMAP[this.getX()-1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()-1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX()-1 && EXIT.getY()==this.getY())
                    return EXIT;
                else{
                    for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                        if(this.getX()-1==ZOMBIEMAP.get(i).getX() && this.getY()==ZOMBIEMAP.get(i).getY()){
                            return ZOMBIE;
                        }
                    }
                    for(int i=0 ; i<BULLETMAP.size() ; i++){
                        if(this.getX()-1==BULLETMAP.get(i).getX() && this.getY()==BULLETMAP.get(i).getY())                                   
                            return BULLET;
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
                    return PATH;
                }
                
            case KeyEvent.VK_D:
                if(VERTICALWALLMAP[this.getX()+1][this.getY()])
                    return VERTICALWALL;
                else if(HORIZONTALWALLMAP[this.getX()+1][this.getY()])
                    return HORIZONTALWALL;
                else if(EXIT.getX()==this.getX()+1 && EXIT.getY()==this.getY())
                    return EXIT;
                else{
                    for(int i=0 ; i<ZOMBIEMAP.size() ; i++){
                        if(this.getX()+1==ZOMBIEMAP.get(i).getX() && this.getY()==ZOMBIEMAP.get(i).getY()){
                            return ZOMBIE;
                        }
                    }
                    for(int i=0 ; i<BULLETMAP.size() ; i++){
                        if(this.getX()+1==BULLETMAP.get(i).getX() && this.getY()==BULLETMAP.get(i).getY())                                   
                            return BULLET;
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
                    return PATH;
                }
        }
        return PATH;
    }
    public void move(KeyEvent input){
        switch (input.getKeyCode()){
            case KeyEvent.VK_W:
                this.setY(this.getY()-1);
//                System.out.println("moveW");
                break;
            case KeyEvent.VK_S:
                this.setY(this.getY()+1);
//                System.out.println("moveS");
                break;
            case KeyEvent.VK_A:
                this.setX(this.getX()-1);
//                System.out.println("moveA");
                break;
            case KeyEvent.VK_D:
                this.setX(this.getX()+1);
//                System.out.println("moveD");
                break;
        }
    }
}
