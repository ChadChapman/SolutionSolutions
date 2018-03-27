package exercises;

/**
 * Created by dave on 3/20/18.
 */

    public class FindParityOutlier{

        public static int find(int[] integers){
            int outL = 0;
            boolean isOdd = false;
            boolean isEven = false;
            int odds = 0;
            if (integers[0] % 2 == 1) {
                ++odds;
            }
            if (integers[1] % 2 == 1) {
                ++odds;
            }
            if (integers[2] % 2 == 1) {
                ++odds;
            }
            if(odds > 1) {
                for (int i = 0; i < integers.length; ++i) {
                        if ((integers[i] % 2) == 0) {
                            outL += integers[i];
                        }
                    }
            } else {
                    for (int j = 0; j < integers.length; ++j) {
                        if ((integers[j] % 2) == 1) {
                            outL += integers[j];
                        }
                    }
                }
            return outL;
        }

    //end of class
}
