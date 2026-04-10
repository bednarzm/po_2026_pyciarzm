package zadanie1b.podlorza;

import java.util.Random;

public class Piasek extends Podlorze {
    private String sypkosc = new String();
    private String[] sypkosci = {"GRUBY", "DROBNY", "ŚREDNI", "PYŁ"};

    public Piasek() {
        this.temperatura = new Random().nextInt(0, 48);
        this.sypkosc = sypkosci[new Random().nextInt(sypkosci.length)];
    }

    @Override
    public double getUpCurrent() {
        return 0.22*this.temperatura*random.nextDouble();
    }
}
