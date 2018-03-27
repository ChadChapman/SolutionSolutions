package exercises;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by dave on 3/23/18.
 */
public class BracketMatchingUsingAStack {

    static String prac0F = "[]{}(";
    static String prac1F = "[][][{}{}{}{}{}{}(({)}{}{}0{}{}{}{}{}{}][][][][[{]}]";
    static String prac2F = "}[ryt]{fg}(sfd)ghfh)";
    static String prac3Y = "({()})";

    public static boolean isBracketsBalanced(final String s) {
        String tS = s.trim();
        final ArrayDeque<String> ad = new ArrayDeque<>(tS.length()); //O(n)
        final HashMap<String, String> hm = new HashMap<>(); //O(1)
        hm.put("]", "[");
        hm.put("}", "{");
        hm.put(")", "(");
        int index = 0;
        for (String sch : tS.split("")) {

            if (hm.containsValue(sch)) {
                ad.addLast(sch);
            } else {
                if (hm.containsKey(sch) && ad.isEmpty()) {
                    return false;
                }
                if (hm.containsKey(sch) && (hm.get(sch).equals(ad.peekFirst()))) {
                    ad.pop();
                }
            }

        }

        if (ad.isEmpty()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(isBracketsBalanced(prac3Y));

    }
}
