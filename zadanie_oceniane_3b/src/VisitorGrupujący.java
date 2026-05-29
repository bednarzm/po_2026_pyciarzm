import java.util.ArrayList;
import java.util.List;

public class VisitorGrupujący implements ZdarzenieVisitor{
    private final List<Zdarzenie> szybowce = new ArrayList<>();
    private final List<Zdarzenie> spadochrony = new ArrayList<>();
    private final List<Zdarzenie> motoparalotnie = new ArrayList<>();


    @Override
    public void visit(Szybowiec szybowiec) {
        szybowce.add(szybowiec);
    }

    @Override
    public void visit(Spadochron spadochron) {
        spadochrony.add(spadochron);
    }

    @Override
    public void visit(Motoparalotnia motoparalotnia) {
        motoparalotnie.add(motoparalotnia);
    }

    public List<Zdarzenie> pobierzNajliczniejszaGrupe() {
        List<Zdarzenie> najliczniejsza = szybowce;

        if (spadochrony.size() > najliczniejsza.size()) {
            najliczniejsza = spadochrony;
        }
        if (motoparalotnie.size() > najliczniejsza.size()) {
            najliczniejsza = motoparalotnie;
        }

        return najliczniejsza;
    }
}
