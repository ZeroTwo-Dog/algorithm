package codility;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_Distinct {
  public static int solution(int[] A) {

    Set<Integer> integers =  new HashSet<>();

    for (int j : A) {
      integers.add(j);
    }

    return integers.size();

  }



  public static void main(String[] args) {


    int[] test = {2,1,1,2,3,1};
    int[] testA = {5,6,8,9,10};
    System.out.println(solution(test));

  }

}
