package zadanie1b;

public class Junior extends Szybowiec {

    public Junior(Teren teren, int y, int x, double wysokosc) {
        super(teren, y, x, wysokosc);
    }

    @Override
    public void glide() {
        super.glide();
        if (this.wysokosc == 0){
            System.out.println("Junior dał w pole");
        }
    }

    @Override
    public String toString() {
        return "Junior{" +
                "wysokosc=" + wysokosc +
                '}';
    }
}
