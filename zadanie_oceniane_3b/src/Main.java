import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String plikZdarzenia = "my_favorite_occurences/zdarzenia.txt";

        System.out.println("Skaner: ");
        Skaner.scanDirectory("my_favorite_occurences");

        System.out.println("Parsowanie i procesowanie ");
        try {
            List<String> wierszeZdarzen = Parsowanie.wszystkieZdarzenia(plikZdarzenia);
            List<Zdarzenie> wczytaneObiekty = new ArrayList<>();

            for (String wiersz : wierszeZdarzen) {
                Zdarzenie z = tworzymyZdarzenia(wiersz);
                if (z != null) {
                    wczytaneObiekty.add(z);
                }
            }

            ProcesorZdarzen procesor = new ProcesorZdarzen(wczytaneObiekty);
            List<Zdarzenie> najliczniejszaGrupa = procesor.pobierzNajliczniejszaGrupePosortowana();

            System.out.println("Rozmiar wczytanych elementów bazowo: " + wczytaneObiekty.size());
            System.out.println("Liczba elementów w najliczniejszej grupie: " + najliczniejszaGrupa.size());

        } catch (IOException e) {
            System.err.println("Błąd wczytywania pliku: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Uszkodzone dane " + e.getMessage());
        }
    }

    private static Zdarzenie tworzymyZdarzenia(String wiersz) {
        String[] pola = wiersz.split("###");
        Map<String, String> wlasciwosci = new HashMap<>();

        for (String pole : pola) {
            if (pole.trim().isEmpty()) continue;
            String[] fragmenty = pole.split(":", 2);
            if (fragmenty.length == 2) {
                wlasciwosci.put(fragmenty[0], fragmenty[1]);
            }
        }

        String id = wlasciwosci.get("Id");
        String data = wlasciwosci.get("Data");
        String miejsce = wlasciwosci.get("Miejsce");
        String klasyfikacja = wlasciwosci.get("Klasyfikacja");
        String typ = wlasciwosci.get("Typ");
        String rodzaj = wlasciwosci.get("RodzajStatku");

        if (id == null || rodzaj == null) return null;

        return switch (rodzaj) {
            case "SZYBOWIEC" -> new Szybowiec(id, data, miejsce, klasyfikacja, typ,
                    wlasciwosci.get("ZnakiROzpoznawcze"),
                    wlasciwosci.get("LinkDoSPrawy"));
            case "SPADOCHRON" -> new Spadochron(id, data, miejsce, klasyfikacja, typ);
            case "MOTOPARALOTNIA" -> {
                double czynnik = 0.0;
                if (wlasciwosci.containsKey("LosowyCzynnik")) {
                    czynnik = Double.parseDouble(wlasciwosci.get("LosowyCzynnik"));
                }
                yield new Motoparalotnia(id, data, miejsce, klasyfikacja, typ, czynnik);
            }
            default -> null;
        };
    }
}