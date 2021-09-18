package chapter06;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 두 배열 최대합 만들기
 * Created by park on 2021/09/18.
 */
public class Ex6_3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int k = scan.nextInt();

    Integer[] arr1 = new Integer[n];
    Integer[] arr2 = new Integer[n];

    for (int i = 0; i < n; i++) {
      arr1[i] = scan.nextInt();
    }
    for (int i = 0; i < n; i++) {
      arr2[i] = scan.nextInt();
    }

    Arrays.sort(arr1);
    Arrays.sort(arr2, Collections.reverseOrder());

    for (int i = 0; i < k; i++) {
      int temp = arr2[i];
      arr2[i] = arr1[i];
      arr1[i] = temp;
    }
    //Integer 합계 stream으로 처리
    int sum = Arrays.stream(arr1).mapToInt(o -> o).sum();
    System.out.println(sum);
  }

}
