package chapter03;

import java.util.Scanner;


/**
 * Created by park
 * 2021-08-14
 */
public class Ex3_1 {

  public static void main(String[] args) {
    //잔돈입력
    Scanner sc = new Scanner(System.in);
    int data = sc.nextInt();
    //변수세팅
    //[] 배열 초기화 {}
    int[] coins = {500, 100, 50, 10};
    int count = 0;
    for (int coin : coins) {
      count += data / coin;
      data = data % coin;


    }
    System.out.println("총 동전 갯수: : " + count);

  }
}
