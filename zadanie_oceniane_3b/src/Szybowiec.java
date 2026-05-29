public class Szybowiec extends Zdarzenie {
    private String znakiRozpoznawcze;
    private String linkDoSprawy;

    public Szybowiec(String id, String data, String miejsce, String klasyfikacja, String typ, String znakiRozpoznawcze, String linkDoSprawy) {
        super(id, data, miejsce, klasyfikacja, typ);
        this.znakiRozpoznawcze = znakiRozpoznawcze;
        this.linkDoSprawy = linkDoSprawy;
    }

    @Override
    public String toString() {
        return "Szybowiec{" +
                "znakiRozpoznawcze='" + znakiRozpoznawcze + '\'' +
                ", linkDoSprawy='" + linkDoSprawy + '\'' +
                '}' + super.toString();
    }

    @Override
    public void apply(ZdarzenieVisitor visitor) {
        visitor.visit(this);
    }
}
