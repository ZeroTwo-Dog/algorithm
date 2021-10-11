package chapter08;

import java.util.Scanner;

/**
 * 개미전사 (다이나믹 프로그래밍)
 * Created by park on 2021/10/11.
 */
public class Ex8_2 {

  final static int[] d = new int[30000];


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = 0;

    while(n <= 3 || n >= 100) {
      n = scan.nextInt();
    }
    int[] k = new int[n];

    for (int i = 0; i < n; i++) {
      while (k[i] <= 0 ||  k[i] >=1000) {
        k[i] = scan.nextInt();
      }
    }
//   굳이 다이나믹 프로그래밍으로 풀어야하는지 모르겠음 (n번째까지 돌리건 똑같은데 이건 0,1 안돌리는거 차이가 성능차이에
//    int sum = 0;
//    int sum1 = 0;
//
//    for (int i = 0; i < n; i++) {
//      if((i+1) % 2 == 0) {
//        sum +=k[i];
//      } else {
//        sum1 +=k[i];
//      }
//    }


//    System.out.println("메뚜기 식량 약탈 최댓값 : "+Math.max(sum, sum1));


    // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
    d[0] = k[0];
    d[1] = Math.max(k[0], k[1]);
    for (int i = 2; i < n; i++) {
      d[i] = Math.max(d[i - 1], d[i - 2] + k[i]);
    }

    // 계산된 결과 출력
    System.out.println(d[n - 1]);
  }

}
