package chapter03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자 카드 게임
 * Created by park on 2021/08/16.
 */
public class Ex3_3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n , m;
    // n, m  입력
    // n > 0 , m <=100 조건
    do {
      n = scanner.nextInt();
    } while ( n < 0 );
    do {
      m = scanner.nextInt();
    } while (100 < m );

    int[][] data = new int[n][m];
    int[] minimumData = new int[n];
    // data 입력
    for (int i = 0; i < n; i ++) {
      for (int j = 0; j < m; j ++) {
       data[i][j] = scanner.nextInt();
      }
      //행별 최솟값 추출
      minimumData[i] = Arrays.stream(data[i]).sorted().toArray()[0];
    }

    //행별 최솟값 중 가장 큰값
    System.out.println(Arrays.stream(minimumData).sorted().toArray()[minimumData.length- 1]);






  }


}
