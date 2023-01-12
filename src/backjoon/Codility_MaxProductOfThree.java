package backjoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codility_MaxProductOfThree {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int n = A.length;

        Arrays.sort(A);
        List<Integer> lower = new ArrayList<>();
        //상위 3개값이 제일크다고 가정 (음수2개 조합을 제외)
        int max = A[A.length-1] * A[A.length-2] * A[A.length-3];
        //음수추출
        for (int num : A) {
            if (num < 0) {
                lower.add(num);
            }
        }


        //음수가 2개이상이여서 곱하기를 할경우
        if (lower.size() >=2 ) {
            int combineLower = A[n-1]* lower.get(0) * lower.get(1);
            max = Math.max(max, combineLower);
        }

        return max;


    }

    public static void main(String[] args) {

        int[] testValues = {-3,-1,-2,-2,-5,-6};
        System.out.println(solution(testValues));
    }
}
