package backjoon.greedy;

import java.util.Scanner;

/**
 * 분해합
 * Created by park on 2022/10/24.
 */
public class Ex_2231 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int result = n;

    for (int i = n; i > 0; i--) {
      String split = String.valueOf(i);
      char[] chars = split.toCharArray();
      int cal = i;

      for (Character c : chars) {
        cal += (Integer.valueOf(c)-48);

      }

      if (n == cal) {
        result = Math.min(i, result);
      }


    }
    System.out.println(result==n?0:result);
  }

}
