package progammers;

import java.util.Arrays;

/**
 * [1차] 비밀지도
 * Created by park on 2022/12/10
 */
public class P_ex_11681 {

  public static String[] solution(int n, int[] arr1, int[] arr2) {
    String[] answer = new String[n];

    for (int i = 0; i < arr1.length; i++) {
      String binary1 =  Integer.toBinaryString(arr1[i]);
      if (binary1.length() != n) {
        int sub = n - binary1.length();

        binary1 = "0".repeat(Math.max(0, sub)) + binary1;
      }
      String binary2 =  Integer.toBinaryString(arr2[i]);

      if (binary2.length() != n) {
        int sub = n - binary2.length();

        binary2 = "0".repeat(Math.max(0, sub)) + binary2;
      }

      StringBuilder map = new StringBuilder();
      for (int j = 0; j < binary1.length(); j++) {

        if (binary1.charAt(j) == '1' || binary2.charAt(j) == '1') {
          map.append("#");
        } else {
          map.append(" ");

        }
      }
      answer[i] = map.toString();
    }


    return answer;
  }

  public static void main(String[] args) {
    int[] arr1 = new int[]{9, 20, 28, 18, 11};
    int[] arr2 = new int[]{30, 1, 21, 17, 28};
    System.out.println(Arrays.deepToString(solution(5,arr1, arr2)));

  }

}
