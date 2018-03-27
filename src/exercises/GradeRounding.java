package exercises; /**
 * Created by dave on 3/21/18.
 */
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class GradeRounding {

    /*
     * Complete the gradingStudents function below.
     */
    static int[] gradingStudents(int[] grades) {
        /*
         * Write your code here.
         */
        int noRound = 38;
        int[] retArr = new int[grades.length];
        for (int i = 0; i < grades.length; ++i) {
            if (grades[i] < noRound) {
                retArr[i] = grades[i];
            } else {
                int modFive = grades[i] % 5;
                int toFive = 5 - (modFive);
                if (toFive < 3) {
                    retArr[i] = grades[i] + toFive;
                } else {
                    retArr[i] = grades[i];
                }
            }
        }


        return retArr;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scan.nextLine().trim());

        int[] grades = new int[n];

        for (int gradesItr = 0; gradesItr < n; gradesItr++) {
            int gradesItem = Integer.parseInt(scan.nextLine().trim());
            grades[gradesItr] = gradesItem;
        }

        int[] result = gradingStudents(grades);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bw.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bw.write("\n");
            }
        }

        bw.newLine();

        bw.close();
    }
}

