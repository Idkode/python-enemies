import java.awt.*;
import java.awt.geom.*;
import java.util.LinkedList;

public class Cobra {

    private LinkedList<Corpo> corpo = new LinkedList<Corpo>();

    public Cobra(int x, int y) {
        corpo.addFirst(new Corpo(x, y, 0, 0));
    }

    public void DesenharCobra(Graphics2D g2d) {
        for (Corpo seg : corpo) {
            Rectangle2D.Double r = new Rectangle2D.Double(seg.getPx(), seg.getPy(), 15, 15);
            g2d.setColor(Color.BLACK);
            g2d.fill(r);
        }
    }

    public void attPos() {
        Corpo ant = corpo.peekFirst();
        Corpo aux;
        for (Corpo seg : corpo) {
            seg.setPx(seg.getPx() + seg.getVx()); // px = px + vx
            seg.setPy(seg.getPy() + seg.getVy()); // py = py + vy
            aux = seg.copiar(); // guarda as informações do segmento antes de atualizar a velocidade
            seg.setVx(ant.getVx()); // vx = velocidade x do segmento da frente
            seg.setVy(ant.getVy()); // vy = velocidade y do segmento da frente
            ant = aux;
        }
    }

    public Corpo cabeca() {
        return corpo.getFirst();
    }

    public void crescer() {
        Corpo ultimo = corpo.peekLast();
        int vx_n = ultimo.getPx() - ultimo.getVx();
        int vy_n = ultimo.getPy() - ultimo.getVy();
        corpo.addLast(new Corpo(vx_n, vy_n, ultimo.getVx(), ultimo.getVy()));
    }
    
}
