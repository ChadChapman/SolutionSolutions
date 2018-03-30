package stringsarrays;

import java.time.LocalTime;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by dave on 3/30/18.
 */
public class TimeString {

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
        List<String> permutationsList = Permutations.createListOfStringsLeftShift1Permutations(sb.toString());

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

}
