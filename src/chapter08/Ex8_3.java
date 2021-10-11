package chapter08;

import java.util.Scanner;

/**
 * 바닥 공사 (다이나믹 프로그래밍)
 * Created by park on 2021/10/11.
 */
public class Ex8_3 {

  // 앞서 계산된 결과를 저장하기 위한 DP 테이블 초기화
  public static int[] d = new int[1001];

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();

    // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
    d[1] = 1;
    d[2] = 3;
    for (int i = 3; i <= n; i++) {
      d[i] = (d[i - 1] + 2 * d[i - 2]) % 796796;
    }

    // 계산된 결과 출력
    System.out.println(d[n]);
  }
}
