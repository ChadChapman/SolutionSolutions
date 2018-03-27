package exercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by dave on 3/20/18.
 */
public class VowelCounter {

    public static int getCount(String str) {
        int vowelsCount = 0;
        String tS = str.trim();
        List<String> vList = Arrays.asList("aeiou".split(""));
        String[] sA = tS.split("");
        for (String s : sA) {
            if (vList.contains(s)) {
                ++vowelsCount;
            }
        }
        // your code here
        return vowelsCount;
    }

}
