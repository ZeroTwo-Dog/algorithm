package codility;

import java.util.Scanner;

/**
 * Created by park on 2022/11/02.
 */
public class Codility_CyclicRotation {

  public static int[] solution(int[] A, int K) {

    if (A.length == 0) {
      return A;
    }
    for (int i = 0; i < K; i++) {

      //배열 맨앞
      int temp = A[A.length-1];
      for (int j = A.length-1; j > 0; j--) {
        A[j] = A[j-1];

      }
      //맨앞 정리
      A[0] = temp;

    }

    return A;
  }

  public static void main(String[] args) {

    // 데이터를 담을 배열
    int[] data = {};
    int n = 4;

    solution(data, n);


  }

}
