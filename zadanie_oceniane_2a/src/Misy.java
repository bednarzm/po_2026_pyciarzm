import java.util.Objects;
import java.util.Random;

public class Misy implements Odpad{
    private double pojemnosc;
    private Random random = new Random();

    public Misy() {
        this.pojemnosc = 1.5 + random.nextDouble()*1.5;
    }

    @Override
    public double getWartoscRynkowa() {
        return 0.5;
    }

    @Override
    public String getKluczDoSegregatora() {
        return "MISY";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Misy misy = (Misy) o;
        return Double.compare(pojemnosc, misy.pojemnosc) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(pojemnosc);
    }

    @Override
    public String toString() {
        return "Misy{" +
                "pojemnosc=" + pojemnosc +
                '}';
    }
}
