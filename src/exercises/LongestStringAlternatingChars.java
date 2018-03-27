package exercises; /** incomplete, time ran out but here is what i had so far
 * Created by dave on 3/20/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LongestStringAlternatingChars {

        static String pStr = "beabeefeab";

        static int twoCharaters(String s) {
            // Complete this function
            StringBuilder sb = new StringBuilder();
            String trimdS = s.trim();
            String[] strA = trimdS.split("");
            List<String> ckList = new ArrayList<>();
            //Arrays.sort(strACopy);
            //int freqA = Collections.frequency(strA, "a");
            HashSet<String> hSet = new HashSet<>();
            for (String str : strA) {
                int size = hSet.size();
                hSet.add(str);
                int newSize = hSet.size();
                if (size != newSize) {
                    ckList.add(str);
                }
                //System.out.println(hSet.toString());
            }
            for (String strCk : ckList) {
                int indx = ckList.indexOf(strCk);
                String ckPair = ckList.get(indx) + ckList.get(indx+1);
                String ckPairRev = ckList.get(indx+1) + ckList.get(indx);
               // countCharPairAlts(ckPair, strA);
               // countCharPairAlts(ckPairRev, strA);
            }
            Iterator<String> iter = hSet.iterator();
            while (iter.hasNext()) {
                //System.out.println(hSet.)
            }
            //System.out.print(hSet.toString());
            return sb.length();
        }

        public static void main(String[] args) {
            //Scanner in = new Scanner(System.in);
            //int l = in.nextInt();
            //String s = in.next();
            int result = twoCharaters(pStr);
            System.out.println(result);
            //in.close();
        }

    //end class LSAC
}
