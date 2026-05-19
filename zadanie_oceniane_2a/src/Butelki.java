import java.time.LocalDate;
import java.util.Objects;
import java.util.Random;

public class Butelki implements Odpad {
    private String rodzajSzkla;
    private String dataWaznosci;
    private String nazwaNapoju;
    private Random random = new Random();

    public Butelki() {
        boolean losowanieszkla = random.nextBoolean();
        if (losowanieszkla){
            rodzajSzkla = "uranowe";
        } else {
            rodzajSzkla = "niebieskie";
        }
        int losowyInt = random.nextInt(10000);
        this.nazwaNapoju = ("NAZWA-" + (int) Math.sqrt(losowyInt)).toLowerCase();
        this.dataWaznosci = "2026-12-31";
    }

    @Override
    public double getWartoscRynkowa() {
        return 0.25;
    }

    @Override
    public String getKluczDoSegregatora() {
        return "BUTELE";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Butelki butelki = (Butelki) o;
        return Objects.equals(rodzajSzkla, butelki.rodzajSzkla) && Objects.equals(dataWaznosci, butelki.dataWaznosci) && Objects.equals(nazwaNapoju, butelki.nazwaNapoju);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rodzajSzkla, dataWaznosci, nazwaNapoju);
    }

    @Override
    public String toString() {
        return "Butelki{" +
                "rodzajSzkla='" + rodzajSzkla + '\'' +
                ", dataWaznosci='" + dataWaznosci + '\'' +
                ", nazwaNapoju='" + nazwaNapoju + '\'' +
                '}';
    }
}
