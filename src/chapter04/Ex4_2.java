package chapter04;

import java.util.Scanner;

/**
 * 3이 들어간 시간 경우의 수
 * Created by park on 2021/08/25.
 */
public class Ex4_2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int number = 60, count = 0;

    //String으로 비교한 이유는 십의자리까지 비교를 하기 위해서
    //continue를 사용한 이유는 for문을 최소한으로 돌리기 위함 (성능이슈)
    for (int i = 0; i <= n; i++) {
      if (String.valueOf(i).contains("3")) {
        count += number * number;
        continue;
      }
      for (int j = 0; j < number; j++) {
        if (String.valueOf(j).contains("3")) {
          count += number;
          continue;
        }
        for (int k = 0; k <  number; k++) {
          if (String.valueOf(k).contains("3")) {
            count++;
          }
        }
      }
    }
    System.out.println(count);
  }

}
