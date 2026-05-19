import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Informator {
    private final Set<Odpad> bazaSmieci = new HashSet<>();
    private final int LIMIT_POJEMNOSCI = 10000000;

    public void zarejestrujOdpady(Collection<Odpad> odpady) throws PrzekroczenieLimituPojemnosciException {
        if (bazaSmieci.size() + odpady.size() > LIMIT_POJEMNOSCI) {
            throw new PrzekroczenieLimituPojemnosciException( "Przekroczono limit pojemności!");
        }
        bazaSmieci.addAll(odpady);
    }

    public boolean czyPosiadaOdpad(Odpad o) {
        return bazaSmieci.contains(o);
    }
}
