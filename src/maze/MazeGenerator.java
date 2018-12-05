package maze;

import static gamepack.Game.HEIGHT;
import static gamepack.Game.HORIZONTALWALLMAP;
import static gamepack.Game.PATHMAP;
import static gamepack.Game.VERTICALWALLMAP;
import static gamepack.Game.WIDTH;

import java.util.Arrays;
import java.util.Collections;
 
public final class MazeGenerator {
    
    private int[][] maze;
    
    public MazeGenerator(){
        makeMaze(WIDTH, HEIGHT);
        assignMazeToMAP();
    }
    
    public void assignMazeToMAP() {                                             // store generated maze into MAP array
        for (int i=0; i<HEIGHT; i++) {
            
            for (int j=0; j<WIDTH; j++) {                                       // draw the north edge
                if((maze[j][i] & 1) == 0){                                      // " | ---"
                    VERTICALWALLMAP[j*2][i*2] = true;
                    HORIZONTALWALLMAP[j*2+1][i*2] = true;
                } else {                                                        // " |    "
                    VERTICALWALLMAP[j*2][i*2] = true;
                    PATHMAP[j*2+1][i*2] = true;
                }
            }
            VERTICALWALLMAP[(WIDTH-1)*2+1+1][i*2] = true;                       // " | "

            for (int j=0; j<WIDTH; j++) {                                       // draw the west edge
                if((maze[j][i] & 8) == 0){                                      // " |    "
                    VERTICALWALLMAP[j*2][i*2+1] = true;                         
                    PATHMAP[j*2+1][i*2+1] = true;
                } else {                                                        // "      "
                    PATHMAP[j*2][i*2+1] = true;
                    PATHMAP[j*2+1][i*2+1] = true;
                }
            }
            VERTICALWALLMAP[(WIDTH-1)*2+1+1][i*2+1] = true;                     // " | "
        }
       
        for (int j = 0; j < WIDTH; j++) {                                       // draw the bottom line
                VERTICALWALLMAP[j*2][(HEIGHT-1)*2+1+1] = true;                  // " | ---"
                HORIZONTALWALLMAP[j*2+1][(HEIGHT-1)*2+1+1] = true;
        }
        VERTICALWALLMAP[(WIDTH-1)*2+1+1][(HEIGHT-1)*2+1+1]= true;               // " | "
    }
    
    public void makeMaze(int WIDTH, int HEIGHT) {                                // initialize WIDTH and HEIGHT to generate maze path
        maze = new int[WIDTH][HEIGHT];
        generateMazePath(0, 0);
    }                  
    
    private void generateMazePath(int cWIDTH, int cHEIGHT) {                     // generate maze path algo
        DIR[] dirs = DIR.values();
        Collections.shuffle(Arrays.asList(dirs));
        for (DIR dir : dirs) {
            int nWIDTH = cWIDTH + dir.dWIDTH;
            int nHEIGHT = cHEIGHT + dir.dHEIGHT;
            if (between(nWIDTH, WIDTH) && between(nHEIGHT, HEIGHT) && (maze[nWIDTH][nHEIGHT] == 0)) {
                maze[cWIDTH][cHEIGHT] |= dir.bit;
                maze[nWIDTH][nHEIGHT] |= dir.opposite.bit;
                generateMazePath(nWIDTH, nHEIGHT);
            }
        }
    }      

    private static boolean between(int v, int upper) {                           // part of generateMazePath()
        return (v >= 0) && (v < upper);
    }             

    private enum DIR {                                                           // part of generateMazePath()
        N(1, 0, -1), S(2, 0, 1), E(4, 1, 0), W(8, -1, 0);
        private final int bit;
        private final int dWIDTH;
        private final int dHEIGHT;
        private DIR opposite;

        // use the static initializer to resolve forward references
        static {
            N.opposite = S;
            S.opposite = N;
            E.opposite = W;
            W.opposite = E;
        }

        private DIR(int bit, int dWIDTH, int dHEIGHT) {
            this.bit = bit;
            this.dWIDTH = dWIDTH;
            this.dHEIGHT = dHEIGHT;
        }
    };                                            
}