package backjoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Codility_TapeEquilibrium {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int maxValue = A.length;
        int sum = Arrays.stream(A).sum();
        List<Integer> result = new ArrayList<>();
        result.size();

        int firstSum = 0;
        int secondSum;
        for (int i = 0; i < (maxValue-1); i++) {
            firstSum += A[i];
            secondSum = sum -firstSum;


            result.add((Math.abs(firstSum-secondSum)));
        }


        return Collections.min(result);

    }

    public static void main(String[] args) {

        int[] testValues = {1000,-1000};
        System.out.println(solution(testValues));
    }
}
