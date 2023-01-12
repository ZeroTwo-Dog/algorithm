package backjoon;


import java.util.*;

public class Codility_NumberOfDiscIntersections {

    public static int solution(int[] A) {

        List<Long> upper = new ArrayList<>();
        List<Long> lower = new ArrayList<>();

        for (int i = 0; i< A.length; i++) {
            upper.add((long) (i + A[i]));
            lower.add((long) (i - A[i]));
        }


        int result = 0;
        for (int i =0; i < lower.size(); i++)  {
            for (int j =0; j < upper.size(); j++) {
                //자기 자신을 경우
                if (i == j) {
                    continue;
                }

                if ( lower.get(j) >= lower.get(i) && lower.get(j) < upper.get(i) ||
                        upper.get(j) >= lower.get(i) && upper.get(j) < upper.get(i))
                    result++;
                }

            }


        if(result > 10000000) return -1;



        return result;


    }

    public static void main(String[] args) {

        int[] testValues = {1,5,2,1,4,0};
        System.out.println(solution(testValues));
    }
}
