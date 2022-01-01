package chapter11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 만들 수 없는 금액
 * Created by park on 2022/01/01.
 */
public class Ex11_4 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = 0;

    while (1 > n || n > 1000) {
      n = scan.nextInt();
    }
    List<Integer> list  = new ArrayList<>();


    for (int  i = 0; i < n; i++ ) {
      list.add(scan.nextInt());
    }

    Collections.sort(list);


    //정수는 1부터 시작하기때문에
    int t = 1;
    for (int i = 0; i < n; i++) {
      //타겟 값이 더한 동전값보다 작으면 타겟값을 만들수 없다.
      if (t < list.get(i)) break;
      //위 if 절에 속하지 않으면 동전을 더한다.
      t += list.get(i);

    }

    System.out.println(t);

  }

}
