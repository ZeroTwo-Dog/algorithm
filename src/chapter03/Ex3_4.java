package chapter03;

import java.util.Scanner;

/**
 * Created by park on 2021/08/19.
 */
public class Ex3_4 {

  public static void main(String[] args) {
    //1이 될때까지 작업
    // 1. n-1
    // 2. n/k
    // 두가지 방법으로 최소 횟수 구하기
    Scanner scan = new Scanner(System.in);

    int n, k, count = 0;
    n = scan.nextInt();
    k = scan.nextInt();

    // 경우의 수가 두가지 n > k , n <k
    if (n > k) {
      while (n%k != 0) {
        n = n-1;
        count++;
      }
      while (n != 1) {
        n = n / k;
        count++;
      }
      // n이 작을때는 나누기 작업이 이뤄지지 않음
    } else {
      while (n != 1) {
        n = n-1;
        count++;
      }
    }

    System.out.println(count);
  }


}
