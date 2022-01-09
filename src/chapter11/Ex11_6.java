package chapter11;

import java.util.Scanner;

/**
 * Created by park on 2022/01/01.
 */
public class Ex11_6 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = 0 , k = 0;


    while (n < 1 || n > 2000) {
      n = scan.nextInt();
    }

    while (k < 1 || k > 2000000) {
      k = scan.nextInt();
    }

    int[] food_times = new int[n];
    for (int i = 0; i < n; i++) {
      food_times[i] = 0;
      while (food_times[i] < 1 || food_times[i] > 1000) {
        food_times[i] = scan.nextInt();
      }
    }

    int sec = 0;
    int index = 0;

    while( sec < k )  {
      //index에 값이 0이 아닐때 경우
      if (food_times[index] > 0) {
        food_times[index] -= 1;
        index++;
      //index의 값이 0일때
      } else {
        do {
          index++;
          if (index >= n ) {
            index = 0;
          }
          if (food_times[index] > 0) {
            food_times[index] -= 1;
            index++;
            break;
          }

        } while (food_times[index] == 0);

      }
      if (index >= n ) {
        index = 0;
      }

      sec++;
    }

    System.out.println(index + 1);





  }

}
