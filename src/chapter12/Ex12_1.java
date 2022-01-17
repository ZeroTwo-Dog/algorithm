package chapter12;

import java.util.Scanner;

/**
 * 럭키 스트레이
 * Created by park on 2022/01/17.
 */
public class Ex12_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    int rightSum = 0;
    int leftSum = 0;

    String nStr = Integer.toString(n);
    for (int i = 0; i < nStr.length(); i++) {
      int sum = Integer.parseInt(String.valueOf(nStr.charAt(i)));
      if (i >=  nStr.length()/2) {
        rightSum += sum;
      }else {
        leftSum += sum;
      }
    }

    if (rightSum == leftSum) {
      System.out.println("LUCKY");
    } else {
      System.out.println("READY");
    }
  }

}
