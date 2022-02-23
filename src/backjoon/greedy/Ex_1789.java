package backjoon.greedy;

import java.util.Scanner;

/**
 * 수들의 합
 * Created by park on 2022/02/23.
 */
public class Ex_1789 {

  public static void main(String[] args) {
    Scanner scan =  new Scanner(System.in);

    //자연수 핪 조건 1 ~ 4,294,967,295 이라서 long 타입
    long s = scan.nextLong();
    int n = 0;
    for (int i = 1; i <= s; i++) {
      if (s <= 0) break;
      if (s == 1) {
        n = 1;
        break;
      }
      s -= i;
      n++;
    }
    System.out.println(n);
  }
}
