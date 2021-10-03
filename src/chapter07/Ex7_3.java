package chapter07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 떡볶이 떡 만들기 (이진탐색)
 * Created by park on 2021/10/03.
 */
public class Ex7_3 {
  // 이런 문제가 많을 거라서 재학습 필요함
  public static int binarySearch(int[] arr, int target, int start, int end) {

    int mid;
    int result = 0;
    while(start <= end) {
      mid = (start + end) / 2;
      int cutLength = 0;

      for (int j : arr) {
        cutLength += Math.max((j - mid), 0);
      }
        if (cutLength == target) {
          result = mid;
        }  if(cutLength > target) {
        result = mid;
          start = mid +1;
        } else {
          end = mid -1;
        }
    }
    return result;

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int m = scan.nextInt();

    int[] cakes =  new int[n];

    for (int i = 0; i < n; i++) {
      cakes[i] = scan.nextInt();
    }
    Arrays.sort(cakes);

    System.out.println(binarySearch(cakes, m, 0, cakes[cakes.length-1]));

  }
}
