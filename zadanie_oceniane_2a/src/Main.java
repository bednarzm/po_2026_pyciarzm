import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        UzytkownikSmieciarkiInterface smieciarka = Symulacja.stworzZaladowanaSmieciarke();
        Segregator segregator = Symulacja.stworzSegregator();
        Sortownik sortownik = Symulacja.stworzSortownik();

        List<Odpad> odpady = smieciarka.zwrocWszystko();

        segregator.segreguj(odpady);
        segregator.wypiszCalosc();

        System.out.println("\n--- WYPISANIE POJEDYNCZEJ FRAKCJI ---");
        segregator.wypiszPoTypie("BUTELE");
        
    }
}