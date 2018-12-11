package gamepack;

import static gamepack.Game.MAP;
import static gamepack.Game.MAPHEIGHT;
import static gamepack.Game.MAPWIDTH;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Main extends JFrame implements KeyListener {
    public static void main(String[] args) {
       Game Mazerunner = new Game();
       
       KeyListener PlayerInput = new KeyListener
        
    }
    
 
    
    @Override
    public void paint(Graphics g){
        int fontSize = 20;
        g.setFont(new Font("Monospaced", Font.PLAIN, fontSize));
        g.setColor(Color.black);
        
        for(int i=0 ; i<MAPHEIGHT ; i++){                                       
            for(int j=0 ; j<MAPWIDTH ; j++){
                g.drawString(MAP[j][i][1], j*20, i*20+20);
            }
            System.out.println();
        }
    }
	
    private void showFrame(){
        JFrame frame = new JFrame("Mazerunner");
        frame.getContentPane().add(new Main());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    
    private static void attach_MAP_to_FRAME(){                                  // shows game on JFrame
        for(int i=0 ; i<MAPHEIGHT ; i++){                                       // not done yet, print on console first
            for(int j=0 ; j<MAPWIDTH ; j++){
                System.out.print(MAP[j][i][1]);
            }
            System.out.println();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP)
        if(e.getKeyCode()==KeyEvent.VK_DOWN)
        if(e.getKeyCode()==KeyEvent.VK_LEFT)
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            Game.BULLET.autoRun(e);
            repaint();        
        }
        
        if(e.getKeyCode()==KeyEvent.VK_W)
        if(e.getKeyCode()==KeyEvent.VK_A)
        if(e.getKeyCode()==KeyEvent.VK_S)
        if(e.getKeyCode()==KeyEvent.VK_D){
            Game.JOHNNY.executeCollisionAction(e);
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
