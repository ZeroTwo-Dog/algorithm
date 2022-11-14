package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 혼자 놀기 달인
 * Created by park on 2022/11/14.
 */
public class P_ex_131130 {



  public static int solution(int[] cards) {

    boolean[] visited = new boolean[cards.length];
    List<Integer> cntList = new ArrayList<>();


    for (int i = 0; i < cards.length; i++) {
      int idx = i;
      int cnt = 0;

      while (!visited[idx]) {
        visited[idx] = true;
        idx = cards[idx] - 1;
        cnt++;
      }
      if (cnt > 0) {
        cntList.add(cnt);
      }
    }
    Collections.sort(cntList,Collections.reverseOrder());

    if (cntList.size() == 1) {
      return 0;
    }
    return  cntList.get(0) * cntList.get(1);

  }

  public static void main(String[] args) {

    int[] cards = new int[]{8,6,3,7,2,5,1,4};

    System.out.println(solution(cards));
  }

}
