public class Motoparalotnia extends Zdarzenie {
    private double losowyCzynnik;

    public Motoparalotnia(String id, String data, String miejsce, String klasyfikacja, String typ, double losowyCzynnik) {
        super(id, data, miejsce, klasyfikacja, typ);
        this.losowyCzynnik = losowyCzynnik;
    }

    @Override
    public String toString() {
        return "Motoparalotnia{" +
                "losowyCzynnik=" + losowyCzynnik +
                '}' + super.toString();
    }

    @Override
    public void apply(ZdarzenieVisitor visitor) {
        visitor.visit(this);
    }
}
