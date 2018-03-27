/**
 * Created by dave on 3/23/18.
 */
public class GooglePracticeFridayOne {

    static String pracS = "r";
    static int pracK = 1;

    /**
     *
     * @param S a non-empty String consisting of alphanumeric chars or dash chars '-'
     * @param K max number of chars for each sequence in the key
     * @return  formatted String where each sequence is equal to K other than first sequence which cna be less than k
     */
    public static String solution(String S, int K) {
        // write your code in Java SE 8
        StringBuilder sb = new StringBuilder();
        String tS = S.trim();
        int len = tS.length();
        int ctr = 1;
        String[] sA = tS.split("");
        for (int i = sA.length-1; i >= 0; --i) {
            if (ctr == pracK+1){
                sb.append('-');
                ctr = 1;
            }
            if (sA[i].matches("^[A-Z,a-z,0-9]")) {
                sb.append(sA[i].toUpperCase());
                ++ctr;
            }
        }

        sb.reverse();
        return sb.toString(); //probably reverse?
    }

    public static void main(String[] args) {
        System.out.println(solution(pracS, pracK));
    }

    //end of class GPFO
}
