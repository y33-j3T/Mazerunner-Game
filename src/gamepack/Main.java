package gamepack;

import static gamepack.Game.MAP;
import static gamepack.Game.MAPHEIGHT;
import static gamepack.Game.MAPWIDTH;

public class Main {
    
    public static void main(String[] args) {
        mazeDimensionDialog getInputGUI = new mazeDimensionDialog();
        getInputGUI.start();
        
        for(int i=0 ; i<MAPHEIGHT ; i++){
            for(int j=0 ; j<MAPWIDTH ; j++){
                System.out.println(MAP[j][i]);
            }
            System.out.println();
        }
    }
}
