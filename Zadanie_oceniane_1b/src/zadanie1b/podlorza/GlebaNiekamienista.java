package zadanie1b.podlorza;

public class GlebaNiekamienista extends Gleba {
    public GlebaNiekamienista() {
        this.temperatura = random.nextInt(0, 36);
        this.gestosc = 1 + random.nextDouble()*0.4;
    }

    @Override
    public double getUpCurrent() {
        return 0.67*this.temperatura/7;
    }
}
