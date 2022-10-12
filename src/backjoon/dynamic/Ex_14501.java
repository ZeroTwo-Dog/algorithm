package backjoon.dynamic;

import java.util.Scanner;

/**
 * 퇴사 다이나믹 프로그래밍
 * Created by park on 2022/10/12.
 */
public class Ex_14501 {


  // n이 0~15까지이므로
  final static int[] d = new int[16];


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);


    int n = scan.nextInt();

    int[] t = new int[n];
    int[] p = new int[n];

    for (int i = 0; i < n; i++) {
      t[i] = scan.nextInt();
      p[i] = scan.nextInt();
    }

    for (int i = 0; i < n; i++) {
      if (i + t[i] <= n) {
        //수식
        //각각 날짜를 다 계산하고, 앞의 날짜와 포함되면 값을 더
        d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
      }
      d[i+1] = Math.max(d[i+1], d[i]);
    }

    System.out.println(d[n]);

  }
}
