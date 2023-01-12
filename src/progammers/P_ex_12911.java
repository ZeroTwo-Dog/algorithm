package progammers;

import java.util.Stack;

/**
 * 다음 큰 숫자
 * Created by park on 2022/11/16.
 */
public class P_ex_12911 {

  public static int solution(int n) {
    int answer = 0;

    //바이너리에서 true 갯수 체크
    int nBinaryCnt = Integer.bitCount(n);

    for (int i = n+1; i <= 1000000; i++) {
      //바이너리에서 true 갯수 체크
      int binaryCnt = Integer.bitCount(i);
      if (binaryCnt == nBinaryCnt) {
        answer = i;
        break;
      }

    }

    return answer;
  }


  public static void main(String[] args) {
    System.out.println(solution(78));

  }

}
