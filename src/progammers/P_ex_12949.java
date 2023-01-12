package progammers;

import java.util.Arrays;

/**
 * 행렬의 곱셈
 * Created by park on 2022/12/10
 */
public class P_ex_12949 {

  public static int[][] solution(int[][] arr1, int[][] arr2) {
    int[][] answer = new int[arr1.length][arr2[0].length];

    for (int i = 0; i < arr1.length; i++) {
      for (int j = 0; j < arr2[0].length; j++) {
        for (int k = 0; k < arr2[0].length; k++) {
          answer[i][j] += arr1[i][k] * arr2[k][j];
        }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
//    int[][] arr1 = new int[][]{{1, 4}, {3, 2}, {4, 1}};
    int[][] arr1 = new int[][]{{2,3,2}, {4,2,4}, {3,1,4}};
    int[][] arr2 = new int[][]{{5,4,3},{2,4,1}, {3,1,1}};
//    int[][] arr2 = new int[][]{{3, 3}, {3, 3}};
    System.out.println(Arrays.deepToString(solution(arr1, arr2)));

  }

}
