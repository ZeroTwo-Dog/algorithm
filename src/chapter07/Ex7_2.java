package chapter07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 부품찾기 (이진탐색)
 * Created by park on 2021/10/03.
 */
public class Ex7_2 {

  public static boolean binarySearch(int[] parts, int target, int start, int end) {

    if (start > end) {
      return false;
    }

    int mid = (start+end)/2;

    if (parts[mid] == target) {
      return true;
    }

    if (parts[mid] > target) {
      return binarySearch(parts, target, start, mid-1);
    } else {
      return binarySearch(parts, target, mid+1, end);
    }
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    System.out.println("부품들 고유번호 입력");
    int[] parts = new int[n];
    for (int i = 0; i < n; i++) {
      parts[i] = scan.nextInt();
    }
    Arrays.sort(parts);

    int m = scan.nextInt();
    System.out.println("손님 원하는 부품 고유번호 입력");
    int[] orderParts = new int[n];
    for (int i = 0; i < m; i++) {
      orderParts[i] = scan.nextInt();
    }

    for (int i = 0; i < m; i++) {
      if(binarySearch(parts, orderParts[i],0, parts.length-1)) {
        System.out.print("yes ");
      } else {
        System.out.print("no ");
      }
    }

  }

}
