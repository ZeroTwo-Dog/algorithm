package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 동전 0
 * Created by park on 2022/02/16.
 */
public class Ex_11047 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int k = scan.nextInt();

    int[] a = new int[n];

    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }

    int cnt = 0;
    a = Arrays.stream(a).sorted().toArray();
    for (int i = n-1; i >= 0; i--) {
      if (k >= a[i]) {
        cnt += k / a[i];
        k = k % a[i];

        if (k == 0) {
          break;
        }
      }
    }
    System.out.println(cnt);
  }
}
