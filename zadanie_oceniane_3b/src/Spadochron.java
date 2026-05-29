public class Spadochron extends Zdarzenie {

    public Spadochron(String id, String data, String miejsce, String klasyfikacja, String typ) {
        super(id, data, miejsce, klasyfikacja, typ);
    }

    @Override
    public String toString() {
        return "Spadochron{} " + super.toString();
    }

    @Override
    public void apply(ZdarzenieVisitor visitor) {
        visitor.visit(this);
    }
}
