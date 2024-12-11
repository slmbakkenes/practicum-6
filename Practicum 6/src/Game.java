import java.time.LocalDate;

public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwPrijs;

    public Game(String nm, int rJ, double nwpr) {
        this.naam = nm;
        this.releaseJaar = rJ;
        this.nieuwPrijs = nwpr;
    }

    public String getNaam() {
        return this.naam;
    }

    public double huidigeWaarde() {
        int jarenVerschil = LocalDate.now().getYear() - releaseJaar;
        return nieuwPrijs * Math.pow(0.7, jarenVerschil);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Game other)) return false;
        return this.naam.equals(other.naam) && this.releaseJaar == other.releaseJaar;
    }

    @Override
    public String toString() {
        return String.format("%s, uitgegeven in %d; nieuwprijs: €%.2f nu voor: €%.2f",
                naam, releaseJaar, nieuwPrijs, huidigeWaarde());
    }
}
