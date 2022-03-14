package backjoon.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 보물
 * Created by park on 2022/03/14.
 */
public class Ex_1026 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int[] a = new int[n];
    List<Integer> b = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
    }

    for (int i = 0; i < n; i++) {
      b.add(scan.nextInt());
    }

    //조건이 A만 정렬
    Arrays.sort(a);
    int s = 0;
    for (int i = 0; i < n; i++) {
      //B는 재정렬 할 수 없으므로, 올림차순으로 max값을 추출후 사용한값 제거
      int bVal = b.stream().mapToInt(val -> val).max().getAsInt();
      int bIndex = b.indexOf(bVal);
      b.remove(bIndex);
      s += a[i] * bVal;
    }

    System.out.println(s);
  }
}
