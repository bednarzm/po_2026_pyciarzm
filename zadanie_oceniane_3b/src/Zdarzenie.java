import java.util.Objects;

public abstract class Zdarzenie {
    protected String id;
    protected String data;
    protected String miejsce;
    protected String klasyfikacja;
    protected String typ;

    public Zdarzenie(String id, String data, String miejsce, String klasyfikacja, String typ) {
        this.id = id;
        this.data = data;
        this.miejsce = miejsce;
        this.klasyfikacja = klasyfikacja;
        this.typ = typ;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Zdarzenie that = (Zdarzenie) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Zadarzenie{" +
                "id='" + id + '\'' +
                ", data='" + data + '\'' +
                ", miejsce='" + miejsce + '\'' +
                ", klasyfikacja='" + klasyfikacja + '\'' +
                ", typ='" + typ + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public abstract void apply(ZdarzenieVisitor visitor);

}
