package backjoon;


import java.util.Arrays;
import java.util.Date;

public class Codility_MaxCounters {

    public static int[] solution(int N, int[] A) {
        int allCount = N+1;
        int[] result = new int[N];
        int maxCount = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i]==allCount) {
                //바꿀 최대 카운터값 추출
                //모든값 최대 카운터 값으로 변경
                Arrays.fill(result, maxCount);
            } else {
                //1~N 경우 해당 카운터 ++증가

                result[A[i]-1]++;
                maxCount = Math.max(maxCount, result[A[i]-1]);
            }

        }

        return result;


    }

    public static void main(String[] args) {

        int[] testValues = {2,1,1,3,4,5,6,6};
        System.out.println(solution(5,testValues));
    }
}
