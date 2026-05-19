public class Symulacja {
    public static UzytkownikSmieciarkiInterface stworzZaladowanaSmieciarke() {
        Smieciearka woz = new Smieciearka();
        for (int i = 0; i < 6; i++) woz.wrzucSzklo(new Butelki());
        for (int i = 0; i < 7; i++) woz.wrzucMetal(new Puszki());
        for (int i = 0; i < 6; i++) woz.wrzucMetal(new Misy());
        for (int i = 0; i < 9; i++) woz.wrzucPapier(new Lotto());
        return woz;
    }

    public static Segregator stworzSegregator() {
        return new Segregator();
    }

    public static Sortownik stworzSortownik() {
        return new Sortownik();
    }
}
