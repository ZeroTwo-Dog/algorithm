package progammers;

/**
 * N개의 최소공배수
 * Created by park on 2022/12/10
 */
public class P_ex_12953 {

  public static int solution(int[] arr) {
    int answer = 1;

    if(arr.length == 1) return arr[0];

    for(int i = 1; i < arr.length; i++) {
      int g = gcd(answer, arr[i]);
      // 모든곱한값 / 최대공약수 = 최소공배수
      answer = (answer * arr[i]) / g;
    }

    return answer;

  }

  //최대 공약수 (유클리드 기법)
  private static int gcd(int a, int b) {
    int r = a % b;
    if(r == 0) return b;
    else return gcd(b, r);
  }

  public static void main(String[] args) {
    System.out.println(solution(new int[]{2,6,8,14}));

  }

}
