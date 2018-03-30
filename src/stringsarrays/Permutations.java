package stringsarrays;

import java.util.*;

/**
 * Created by dave on 3/30/18.
 */
public class Permutations {

    /**
     * makes list of all permutations of an Integer array, permuted by k indexes at a time.
     *
     * This method shifts all indexes <-- left by k each time, then adds those permutations to
     * a HashSet which serves as a filter for duplicate permutations.
     * ONLY ONE OF EACH PERMUTATION WILL BE RETURNED IN THE LIST, NO DUPLICATES!
     *
     * @return list of all permutations found for the parameter array, after 1 pass
     *
     */

    public static List<String> createListOfStringsLeftShift1Permutations(final String str) {
        //store unique permutations in a set, add param string for sure
        Set<String> permutationsSet = new HashSet<>();
        permutationsSet.add(str);

        //turn string to array, loop through for all permutations
        //shifts left by 1 each iteration then adds each iteration to the set
        int counter = str.length();
        char[] charArr = str.toCharArray();
        while (counter > 0) {
            char firstChar = charArr[0];
            for (int i = 0; i < charArr.length-1; ++i) {

                charArr[i] = charArr[i + 1];
            }
            charArr[charArr.length - 1] = firstChar;
            permutationsSet.add(new String(charArr));
            //System.out.println(charArr.toString());
            --counter;
        }
        List<String> retList = new LinkedList<>();
        if (retList.addAll(permutationsSet)) {
            return retList;
        } else {
            return Collections.EMPTY_LIST;
        }
    }



}
