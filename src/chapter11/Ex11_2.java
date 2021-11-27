package chapter11;

import java.util.Scanner;

/**
 * 곱하기 혹은 더하기
 * Created by park on 2021/11/27.
 */
public class Ex11_2 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String num = scanner.nextLine();

    String[] numeric = num.split("");


    int sum = Integer.parseInt(numeric[0]);

    for (int i =0; i < numeric.length; i++ ) {
      int val2 = 0;
      if (numeric.length-1 > i) {
        val2 =  Integer.parseInt(numeric[i+1]);
      } else {
        break;
      }

      if (sum == 0 || sum == 1) {
        sum += sum + val2;
      } else {
        if (val2 == 0 || val2 == 1) {
          sum += val2;
        } else {
          sum = sum * val2;
        }
      }
    }

    System.out.println(sum);
  }

}
