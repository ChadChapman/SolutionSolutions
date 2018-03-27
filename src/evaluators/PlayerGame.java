package evaluators;

import comparators.PlayerComparator;
import models.Player;

import java.util.Arrays;

/**
 * Created by dave on 3/24/18.
 */
public class PlayerGame {


    static Player[] pA = new Player[5];

    public static void main(String[] args) {
        pA[0] = new Player("amy", 100);
        pA[1] = new Player("sara", 100);
        pA[2] = new Player("amy", 150);
        pA[3] = new Player("dave", 190);
        pA[4] = new Player("dan", 80);

        Arrays.sort(pA, new PlayerComparator());
        for (Player p : pA) {
            System.out.println(p.getName() + " " + p.getScore());
        }
    }
}
