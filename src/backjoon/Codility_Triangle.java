package backjoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Codility_Triangle {

    public static int solution(int[] A) {
        // write your code in Java SE 8

        Arrays.sort(A);
        for (int i =A.length-1; i >1; i--) {
            if (A[i] < (A[i-1] + A[i-2])) return 1;
        }

        return 0;


    }

    public static void main(String[] args) {

        int[] testValues = {10,50,5,1};
        System.out.println(solution(testValues));
    }
}
