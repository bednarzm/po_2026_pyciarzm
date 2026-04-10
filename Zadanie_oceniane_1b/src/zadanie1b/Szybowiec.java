package zadanie1b;
import java.util.Random;

public abstract class Szybowiec {
    private int count;
    private int x;
    private int y;
    private Teren teren;
    protected double wysokosc;
    private Random random = new Random();

    public Szybowiec(Teren teren, int y, int x, double wysokosc) {
        this.count = 0;
        this.teren = teren;
        this.y = y;
        this.x = x;
        this.wysokosc = wysokosc;
    }


    public void glide(){
        if (!teren.isInside(x, y))
            return;

        this.count++;

        if (random.nextDouble() < 0.6){
            x += 1;
        }

        if (this.count % 3 == 0) {
            y += random.nextInt(0, 4);
        }

        if (!teren.isInside(x, y))
            return;

        if (this.wysokosc > 0){
            double upCurrent = teren.getPole(x,y).getUpCurrent();
            this.wysokosc += upCurrent;
            if (this.wysokosc < 0){
                this.wysokosc = 0;
            }
            if (this.wysokosc == 0){
                System.out.println("Ooops, lądowanie w polu!");
            }
        }



    }

}
