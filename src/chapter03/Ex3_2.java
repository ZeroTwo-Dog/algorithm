package chapter03;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 큰 수의 법칙
 * Created by park on 2021/08/15.
 */
public class Ex3_2 {

  public static void main(String[] args) {

    Scanner nextInt = new Scanner(System.in);
    int n, m ,k, sum = 0;


    // 조건에 맞는 n m k 정 수입력
    do {
      n = nextInt.nextInt();
    } while (2 >= n  || n >= 1000);
     do {
      m = nextInt.nextInt();
    } while (1 >= m  || m >= 10000);
     do {
      k = nextInt.nextInt();
    } while (1 >= k  || k >= 10000);

     //정수배열 초기화
    int[] data = new int[6];

    //n번 만큼 정수 입력
    for (int i = 0; i < n; i++ ) {
      data[i] = nextInt.nextInt();
    }
    //정수 정렬 (작은수부터 큰수)
    data = Arrays.stream(data).sorted().toArray();

    //가장 큰 수와 그 다음 수가 계속 더해짐 <--- 이게 핵심
    int first = data[data.length-1];
    int second = data[data.length-2];

    //m번을 큰 수 k번 초과로 더할 수 없게 진행
    int j = 0;
    while (j != m) {
      if (j % k != 0) {
        sum += first;
      } else {
        sum += second;
      }
      j++;
    }
//    문제풀이 정답  반복문을 안돌려서 이렇게 가능한 것 같은데 이렇게 생각못할 것 같다....
//    가장 큰 수가 더해지는 횟수 계산
//    (k + 1) 은 큰 수를 k 초과라서 +1 한듯
//    int cnt = (m / (k + 1)) * k;
//    cnt += m % (k + 1);
//
//    int result = 0;
//    result += cnt * first; // 가장 큰 수 더하기
//    result += (m - cnt) * second; // 두 번째로 큰 수 더하기

    System.out.println(sum);



  }

}
