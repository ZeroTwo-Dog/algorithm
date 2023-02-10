package backjoon.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 *
 * 도시락 데우기기
 *
 * Created by park on 2023/02/10.
 */
public class Greedy_03 {

  static int[] result;

  static class LunchBox implements Comparable {
    int m;
    int e;


    LunchBox(int m, int e ){
      this.m = m;
      this.e = e;
    }


    //먹는시간 기준으로 정렬 (오래걸리는걸 먼저 먹임)
    @Override
    public int compareTo(Object o) {
      LunchBox lunchBox = (LunchBox) o;
      return lunchBox.e - this.e;
    }
  }

  public static int heat (Scanner scanner) {
    int n = scanner.nextInt();
    int[] m = new int[n];
    int[] e = new int[n];

    for (int i = 0 ; i < n; i++) {
      m[i] = scanner.nextInt();
    }

    for (int i = 0 ; i < n; i++) {
      e[i] = scanner.nextInt();
    }

    List<LunchBox> lunchBoxes = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      lunchBoxes.add(new LunchBox(m[i], e[i]));
    }

    Collections.sort(lunchBoxes);

    int result = 0;
    int time = 0;

    //데우는 시간의 합은 언제가 고정
    //먹는시간이 유동적
    //오래걸리는것부터 먼저 먹고, 데운시간 합 + 먹는시간 을 비교함 (오래걸리는것부터 먼저먹어서 가능함)
    for (LunchBox lunchBox : lunchBoxes) {
      time += lunchBox.m;
      result = Math.max(result, time + lunchBox.e);
    }
    return result;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int testCase = scanner.nextInt();
    result = new int[testCase];

    for (int i =0; i < testCase; i++) {
      result[i] = heat(scanner);
    }

    for (int j : result) {
      System.out.println(j);
    }





  }

}
