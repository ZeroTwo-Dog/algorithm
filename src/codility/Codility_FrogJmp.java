package codility;

import java.util.Scanner;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_FrogJmp {
  public static int solution(int X, int Y, int D) {
    //개구리가 가야할 거리
    int distinct = Y-X;
    if (distinct == 0) {
      return 0;
    }
    int remainder = distinct % D;
    int cnt;

    // 나머지가 0 초과이면 나누기 값에 +1 (한번 더 전진해야지 역전)
    if (remainder > 0) {
      cnt = (distinct/D) + 1;
    //나머지가 0이면 X와 Y가 동일선상 이므로 나누기 값 만큼 이동
    } else {
      cnt = (distinct/D);
    }
    return cnt;

  }



  public static void main(String[] args) {


    System.out.println(solution(20,80,30));

  }

}
