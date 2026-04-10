package zadanie1b.podlorza;
import java.util.Random;

import static java.lang.Math.max;
import static java.lang.Math.min;

public abstract class Podlorze {
    protected int temperatura;
    protected Random random = new Random();

    public double getUpCurrent(){
        return 1;
    }

    public void modifyTemperature(int deltaT) {
        int maxTemperature = getMaxTemperature();
        if (deltaT < 0){
            deltaT = 0;
        }
        if (deltaT > maxTemperature){
            deltaT = maxTemperature;
        }

        temperatura += deltaT;

        if (temperatura > maxTemperature) {
            temperatura = maxTemperature;
        }
    }

    protected int getMaxTemperature() {
        if (this instanceof Piasek) {
            return 48;
        }
        if (this instanceof GlebaKamienista || this instanceof GlebaNiekamienista || this instanceof GlebaPylasta) {
            return 36;
        }
        if (this instanceof TerenWodny || this instanceof PodmoklaLaka) {
            return 24;
        }
        return temperatura;
    }

}
