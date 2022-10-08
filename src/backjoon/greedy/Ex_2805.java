package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Ex_2805_나무자르기
 * Created by park on 2022/10/08.
 */
public class Ex_2805 {

  public static long binarySearch(int[] arr, int target, long start, long end) {

    while(start <= end) {
      long mid = (start + end) / 2;
      long cutLength = 0;

      for (int j : arr) {
        if (j > mid) {
          cutLength += j - mid;
        }
      }

      if (cutLength == target) {
        return mid;
      }

      if (cutLength >= target) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }

    }
    return end;

  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int m = scan.nextInt();


    int[] trees = new int[n+1];
    long max = 0;
    for (int i = 0; i < n; i++) {
      trees[i] = scan.nextInt();
      max = Math.max(max, trees[i]);
    }




        System.out.println(binarySearch(trees, m, 0, max));

  }

}
