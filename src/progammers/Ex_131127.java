package progammers;

import java.util.HashMap;
import java.util.Map;

/**
 * 할인행사
 * Created by park on 2022/11/13.
 */
public class Ex_131127 {

  public static int solution(String[] want, int[] number, String[] discount) {
    int answer = 0;

    int total = 0;
    Map<String, Integer> wantSet = new HashMap<>();
    for (int i = 0; i < want.length; i++) {
      wantSet.put(want[i], number[i]);
      total += number[i];
    }


    Map<String, Integer> discountSet = new HashMap<>();
    for (int i = 0; i < discount.length; i++) {

      if (discountSet.containsKey(discount[i])) {
        Integer discountCnt = discountSet.get(discount[i]);
        discountCnt++;
        discountSet.put(discount[i],discountCnt);
      } else {
        discountSet.put(discount[i],1);
      }

      //처음 10개
      if (i >= total-1) {
        //검증
        int size = 0;

        //비교
        for (String key: wantSet.keySet()) {
          if (discountSet.containsKey(key)) {
            if (discountSet.get(key).equals(wantSet.get(key))) {
              size++;
            } else {
              break;
            }
          }
        }
        if (size == want.length) {
          answer++;
        }


        Integer pastCnt = discountSet.get(discount[i - (total-1)]);
        pastCnt--;
        discountSet.put(discount[i - (total-1)],pastCnt);
      }


    }


    return answer;
  }

  public static void main(String[] args) {

    System.out.println(solution(new String[]{"banana", "apple", "rice", "pork", "pot"},
        new int[]{3, 2, 2, 2, 1},
        new String[]{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana",
            "pork", "rice", "pot", "banana", "apple", "banana"}));

  }

}
