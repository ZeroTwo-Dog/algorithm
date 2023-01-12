package codility;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_MaxNonoverlappingSegments {
  public static int solution(int[] A, int[] B) {
    // write your code in Java SE 8
    int n = A.length;
    int cnt = 0;

    int end = B[0];
    for (int i = 1; i < n; i++) {
      if (end < A[i]) {
        cnt++;

      }

    }
    return cnt;
  }



  public static void main(String[] args) {


    int[] test = {1,3,7,9,9};
    int[] testA = {5,6,8,9,10};
    System.out.println(solution(test, testA));

  }

}
