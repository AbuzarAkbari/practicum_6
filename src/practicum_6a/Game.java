package practicum_6a;

import java.util.Locale;
import java.util.Objects;
import java.time.LocalDate;


public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwePrijs;

    public Game(String nm, int rJ,double nP){
        this.naam= nm;
        this.releaseJaar=rJ;
        this.nieuwePrijs=nP;
    }

    public String getNaam(){
        return this.naam;
    }

    public double huidigeWaarde(){
//        return this.nieuwePrijs * 0.7 * (LocalDate.now().getYear() - this.releaseJaar);
        double huidigeWaarde = Math.pow(0.7, (LocalDate.now().getYear() - this.releaseJaar));
        return this.nieuwePrijs * huidigeWaarde;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return releaseJaar == game.releaseJaar  && Objects.equals(naam, game.naam);
    }


    public String toString() {
        String restult =  this.naam + ", uitgegeven in " + this.releaseJaar + "; nieuwprijs: €"
                + String.format(Locale.GERMAN,"%.2f",this.nieuwePrijs) + " nu voor: €" ;
        restult = restult + String.format(Locale.GERMAN,"%1$,.2f", huidigeWaarde());

        return restult;
    };
}
