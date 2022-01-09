package chapter11;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by park on 2022/01/01.
 */

class Foods {
  long time;

  long index;

  public Foods (long time, long index) {
    this.time = time;
    this.index = index;
  }

  public long getIndex() {
    return index;
  }

  public void setTime(long time) {
    this.time += time;
  }

  public Boolean isZero () {
    return this.time == 0;
  }
}


public class Ex11_6 {

  public static int solution(int[] food_times, long k) {
    long sumTime = 0;

    List<Foods> foods = new ArrayList<>();
    for (int i = 0; i < food_times.length; i++) {
      sumTime += food_times[i];
      foods.add(new Foods(food_times[i], (long) i + 1));

    }
    if (sumTime <= k) {
      return -1;
    }
    long sec = 1;
    int index = 0;
    //TODO: 효율성 0점 다중 반복문을 진행해서 그런거 같은데 다음번에 풀때 자료구조 부분 생각해서 풀어보기
    while (sec < k + 1) {
      while (true) {

        if (index >= foods.size()) {
          index = 0;
        }
        if (!foods.get(index).isZero()) {
          foods.get(index).setTime(-1);
          if (foods.get(index).isZero()) {
            for (Foods food : foods) {
              if (food.getIndex() == foods.get(index).getIndex()) {
                foods.remove(food);
                // time이 0 일때 List를 한건 제거 하므로 index -1
                index--;
                break;
              }
            }
          }
          index++;
          break;
        }
      }
      sec++;
    }

    if (index >= foods.size()) {
      index = 0;
    }

    return (int)foods.get(index).getIndex();
  }

  public static void main(String[] args) {
    int[] food_times = {3,1,5};
    long k = 5;
    System.out.println(solution(food_times, k));
  }

}
