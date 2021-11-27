package chapter11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * 모험가 길드 문제
 * Created by park on 2021/11/27.
 */
public class Ex11_1 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    //n명의 모험가
    int n = scanner.nextInt();
    int count = 0;
    int result = 0;

    // 공포도 x이면 x명 이상으로 모험가 구룹 구성
    List<Integer> x = new ArrayList<>();
    for (int i = 0; i < n; i++)  {
      x.add(scanner.nextInt());
    }
    Collections.sort(x);

    //최대 몇개의 그룹으로 묶을 수 있나?

    for (int i = 0; i < n; i++) {
      count++;
      if (count >= x.get(i)) {
        result++;
        count = 0;
      }
    }

    System.out.println(result);
 }
}
