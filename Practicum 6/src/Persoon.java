import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games;

    public Persoon(String nm, double bud) {
        this.naam = nm;
        this.budget = bud;
        this.games = new ArrayList<>();
    }

    public double getBudget() {
        return this.budget;
    }

    public boolean koop(Game game) {
        if (games.contains(game)) {
            return false; // Game is already owned
        }
        if (budget >= game.huidigeWaarde()) {
            budget -= game.huidigeWaarde();
            games.add(game);
            return true;
        }
        return false; // Not enough budget
    }

    public boolean verkoop(Game game, Persoon koper) {
        if (!games.contains(game)) {
            return false; // Seller does not own the game
        }
        if (koper.games.contains(game)) {
            return false; // Buyer already owns the game
        }
        if (koper.budget >= game.huidigeWaarde()) {
            koper.budget -= game.huidigeWaarde();
            this.budget += game.huidigeWaarde();
            koper.games.add(game);
            games.remove(game);
            return true;
        }
        return false; // Buyer cannot afford the game
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s heeft een budget van €%.2f en bezit de volgende games:", naam, budget));
        for (Game game : games) {
            sb.append("\n").append(game);
        }
        return sb.toString();
    }
}
