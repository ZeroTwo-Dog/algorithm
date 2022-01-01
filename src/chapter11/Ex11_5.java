package chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by park on 2022/01/01.
 */
public class Ex11_5 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = 0, m = 0 ;

    while (n < 1 || n > 1000) {
      n = scan.nextInt();
    }

    while (m < 1 || n > 11) {
      m = scan.nextInt();
    }
    scan.nextLine();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int val = scan.nextInt();;

      if  (val < 0 || val > m ) {
        System.out.println("볼링공 무게를 잘 못 입력 하셨습니다.");
        break;
      }

      list.add(val);
    }

    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i+1; j < n; j++) {
          if (!Objects.equals(list.get(i), list.get(j)))
            count++;
      }
    }

    System.out.println(count);
  }

}
