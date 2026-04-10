package zadanie1b.podlorza;

public class GlebaKamienista extends Gleba {
    private static double gestoscMin = 1.5;

    public GlebaKamienista() {
        this.temperatura = random.nextInt(0, 36);
        this.gestosc = 1.5 + random.nextDouble()*2;
    }

    @Override
    public double getUpCurrent() {
        return 0.67*this.temperatura/7;
    }
}
