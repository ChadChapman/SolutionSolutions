package exercises;

/**
 * Created by dave on 3/21/18.
 */
public class PascalTriangleFromN {

    public static void pascalTriangleFactory(final int n) {
        int triSize = n+1;
        int[][] retArr = new int[triSize][triSize];

        int level = 1;
        retArr[0][0] = 1;
        retArr[1][0] = 1;
        retArr[1][1] = 1;
        while (level <= triSize-1) {
            System.out.println();
            System.out.print(1 + " ");
            retArr[level][0] = 1;
            retArr[level][level] = 1;
            for (int i = 1; i < level; ++i) {
                retArr[level][i] = retArr[level-1][i-1] + retArr[level-1][i];
                System.out.print(retArr[level][i] + " ");
            }
            System.out.print(1);
            ++level;
        }
    }

    public static void main(String[] args) {
        pascalTriangleFactory(5);
    }
}
