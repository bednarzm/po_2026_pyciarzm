import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Lotto implements Odpad{
    private final List<List<Integer>> zestawyCyfr = new ArrayList<>();
    private Random random = new Random();
    public Lotto() {
        int ileZestawow = random.nextInt(5) + 1; // Nie jest napisane ile zestawow może byc wiec dalam od 1 do 5
        for (int i = 0; i < ileZestawow; i++) {
            List<Integer> zestaw = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                zestaw.add(random.nextInt(30) + 1);
            }
            zestawyCyfr.add(zestaw);
        }
    }

    @Override
    public double getWartoscRynkowa() {
        return 0.25;
    }

    @Override
    public String getKluczDoSegregatora() {
        return "KOPIE_KUPONÓW";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(zestawyCyfr, lotto.zestawyCyfr);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(zestawyCyfr);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "zestawyCyfr=" + zestawyCyfr +
                '}';
    }
}
