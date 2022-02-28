package backjoon.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 로프
 * Created by park on 2022/02/28.
 */
public class Ex_2217 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[] ropeWeight = new int[n];
    for (int i = 0; i < n; i++) {
      ropeWeight[i] = scan.nextInt();
    }

    Arrays.sort(ropeWeight);

    int reuslt = 0;

    int puls = 1;
    for (int i = ropeWeight.length-1; i >= 0; i--) {

//      int cnt = (i)==0 ? i : puls;
      reuslt = Math.max((ropeWeight[i]*puls ),reuslt);
      puls++;
    }



    System.out.println(reuslt);
  }
}
