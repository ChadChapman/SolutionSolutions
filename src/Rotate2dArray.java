/**
 * Created by dave on 4/12/18.
 */
public class Rotate2dArray {




    public static void main(String[] args) {
    int[][] testArr = createPopulate2dArrayAscending(3, 4);
    //int[][] arrRotated90DegRight = rotate2dArr90Right(testArr);
    display2dArr(testArr);
    }

    public static void display2dArr(final int[][] displayArr) {
        for (int i[] : displayArr) {
            System.out.println();
            for (int j : i) {
                System.out.print(j + " ");
            }
        }
        System.out.println();
    }

    public static int[][] createPopulate2dArrayAscending(final int height, final int width) {
        int[][] returnArr = new int[height][width];
        int seedValue = 0;
        for (int i = 0; i < height; ++i){
            for (int j = 0; j < width; ++j) {
                returnArr[i][j] = seedValue;
                seedValue++;
            }
        }
        return returnArr;
    }
}
