package backjoon;


import java.util.ArrayList;
import java.util.List;

public class Codility_MaxSliceSum {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int max = 0;

        for (int i = 0; i < A.length; i++) {
            max = A[i];
            int sum = A[i];
            for (int j = i+1 ; j <A.length; j++) {
                sum += A[j];
                max = Math.max( max, sum);

            }
        }

        return max;


    }

    public static void main(String[] args) {

        int[] testValues = {-1000000};
        System.out.println(solution(testValues));
    }
}
