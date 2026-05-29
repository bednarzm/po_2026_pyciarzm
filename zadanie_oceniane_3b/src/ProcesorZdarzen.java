import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProcesorZdarzen {
    private Set<Zdarzenie> unikalneZdarzenia = new HashSet<>();

    public ProcesorZdarzen(List<Zdarzenie> wczytaneZdarzenia) {
        this.unikalneZdarzenia = new HashSet<>(wczytaneZdarzenia);
    }

    public List<Zdarzenie> pobierzNajliczniejszaGrupePosortowana() {
        VisitorGrupujący visitor = new VisitorGrupujący();
        for (Zdarzenie zdarzenie : unikalneZdarzenia) {
            zdarzenie.apply(visitor);
        }
        List<Zdarzenie> wynik = visitor.pobierzNajliczniejszaGrupe();
        wynik.sort(Comparator.comparing(Zdarzenie::getId));
        return wynik;
    }

}
