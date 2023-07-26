import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;


public class Canvas extends JComponent {

    private int width;
    private int height;
    private Cobra cobra;
    private Maca maca;


    public Canvas(int w, int h) {
        width = w;
        height = h;
        cobra = new Cobra(width/2, height/2);
        maca = new Maca();
    }

    public Corpo cabeca() {
        return cobra.cabeca();
    }
    public void attPos() {
        cobra.attPos();
    }
    public void crescer() {
        cobra.crescer();
    }

    public double xMaca() {
        return maca.getPx();
    }
    public double yMaca() {
        return maca.getPy();
    }

    public void attMaca() {
        maca.attMaca();
    }


    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

/*      RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_ANTIALIASING, 
            RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHints(rh);
*/
        g2d.setColor(new Color(156,123,83));
        g2d.fill(new Rectangle2D.Double(0, 0, width, height));

        maca.DesenharMaca(g2d);
        cobra.DesenharCobra(g2d);
    }
    
}
