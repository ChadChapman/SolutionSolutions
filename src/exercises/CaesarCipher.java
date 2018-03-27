package exercises; /**
 * Created by dave on 3/20/18.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class CaesarCipher {

    static String testS = "middle-Outz";

        static String caesarCipher(String s, int k) {
            // Complete this function
            StringBuilder sb = new StringBuilder();
            String alph = "abcdefghijklmnopqrstuvwxyz";

            List<String> lowList = Arrays.asList(alph.split(""));
            List<String> uppList = Arrays.asList(alph.toUpperCase().split(""));
            String[] shiftedArrL = rotateArray(alph.split(""), k);
            String[] shiftedArrU = rotateArray(alph.toUpperCase().split(""), k);

            String tS = s.trim();
            String[] sA = tS.split("");


            for (int i = 0; i < sA.length; ++i) {

                String iS = sA[i];

                if (lowList.contains(iS)) {

                    sb.append(shiftedArrL[lowList.indexOf(iS)]);

                } else if (uppList.contains(iS)) {

                    sb.append(shiftedArrU[uppList.indexOf(iS)]);

                    }
                else {
                    sb.append(iS);
                    }
                }
            return sb.toString();
        }

        static String[] rotateArray(final String[] sArr, final int shiftVal) {
            StringBuilder sb = new StringBuilder();
            int modVal = shiftVal % 26;
            for (int i = modVal; i < sArr.length; ++i) {
                sb.append(sArr[i]);
                //sb.append(sArr[(i%26)]);
            }
            for (int i = 0; i < modVal; ++i) {
                sb.append(sArr[i]);
            }
            //System.out.println(sb.toString());
            return sb.toString().split("");
        }

        public static void main(String[] args) {
//            Scanner in = new Scanner(System.in);
//            int n = in.nextInt();
//            String s = in.next();
//            int k = in.nextInt();
//            String result = caesarCipher(s, k);
//            System.out.println(result);
//            in.close();
            System.out.println(caesarCipher(testS, 28));
        }
    }

