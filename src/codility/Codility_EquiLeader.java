package codility;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * Created by park on 2022/11/01.
 */
public class Codility_EquiLeader {
  public static int solution(int[] A) {

    int leader = 0;
    int resultCnt  = 0;
    Map<Integer, Integer> totalMap = new HashMap<>();

    int maxLeaderCnt = 0;
    //리더 숫자 추출
    for (int a : A ) {
      Integer key = a;
      if (totalMap.containsKey(key)) {
        int count = totalMap.get(key);
        count++;
        totalMap.put(a, count);
      } else {
        totalMap.put(key, 1);
      }
      // 가장 많이 나온 수 (Leader)를 기록한다.
      if(maxLeaderCnt < totalMap.get(a)) {
        maxLeaderCnt = totalMap.get(a);
        leader = a;
      }

    }



    int leaderTotalCnt = totalMap.get(leader);
    Map<Integer, Integer> firstMap = new HashMap<>();
    for (int i=0; i < A.length; i++) {
      Integer key = A[i];
      if (firstMap.containsKey(key)) {
        int count = firstMap.get(key);
        count++;
        firstMap.put(A[i], count);
      } else {
        firstMap.put(key, 1);
      }

      if (firstMap.containsKey(leader)) {

        int leaderCurrentCnt = firstMap.get(leader);

        //리더갯수 기준으로 앞라인 둿라인 짤라서 계산
        if (leaderCurrentCnt> (i+1)/2 && (leaderTotalCnt - leaderCurrentCnt)>((A.length-i-1)/2)) {
          resultCnt++;
        }
      }


    }

    return resultCnt;
  }



  public static void main(String[] args) {


    int[] test = {4,3,4,4,4,2};
    int[] testA = {5,6,8,9,10};
    System.out.println(solution(test));

  }

}
