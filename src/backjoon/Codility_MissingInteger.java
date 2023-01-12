package backjoon;


import java.util.*;

public class Codility_MissingInteger {

    public static int solution(int[] A) {
        Set<Integer> list = new HashSet<>();
        Arrays.sort(A);

        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                list.add(A[i]);
            }
        }
        //음수만 구성되있는 경우
        if (list.size() == 0) {
            return 1;
        }

        int lastNumber = 0;
        //중간에 값이 빈경우
        for (int i = 0; i < list.size(); i++) {
            int checkNum = i+1;
            if (!list.contains(checkNum)) {
                return checkNum;
            }
            //중간에 값이 비어있지 않고, 끝에 값이 답일 경우
            lastNumber = checkNum+1;
        }

        return lastNumber;


    }

    public static void main(String[] args) {

        int[] testValues = {1,2,3};
        System.out.println(solution(testValues));
    }
}
