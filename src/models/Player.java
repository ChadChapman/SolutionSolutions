package models;

/**
 * Created by dave on 3/24/18.
 */
public class Player {

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int score;

    public Player(String s, int pScore) {
        name = s;
        score = pScore;
    }
}
