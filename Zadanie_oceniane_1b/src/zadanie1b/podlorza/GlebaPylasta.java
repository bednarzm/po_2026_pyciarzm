package zadanie1b.podlorza;

public class GlebaPylasta extends Gleba {
    private boolean uzytekRolny;

    public GlebaPylasta() {
        this.temperatura = random.nextInt(0, 36);
        this.gestosc = 1.2 + random.nextDouble()*0.4;
        this.uzytekRolny = random.nextBoolean();
    }

    @Override
    public double getUpCurrent() {
        return 0.62*this.temperatura/7;
    }
}
