import java.util.*;

public class Segregator {
    private final Map<String, Set<Odpad>> segregator = new TreeMap<>();

    public void segreguj(Collection<Odpad> odpady) {
        segregator.put("BUTELE", new LinkedHashSet<>());
        segregator.put("MISY", new LinkedHashSet<>());
        segregator.put("PUSZKI", new LinkedHashSet<>());
        segregator.put("KOPIE_KUPONÓW", new LinkedHashSet<>());

        for (Odpad o : odpady) {
            String klucz = o.getKluczDoSegregatora();
            if (segregator.containsKey(klucz)) {
                segregator.get(klucz).add(o);
            }
        }
    }

    public void wypiszPoTypie(String typ) {
        if (typ == null || !segregator.containsKey(typ)) {
            throw new BrakInformacjiOTypieException("Nie podano informacji o typie śmieci, bądz podano błednie!!!");
        }

        System.out.println(typ + ": ");
        segregator.get(typ).forEach(System.out::println);
    }

    public void wypiszCalosc(){
        System.out.println("SEGREGATOR: ");
        segregator.forEach((typ, smieci) -> {
            System.out.println(typ + ": ");
            smieci.forEach(o -> System.out.println("  " + o));
        });
    }


}
