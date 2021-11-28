package chapter11;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 문자열 뒤집기
 * Created by park on 2021/11/28.
 */
public class Ex11_3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String s = scanner.nextLine();
    String[] strings = s.split("");

    List<Integer> strInt = new ArrayList<>();

    for (String string : strings) {
      strInt.add(Integer.parseInt(string));
    }

    int count1 = 0, count0 =0;

    //첫째 문자열 체크
    if (strInt.get(0) == 1) {
      count1++;
    } else {
      count0++;
    }


    // 그 이후 문자열
    for (int i = 0; i < strInt.size()-1; i++ ) {
      //다음 문자가 같지 않으면 반전
      if (strInt.get(i) != strInt.get(i+1)) {
        if (strInt.get(i+1) == 1) {
          count1++;
        } else {
          count0++;
        }
      }

    }

    System.out.println(Math.min(count0, count1));
  }

}
