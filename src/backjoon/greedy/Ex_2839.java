package backjoon.greedy;

import java.util.Scanner;

/**
 * 설탕 배달 (백준 2839)
 * Created by park on 2022/01/26.
 */
public class Ex_2839 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();

    int kg3 = 3, kg5 = 5;
    int count1 = -1, count2 =-1;


    if (n >= kg5) {
      for (int i = 1; i <= n / kg5; i++) {

        int beforeCount = count1;
        count1 = (kg5*i)/kg5;
        int kg = n % (kg5*i);
        if (kg%kg3 == 0) {
          count1 += kg / kg3;
        } else  {
          count1 = beforeCount > 0 ? beforeCount : -1;
        }
      }
    }

    if (n >= kg3) {
      for (int i = 1; i <= n / kg3; i++) {

        int beforeCount = count2;
        count2 = (kg3*i)/kg3;
        int kg = n % (kg3*i);

        if (kg % kg5 == 0) {
          count2 += kg / kg5;
        } else {
          count2 = beforeCount > 0 ? beforeCount: -1 ;
        }
      }
    }




    int count;
    if (count1 == -1 || count2 == -1) {
      if (count1 == -1 && count2 != -1) {
        count = count2;
      } else {
        count = count1;
      }
    } else {
      count = Math.min(count1, count2);
    }

    System.out.println(count);



  }
}
