package gamepack;

import static gamepack.Game.FOGMAP;
import static gamepack.Game.MAP;
import static gamepack.Game.MAPHEIGHT;
import static gamepack.Game.MAPWIDTH;
import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        Game Mazerunner = new Game();
        
//        while(true){
//            try{
//                cls();
                attach_MAP_to_FRAME(); 
//                Thread.sleep(1000);
//            } catch (InterruptedException e){
//                
//            }
//        }
        
//        showFrame();                                                            // put all stuff into frame and display

    }
    
        private void showFrame(){
        JFrame frame = new JFrame("Mazerunner");
//        frame.setContentPane(new Game());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setPreferredSize(new Dimension(MAPWIDTH, MAPHEIGHT));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
        
    public static void cls(){                                                   // clears the screen        
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    
    private static void attach_MAP_to_FRAME(){                                  // shows game on JFrame
        for(int i=0 ; i<MAPHEIGHT ; i++){                                       // not done yet, print on console first
            for(int j=0 ; j<MAPWIDTH ; j++){
                    System.out.print(MAP[j][i][1]);
            }
            System.out.println();
        }
    }
}
