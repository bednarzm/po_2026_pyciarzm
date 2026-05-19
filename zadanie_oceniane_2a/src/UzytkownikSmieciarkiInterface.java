import java.util.List;

public interface UzytkownikSmieciarkiInterface {
    void wrzucSzklo(Butelki butelki);
    void wrzucMetal(Odpad odpad);
    void wyrzucMetalLepsze();
    void wrzucPapier(Lotto lotto);
    List<Odpad> zwrocWszystko();
}
