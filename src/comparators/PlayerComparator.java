package comparators;

import models.Player;

import java.util.Comparator;

/**
 * Created by dave on 3/23/18.
 */
public class PlayerComparator implements Comparator<Player> {

    /**
     * Ascending comparator for two players.  It first sorts by their scores,
     * highest score at the bottom.  If scores are equal, it then sorts by name
     * lexicographically.
     * @param obj1
     * @param obj2
     * @return
     */
    public int compare(Player obj1, Player obj2) {
        if (obj1.getScore() == obj2.getScore()) {

            byte[] bA = obj1.getName().getBytes();
            byte[] bB = obj2.getName().getBytes();
            for (int i = 0; i < (Math.min(bA.length, bB.length)); ++i) {
                if (bA[i] != bB[i]) {
                    return bA[i] - bB[i];
                }
            }
        } else {
            return obj1.getScore() - obj2.getScore();
        }

        return 0;
    }


}
