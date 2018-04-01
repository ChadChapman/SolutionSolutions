package templates;

import stringsarrays.Permutations;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAmount;
import java.util.*;

/**
 * Created by dave on 3/25/18.
 */
public class Solution {

    static String practiceStr1 = "hello";
    static String practiceStr2 = "java";
    static String practiceStr3 = "welcometojava";
    static String practiceStr4 = "<h1>Nayeem loves counseling</h1>";
    static String practiceStr5 = "";
    static int[] intArr = {5,3,5,2,3,2};
    static int k = 3;

    List<String> practiceList = new ArrayList<>();

    public static boolean canChicken(final double[] priceArr, final double target) {
        //both parameters are in dollars
        //use a hashset first? or an array? min heap?
        //return when found
        HashSet<Double> priceSet = new HashSet<>();

        for (int i = 0; i < priceArr.length; ++i) {
            double remainder = target % intArr[i];
            if (remainder == 0) {
                return true;
            }
            if (priceSet.contains(remainder)) {
                return true;
            }
            //need to recursively check it for smaller and smaller remainders
            //are the parameter arrays sorted?
        }
        //NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        //System.out.printf("Price in USD : %s %n", currencyFormat.format(priceInUSD));

        return false;
    } //end canChicken

    public static void main(String[] args ) {
        //examineTwoLowercaseStringsForLengthOrderPrintCased(practiceStr1, practiceStr2);
        //getLexicographicallySmallestAndLargestSubstringOfSizeK(practiceStr3, 3);
        //getLexicoSmallestLargestSubstringsSizeKTreeSet(practiceStr3, 3);
        //extractPrintContentFromTags(practiceStr4);
        //System.out.println(permuteSolution("23:59"));
        //System.out.println(Permutations.permutateStringWithPivot("permutate this!", 9));
       // System.out.println(permuteTimeString("18:01"));
      //  System.out.println(nextPermutatedTimeStringHHMM("23:11"));
        countMaxUniqueValuesInSubarray(intArr, k);
    }

    public void setupSolutionClass() {
        //set up test cases here
        practiceList.add(practiceStr1);
        practiceList.add(practiceStr2);
        practiceList.add(practiceStr3);
    }


    /**
     * count max unique items in a subarray of size k.
     *
     * Counts unique values in a subarray of size k of the parameter array.
     * Uses a Deque to maintain order and a HashMap to store occurrences of a
     * particular value in a subarray.  If the value is unique and it is removed
     * from the Deque, then it is removed HashMap as well so the map's size can be
     * used to count uniques.
     *
     * @param intArr Parent array, must be at least of size k, the other parameter
     * @param k size of the subarray to count unique values in
     * @return the most unique values found out of all subarrays of size k
     */

    public static int countMaxUniqueValuesInSubarray(final int[] intArr, final int k) {
        Deque<Integer> deck = new ArrayDeque<>();
        Integer retMax = Integer.MIN_VALUE;
        HashMap<Integer, Integer> uniquesMap = new HashMap<>();

        for (int i = 0; i < intArr.length; ++i) {
            int element = intArr[i];
            if (i <= k) { //fill the subarray until it is up to the length we are looking for
                deck.offerLast(element);
                if (uniquesMap.get(element) != null) {
                    Integer val = uniquesMap.get(element);
                    uniquesMap.put(element, val+1);
                } else {
                    uniquesMap.put(element, 1);
                }
            } else { //reached k, now look at all subarrays

                Integer qHead = deck.removeFirst();
                Integer newVal = uniquesMap.get(qHead);
                if (newVal == 1) { //sentinel value signals it's unique in
                    // the current subarray
                    uniquesMap.remove(qHead);
                    //uniquesMap.merge(element, 1, Integer::sum); //fancy way to say add this
                    // element's value to the set of uniques
                } else if (newVal > 1){ //sentinel value signals it is in the current subarray but
                    //it is not unique, so lower the tally on it by the one removed
                    uniquesMap.put(qHead, newVal-1);
                } else {
                    uniquesMap.put(element, 1);
                }
                deck.offerLast(element);

            }
            retMax = Math.max(retMax, uniquesMap.size());
        }
        System.out.println(retMax);
        return retMax;
    } //end cMUVIS



    /**
     * returns soonest time from the parameter time string, on 24 hour cycle
     *
     * @param paramStr time string in format "HH:MM"
     * @return next soonest time from permuting the parameter string
     *
     */
    public static String nextPermutatedTimeStringHHMM(final String paramStr) {

        LocalTime paramTime = LocalTime.parse(paramStr);
        LocalTime returnTime = LocalTime.parse(paramStr);
        List<LocalTime> timeList = createPermutatedHHMMTimesList(paramStr);
        Collections.sort(timeList); //sorts earliest to latest

        if (timeList.size() <= 1) {

            return paramTime.toString();

        } else {

            for (LocalTime lt : timeList) {

                System.out.println(lt.toString());
                System.out.println("*********************");
                if (returnTime.getHour() == lt.getHour()
                        && lt.getMinute() > returnTime.getMinute()) {

                    return lt.toString();

                } else if (lt.getHour() > returnTime.getHour()) {

                    return lt.toString(); //only going to work until midnight

                }
            }

            return timeList.get(0).toString();

        }
    }

    /**
     * make a list of permutations of a time string, only contains times found on a 24 hour clock
     *
     * Method permutes by shifting <-- left one index at a time.  Permutations whose hour > 23
     * or whose minutes > 60 are not included inthe return list.
     *
     * @param paramStr string representing a time in format "HH:MM"
     * @return list of any permutations derived from parameter string
     *
     */
    public static List<LocalTime> createPermutatedHHMMTimesList(final String paramStr) {
        StringBuilder sb = new StringBuilder();
        //create a string of just ints, no ":" which should be at [2]
        sb.append(paramStr.substring(0,2));
        sb.append(paramStr.substring(3));

        //create a list of all possible permutations of the string
        List<String> permutationsList = createListOfStringsLeftShift1Permutations(sb.toString());

        //iterate through the list of permutations, only add "valid" time strings
        //to the returned list of times
        List<LocalTime> timeList = new LinkedList<>();
        for (String s : permutationsList) {
            System.out.println(s);
            String pHour = s.substring(0,2);
            String pMins = s.substring(2);
            if (Integer.parseInt(pHour) < 24 && Integer.parseInt(pMins) < 60) {
                timeList.add(LocalTime.of(Integer.parseInt(pHour), Integer.parseInt(pMins)));
            }
        }

        return timeList;
    }

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

    private static List<String> createListOfStringsLeftShift1Permutations(final String str) {
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



    public static String permuteSolution(String S) {
        // write your code in Java SE 8
        String[] sa = S.split("");
        StringBuilder sb = new StringBuilder();
        int maxHour = 23;
        int maxMins = 59;
        String hStr = sa[0] + sa[1];
        String mStr = sa[3] + sa[4];
        Integer hourInt = Integer.parseInt(hStr);
        Integer minsInt = Integer.parseInt(mStr);
        Integer minHour = 0;
        Integer minMins = 0;

       // sb.append(permuteString(S));

        return sb.toString();
    }

    public static void extractPrintContentFromTags(final String paramString) {
        String ts = paramString.trim();
        StringBuilder sb = new StringBuilder();
        Deque<String> ds = new ArrayDeque<>();
        String[] sa = ts.split("[<||>]");
        //above regex splits but removes tag brackets from groups
        System.out.println(sa.length);
        for (String s : sa) {
            System.out.println("*********************");
            System.out.println(s+ " " + s.getBytes());
            char[] ca = s.toCharArray();
            for (char c : ca) {
                System.out.println((int)c);

            }
        }

    }

    public static String getLexicoSmallestLargestSubstringsSizeKTreeSet(String s, int k) {
        //more elegant but TreeSet has extra O(log(n)) complexity, making this O(n*log(n))
        SortedSet<String> sset = new TreeSet<>();

        for (int i = 0; i <= s.length()-k; ++i) {

            sset.add(s.substring(i,i+k));

        }

        System.out.println(sset.first());
        System.out.println(sset.last());
        return sset.first()+sset.last();
    }


    public static String getLexicographicallySmallestAndLargestSubstringOfSizeK(String s, int k) {
        //not the most elegant solution, better to use a sortedset
        String ts = s.trim();
        String ssml = ts.substring(0, k);
        String slrg = ts.substring(0,k);

        String[] sa = ts.split("");
        for (int i = 0; i <= sa.length-k; ++i) {
            String sub1 = ts.substring(i, i+k);

            if (sub1.compareTo(ssml) < 0) {
                ssml = sub1;
            }

            if (sub1.compareTo(slrg) > 0) {
                slrg = sub1;
            }

        }
        System.out.println(ssml + "\n" + slrg);
        return ssml + "\n" + slrg;
    }

    public static void examineTwoLowercaseStringsForLengthOrderPrintCased(final String sA, final String sB) {
        System.out.println(sA.length() + sB.length());
        System.out.println(((sA.compareTo(sB) > 0) ? "YES" : "NO"));
        StringBuilder sb = new StringBuilder();
        sb.append(sA.substring(0,1).toUpperCase());
        sb.append(sA.substring(1));
        sb.append(" ");
        sb.append(sB.substring(0,1).toUpperCase());
        sb.append(sB.substring(1));
        System.out.println(sb.toString());

    }
}
