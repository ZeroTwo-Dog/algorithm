package backjoon;


/**
 * Created by park on 2022/11/02.
 */
public class Codility_OddOccurrencesInArray {

  public static void main(String[] args) {

    int[] A = {1};

    int result=0;
    for (int j : A) {
      //XOR 연산자로 중복체크
      result ^= j;
    }

    System.out.println(result);
  }

}
