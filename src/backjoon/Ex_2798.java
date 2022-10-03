package backjoon;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * 블랙잭
 * Created by park on 2022/10/03.
 */
public class Ex_2798 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int m = scan.nextInt();
    Integer[] cards = new Integer[n];
    int cardSum = 0;

    for (int i = 0; i < n; i++) {
      cards[i] = scan.nextInt();
    }


    Arrays.sort(cards, Collections.reverseOrder());

    for (int i = n-1; i >= 0; i--) {
      for (int j = i-1; j >- 0; j--) {
        for (int k = j-1; k >= 0; k--) {
          int sum =  cards[i] + cards[j] + cards[k];
          if (sum <= m) {
            //기존것보다 m차이가 작아지면 저쟝
            if ((m-cardSum) > (m-sum)) {
              cardSum = sum;
            }

          }
        }
      }
    }


    System.out.println(cardSum);
  }
}
