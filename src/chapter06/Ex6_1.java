package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 내림차순
 * Created by park on 2021/09/18.
 */
public class Ex6_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    Integer[] sort = new Integer[n];

    for (int i = 0; i < n; i ++) {
      sort[i] = scan.nextInt();
      //버퍼 초기화
      scan.nextLine();
    }
    //내림차순 기본 제공 함수 기억하기
    Arrays.sort(sort, Collections.reverseOrder());

    for (int i = 0; i < n; i++) {
      System.out.print(sort[i] + " ");
    }
  }
}
