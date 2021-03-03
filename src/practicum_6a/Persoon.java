package practicum_6a;

import java.util.ArrayList;
import java.util.Locale;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> mijnGames = new ArrayList<>();

    public Persoon(String nm,double bud){
        this.naam = nm;
        this.budget = bud;
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game g) {
        for (Game game : mijnGames) {
            if (game.getNaam() == g.getNaam()) {
                return false;
            }
        }
        if (getBudget() < g.huidigeWaarde()) return false;
        this.budget -= g.huidigeWaarde();
        this.mijnGames.add(g);
        return true;
    }

    public boolean verkoop(Game g, Persoon koper){
        for(Game game : mijnGames){
            if(game.getNaam() != g.getNaam()){
                continue;
            }
            boolean gekocht = koper.koop(g);
            if (!gekocht){
                return false;
            }
            this.budget += g.huidigeWaarde();
            this.mijnGames.remove(game);
            return true;
        }
        return false;
    }

    public String toString() {
        String result = this.naam + " heeft een budget van €";
        result = result + String.format(Locale.GERMAN,"%.2f",  getBudget());
        result  = result +  " en bezit de volgende games:";
        for (Game game: mijnGames){
            result += "\n" + game;
        }
        return result;
    };
}
