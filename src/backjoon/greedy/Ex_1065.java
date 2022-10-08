package backjoon.greedy;

import java.util.Scanner;

/**
 * Ex_1065_한수
 * Created by park on 2022/10/08.
 */
public class Ex_1065 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int result = 0;


    if (n >= 100 && n <=1000) {
      result += 99;
      for (int i = 100; i <= n; i++) {
        //자릿수별 분리
        char[] chars = String.valueOf(i).toCharArray();
        int[] nums = new int[chars.length];


        int[] subs = new int[chars.length-1];
        for (int j = 0; j < chars.length; j++) {
          nums[j] = Integer.parseInt(String.valueOf(chars[j]));
          if (chars.length > j+1) {
            nums[j+1] = Integer.parseInt(String.valueOf(chars[j+1]));
            //등차이기때문에 자릿수별 차이 공차를 구함
            subs[j] = nums[j] - nums[j+1];
          }
        }

        boolean same = false;
        for (int j = 0; j < subs.length; j++) {

          if (subs.length > j+1 ) {
            //공차가 같은지 체크
            same = subs[j] == subs[j + 1];
            // 공차가 하나라도 같지 않으면 등차가 아님
            if (!same) {
              break;
            }
          }
        }
        //모든 차이가 같다면 공차수열
        if (same) {
          result++;
        }

      }

    } else {
      result += n;
    }

    System.out.println(result);
  }

}
