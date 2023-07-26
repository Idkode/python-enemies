import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;
import javax.swing.*;


public class Jogo {

    final static int w = 600, h = 600;
    public static JFrame f = new JFrame();
    public static Canvas c = new Canvas(w, h);

    public static void main(String[] args) throws Exception {
        TimeUnit t = TimeUnit.MILLISECONDS;
        f.setSize(w, h);
        f.setTitle("Snake v0");
        f.add(c);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        while (true) {
            t.sleep(100);
            processKeys();
            c.attPos();
            if (c.cabeca().getPx() == c.xMaca() && c.cabeca().getPy() == c.yMaca()){
                c.attMaca();
                c.crescer();
            }
            c.repaint();
        }

    }

    public static void processKeys(){
        KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher( 
            new KeyEventDispatcher()  {  
                public boolean dispatchKeyEvent(KeyEvent e){
                    if(e.getID() == KeyEvent.KEY_PRESSED){
                        handleKeyPress(e.getKeyCode());
                    }
                    return false;
                }  
        });
    }
    
    private static void handleKeyPress(int keyCode) {
        switch (keyCode) {
        case 37://LEFT KEY
            if (c.cabeca().getVx() != 15){
                c.cabeca().setVx(-15);
                c.cabeca().setVy(0);
            }
            break;
        case 38://UP KEY
            if (c.cabeca().getVy() != 15){
                c.cabeca().setVx(0);
                c.cabeca().setVy(-15);
            }
            break;
        case 39://RIGHT KEY
            if (c.cabeca().getVx() != -15){
                c.cabeca().setVx(15);
                c.cabeca().setVy(0);
            }
            break;
        case 40://DOWN KEY
            if (c.cabeca().getVy() != -15){
                c.cabeca().setVx(0);
                c.cabeca().setVy(15);
            }
            break;
        }
    }
}
