package chapter04;

import java.util.Scanner;

/**
 * 체스
 * 왕실의 나이트
 * Created by park on 2021/08/25.
 */
public class Ex4_3 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int boundary = 8;
    // 아스키코드로 변환후 숫자 추출
    String inputData = scan.nextLine();
    int row = inputData.charAt(1) - '0';
    int column = inputData.charAt(0) - 'a' + 1;

    int count = 0;



    int[][] steps = { { -2, -1 }, { -2, 1 }, { 2, 1 }, { 2, -1 } , { 1, -2 }, { 1, 2 },{ -1, 2 }, { -1, -2 } };

    for (int[] step : steps) {
      if (row +step[0] <= boundary && row  +step[0] > 0
      && column +step[1] <= boundary && column + step[1] > 0) {
        count++;
      }
    }
    System.out.println(count);


  }
}
