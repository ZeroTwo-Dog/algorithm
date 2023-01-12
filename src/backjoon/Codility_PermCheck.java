package backjoon;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Codility_PermCheck {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] != (i+1) ) {
                return 0;
            }
        }

        return 1;
    }

    public static void main(String[] args) {

        int[] testValues = {4,1,2};
        System.out.println(solution(testValues));
    }
}
