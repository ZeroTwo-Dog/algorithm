package codility;

import java.util.Scanner;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_BinaryGap {
  public static int solution(int N) {


    //2진수 변환하여 문자열로 리턴
    String squareResult = Integer.toBinaryString(N);


    //결과값
    return maxZeroDistance(squareResult);

  }

  public static int maxZeroDistance (String squareResult) {
    String[] split = squareResult.split("");
    int max =0;
    int current = 0;
    for (int i =0 ; i < split.length; i++) {

      if (split[i].equals("0")) {
        current++;
      } else {
        max = (max > current) ? max :current;
        current =0;
      }
    }
    return max;

  }



  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    System.out.println(solution(n));

  }

}
