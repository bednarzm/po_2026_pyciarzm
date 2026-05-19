import java.util.*;

public class Smieciearka implements UzytkownikSmieciarkiInterface {
    private final Deque<Butelki> szklo = new ArrayDeque<>();
    private final Deque<Odpad> metal = new ArrayDeque<>();
    private final List<Lotto> papier = new ArrayList<>();


    @Override
    public void wrzucSzklo(Butelki butelki) {
        szklo.push(butelki);
    }

    @Override
    public void wrzucMetal(Odpad odpad) {
        if (odpad instanceof Puszki) {
            metal.addFirst(odpad);
        } else if (odpad instanceof Misy) {
            metal.addLast(odpad);
        }
    }

    @Override
    public void wyrzucMetalLepsze() {

    }

    @Override
    public void wrzucPapier(Lotto lotto) {
        papier.add(lotto);
    }

    @Override
    public List<Odpad> zwrocWszystko() {
        List<Odpad> zbiorczy = new ArrayList<>();
        while (!szklo.isEmpty()) zbiorczy.add(szklo.pop());
        while (!metal.isEmpty()) zbiorczy.add(metal.removeFirst());
        zbiorczy.addAll(papier);
        papier.clear();
        Collections.shuffle(zbiorczy);
        return zbiorczy;
    }
}
