package exercises; /**
 * Created by dave on 3/21/18.
 */

import java.io.*;
        import java.util.*;
        import java.text.*;
        import java.math.*;
        import java.util.regex.*;

public class TwoObjectsSameDirectionDifferentVelocities {

    /**
     * Given two objects traveling in same, positive direction with
     * maybe different starting points and maybe different velocities,
     * will they ever meet at same place at same time, same number of
     * moves for each one?
     *
     * @param x1 position of object 1, on the x axis
     * @param v1 velocity of object 1
     * @param x2 position of object 2, on the x axis
     * @param v2 velocity of object 2
     * @return yes or no if the two objects will ever meet at same place at same time
     */
    static String kangaroo(int x1, int v1, int x2, int v2) {
        // Complete this function
        boolean isP = false;

        if ((x1 < x2 && v1 <= v2) || (x2 < x1 && v2 <= v1)) {

            isP = false;

        } else {

            int startDiff = Math.abs(x1 - x2);
            int vDiff = Math.abs(v1-v2);

            if (startDiff % vDiff == 0) {
                isP = true;
            }
        }

        if (isP) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();
        String result = kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}