public class Corpo {
    private int px;
    private int vx;
    private int py;
    private int vy;

    public Corpo(int px, int py, int vx, int vy) {
        this.px = px;
        this.py = py;
        this.vx = vx;
        this.vy = vy;
    }

    public void setPx(int px) {
        this.px = px;
    }

    public void setPy(int py) {
        this.py = py;
    }

    public void setVx(int vx) {
        this.vx = vx;
    }

    public void setVy(int vy) {
        this.vy = vy;
    }

    public int getPx() {
        return px;
    }
    public int getPy() {
        return py;
    }
    public int getVx() {
        return vx;
    }
    public int getVy() {
        return vy;
    }

    public Corpo copiar() {
        return new Corpo(px, py, vx, vy);
    }

}
