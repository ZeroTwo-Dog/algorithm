package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 잃어버린 괄호
 * 백준 1541번
 * Created by park on 2022/02/28.
 */
public class Ex_1541 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int result = 0;
    String cal = scan.nextLine();

    String[] splitMinus = cal.split("-");

    for (int i = 0; i < splitMinus.length; i++) {
      int num = 0;
      if (splitMinus[i].contains("+")) {
        for (String plus : splitMinus[i].split("\\+")) {
          num += Integer.parseInt(plus);
        }
      } else {
        num = Integer.parseInt(splitMinus[i]);
      }
      result = (i == 0) ? num : result - num;
    }

    System.out.println(result);
  }

}
