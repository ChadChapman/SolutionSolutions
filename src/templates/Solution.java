package templates;

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

    List<String> practiceList = new ArrayList<>();

    /**
     * returns soonest time from the parameter time string, on 24 hour cycle
     *
     * @param paramStr time string in format "HH:MM"
     * @return next soonest time from permuting the parameter string
     * 
     */
    public static String nextPermutedTimeStringHoursMins(final String paramStr) {

        LocalTime paramTime = LocalTime.parse(paramStr);
        LocalTime returnTime = LocalTime.parse(paramStr);
        List<LocalTime> timeList = createPermutedTimesList(paramStr);
        Collections.sort(timeList); //sorts earliest to latest

        if (timeList.size() == 1) {

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

    public static List<LocalTime> createPermutedTimesList(final String paramStr) {
        String[] sa = paramStr.split("");
        //System.out.println(sa.length);
        ArrayList<String> sl = new ArrayList<>();
        for (String s : sa) {
            if (!s.equals(":")) {
                sl.add(s);
            }
        }
        Integer[] intArr = new Integer[sl.size()];
        int counter = 0;
        for (int i = 0; i < intArr.length; ++i) {

                intArr[counter] = Integer.parseInt(sl.get(i));
                ++counter;
            }
          //  sl.clear();
        Integer[] prevArr = Arrays.copyOf(intArr, intArr.length);
        counter = intArr.length;
        List<LocalTime> timeList = new ArrayList<>();
        while (counter > 0) {
            Integer[] permuteArr = Arrays.copyOf(prevArr, prevArr.length);
            Integer firstInt = permuteArr[0];
            for (int i = 0; i < permuteArr.length-1; ++i){
                permuteArr[i] = permuteArr[i+1];
            }
            permuteArr[permuteArr.length-1] = firstInt;
            //System.out.println(permuteArr.length);
            String pHour = permuteArr[0].toString() + permuteArr[1].toString();
            String pMins = permuteArr[2].toString() + permuteArr[3].toString();
            if (Integer.parseInt(pHour) < 24 && Integer.parseInt(pMins) < 60) {
                timeList.add(LocalTime.of(Integer.parseInt(pHour), Integer.parseInt(pMins)));
            }
            --counter;
            prevArr = permuteArr;
        }
        return timeList;
        }



    public static void main(String[] args ) {
        //examineTwoLowercaseStringsForLengthOrderPrintCased(practiceStr1, practiceStr2);
        //getLexicographicallySmallestAndLargestSubstringOfSizeK(practiceStr3, 3);
        //getLexicoSmallestLargestSubstringsSizeKTreeSet(practiceStr3, 3);
        //extractPrintContentFromTags(practiceStr4);
        //System.out.println(permuteSolution("23:59"));
        //System.out.println();
       // System.out.println(permuteTimeString("18:01"));
        System.out.println(nextPermutedTimeStringHoursMins("11:00"));
    }

    public void setupSolutionClass() {
        //set up test cases here
        practiceList.add(practiceStr1);
        practiceList.add(practiceStr2);
        practiceList.add(practiceStr3);
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
