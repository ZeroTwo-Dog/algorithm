package chapter12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 문자열 재정렬
 * Created by park on 2022/01/17.
 */
public class Ex12_2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String str = scan.nextLine();

    List<String> list = new ArrayList<>();

    int sum = 0;

    for (int i = 0; i < str.length(); i++) {
      if (Character.isDigit(str.charAt(i))) {
        sum += str.charAt(i) - '0';
      } else {
        list.add(String.valueOf(str.charAt(i)));
      }
    }
    Collections.sort(list);
    for (String s : list) {
      System.out.print(s);
    }
    System.out.print(sum);
  }

}
