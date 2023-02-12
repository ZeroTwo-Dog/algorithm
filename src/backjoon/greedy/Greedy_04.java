package backjoon.greedy;

import java.util.Arrays;

public class Greedy_04 {

    public final static String NONE = "NONE";
    public final static String PASS = "PASS";
    public final static String BREAK = "BREAK";

    public static int solution(int[][] histogram) {
        int answer = 1;
        int n = histogram[0].length;
        String[] results = new String[n];
        Arrays.fill(results, NONE);

        int[] resultsNum = new int[n];
        Arrays.fill(resultsNum, 1);

        for (int[] his : histogram) {
            for (int j = 0; j < n; j++) {

                //맨위에 있을경우
                if (his[j] == 1 && results[j].equals(NONE)) {
                    results[j] = PASS;
                }

                //손상이 있었는데 뒤에 공백일 경우 초기화
                if (his[j] == 0 && results[j].equals(BREAK)) {
                    results[j] = NONE;
                    resultsNum[j] = 1;
                }

                //손상이 있었는데 뒤에 막대가 있을 경우
                if (his[j] == 1 && results[j].equals(BREAK)) {
                    results[j] = PASS;
                }


                //손상된 경우
               if (his[j] == 2 && (results[j].equals(NONE) || results[j].equals(BREAK))) {
                    results[j] = BREAK;
                    resultsNum[j]++;
                }
            }

        }


        for (int i = 0; i < n; i++) {
            answer = answer * resultsNum[i];
        }

        return answer;
    }

    public static void main(String[] args) {


        int[][] v = new int[][]
                {{0,0,0,0,0,0,1},
                        {0,0,0,1,0,0,1},
                        {0,1,0,1,0,0,1},
                        {1,1,2,2,1,0,1},
                        {2,2,2,2,1,2,2},
                        {2,2,1,1,1,2,2},
                        {2,2,1,1,1,2,2}
                };


//        int[][] v = new int[][]
//                {{0,0,0,0,0},
//                        {0,0,0,0,0},
//                        {2,2,0,0,0},
//                        {1,0,1,0,0},
//                        {2,1,2,2,2},
//                        {2,1,2,2,2},
//                };
        System.out.println(solution(v));

    }
}
