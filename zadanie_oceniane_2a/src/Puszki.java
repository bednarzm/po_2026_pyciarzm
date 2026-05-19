import java.util.Objects;
import java.util.Random;

public class Puszki implements Odpad{
    private final double pojemnosc = 0.66;
    private int osobyCoPily;
    private Random random = new Random();

    public Puszki() {
        this.osobyCoPily = random.nextInt(10) + 1;
    }


    @Override
    public double getWartoscRynkowa() {
        return 0.5;
    }

    @Override
    public String getKluczDoSegregatora() {
        return "PUSZKI";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Puszki puszki = (Puszki) o;
        return Double.compare(pojemnosc, puszki.pojemnosc) == 0 && osobyCoPily == puszki.osobyCoPily;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pojemnosc, osobyCoPily);
    }

    @Override
    public String toString() {
        return "Puszki{" +
                "pojemnosc=" + pojemnosc +
                ", osobyCoPily=" + osobyCoPily +
                '}';
    }
}
