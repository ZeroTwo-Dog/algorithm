package chapter08;

/**
 * 파보나치 수열
 * Created by park on 2021/10/06.
 */
public class Ex8_0 {

  final static int[] arr = new int[99];
  public static int pibo(int x) {
    if(x == 1 || x == 2) {
      return 1;
    }
    if (arr[x] != 0) {
      return arr[x];
    }
    // 정적으로 코드를 실행 하기때문에 앞에 pibo함수를 x=1까지 실행하고 뒤에 pibo를 실행함
    arr[x] = pibo(x-1) + pibo(x-2);
    return arr[x];
  }
  public static void main(String[] args) {

    System.out.println(pibo(6));
  }

}
