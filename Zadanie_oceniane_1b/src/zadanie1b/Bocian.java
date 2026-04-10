package zadanie1b;

public class Bocian extends Szybowiec {

    public Bocian(Teren teren, int y, int x, double wysokosc) {
        super(teren, y, x, wysokosc);
    }

    @Override
    public void glide() {
        super.glide();
        if (this.wysokosc == 0){
            System.out.println("Bocian wylądował");
        }
    }

    @Override
    public String toString() {
        return "Bocian{" +
                "wysokosc=" + wysokosc +
                '}';
    }
}
