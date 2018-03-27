package exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by dave on 3/19/18.
 */
public class SoftwareKeyStringFormat {

    static String inputStr = "3g-4ffre-llwe-KL5rrt-22-4edf-4s";

    static String[] inputA = inputStr.split("");
    static List<String> listStr = Arrays.asList(inputA);
    static ArrayList<String> arrListStr = new ArrayList<String>(Arrays.asList(inputA));
    static String allUpperCaseString = inputStr.toUpperCase();


    public static String reverseStringList(final List<String> strL) {
        StringBuilder sb = new StringBuilder();
        Collections.reverse(strL);
        for (String s : strL) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static String formatKeyString(final String s, final int k) {
        StringBuilder sb = new StringBuilder();
        String keyS = s.trim();
        int maxSeqLen = k;
        int seqCtr = 1;
        String[] sA = s.split("");
        //handle one or 0 elements first
        for (int i = keyS.length()-1; i >= 0; --i) {
            if (seqCtr == k+1) { //check to see if it needs a dash
                sb.append("-");
                seqCtr -= k;
            }
            if (sA[i].matches("^[0-9]+$")) {
                sb.append(sA[i]);
                ++seqCtr;
            } else if (!sA[i].equals("-")) {
                sb.append(sA[i].toUpperCase());
                ++seqCtr;
            }
        }
        return sb.reverse().toString();
    }

    public static String reverseStringArray(final String[] sArr) {
        StringBuilder sb = new StringBuilder();
        for (String s : sArr) {
            sb.append(s);
        }
        sb.reverse();
        return sb.toString();
    }

    public static Boolean[] isCharAnInt(final String[] sA) {
        Boolean[] retArr = new Boolean[inputA.length];
        for (int i = 0; i < sA.length; ++i) {
            if (sA[i].matches("^[0-9]+$")) {
                retArr[i] = true;
            } else {
                retArr[i] = false;
            }
        }
        return retArr;
    }

    public static Boolean[] isCharUppercase(final String[] sA) {
        Boolean[] retArr = new Boolean[inputA.length];
        for (int i = 0; i < sA.length; ++i) {
            if (sA[i].matches("^[A-Z]")) {
                retArr[i] = true;
            } else {
                retArr[i] = false;
            }
        }
        return retArr;
    }

    public static Boolean[] isCharLowercase(final String[] sA) {
        Boolean[] retArr = new Boolean[inputA.length];
        for (int i = 0; i < sA.length; ++i) {
            if (sA[i].matches("^[a-z]+$")) {
                retArr[i] = true;
            } else {
                retArr[i] = false;
            }
        }
        return retArr;
    }

    public static void printBooleanArray(final Boolean[] bA) {
        for (Boolean b : bA) {
            System.out.print(b + ", ");
        }
    }

    public static void printList(final List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }

    public static void printArray(final String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }

    //public static void reverseStringAsList

    public static void main(String[] args) {
        //printArray(allUpperCaseString.split(""));
        //printList(listStr);
        printBooleanArray(isCharUppercase(inputA));
        //System.out.print(reverseStringArray(inputA));
        //System.out.print(reverseStringList(listStr));
        //System.out.println(inputStr);
        //System.out.println(formatKeyString(inputStr, 4));
    }
}
