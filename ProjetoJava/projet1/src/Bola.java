public class Bola {
    static int vida = 3;
    private int posx, posy;

    public static int getVida() {
        return vida;
    }

    public int getPosx() {
        return posx;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public int getPosy() {
        return posy;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }

    @Override
    public String toString() {
        return "Bola [posx=" + (posx + 1) + ", posy=" + (posy + 1) + "]";
    }

    public boolean acerta(int x, int y) {
        if (x == this.posx && y == this.posy) {
            return true;
        } else {
            return false;
        }
    }

    public Bola(int posX, int posY) {
        this.posx = posX;
        this.posy = posY;
    }
}
