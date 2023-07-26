import java.awt.*;
import java.awt.geom.*;
import java.util.Random;

public class Maca {
    private Random rg = new Random();
    private int px;
    private int py;


    public Maca() {
        py = rg.nextInt(600/15 - 2) * 15;
        px = rg.nextInt(600/15 - 3) * 15;
    }

    public void setPx(int px) {
        this.px = px;
    }
    public void setPy(int py) {
        this.py = py;
    }

    public int getPx() {
        return px;
    }
    public int getPy() {
        return py;
    }

    public void DesenharMaca(Graphics2D g2d) {
        Rectangle2D.Double r = new Rectangle2D.Double(px, py, 15, 15);
        g2d.setColor(new Color(204, 0, 0));
        g2d.fill(r);
    }

    public void attMaca() {
        px = rg.nextInt(600/15 -2) * 15;
        py = rg.nextInt(600/15 -3) * 15;
    }


}
