package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ATM (백준 11399)
 * Created by park on 2022/01/27.
 */
public class Ex_11399 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] p = new int[n];

    for (int i = 0; i < n; i++) {
      p[i] = scan.nextInt();
    }

    p = Arrays.stream(p).sorted().toArray();

    int[] sumArrays = new int[n];
    int sum = 0;
    for (int i = 0; i < n; i ++) {
      if (i == 0) {
        sumArrays[i] = p[i];
      } else {
        sumArrays[i] += sumArrays[i-1] + p[i];
      }
      sum += sumArrays[i];
    }

    System.out.println(sum);
  }
}
