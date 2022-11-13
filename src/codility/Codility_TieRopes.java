package codility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_TieRopes {
  public static int solution(int K, int[] A) {

    int lopeCnt = 0;
    int lopeLen = 0;

    for (int j : A) {
      lopeLen += j;

      if (lopeLen >= K) {
        lopeCnt++;
        lopeLen = 0;
      }
    }


    return lopeCnt;
  }



  public static void main(String[] args) {


    int[] test = {5};
    System.out.println(solution(4,test));

  }

}
