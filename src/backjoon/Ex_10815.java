package backjoon;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 숫자 카드 Ex_10815
 * Created by park on 2022/10/18.
 */
public class Ex_10815 {
  public static int binarySearch(int start, int end, int[] cards, int target) {
    if (start > end) {
      return 0;
    }

    //시작점과 끝점을 더하는 이유는 아래 재귀함수에 따라서 start,end점이 바뀌기때문에
    int mid =(end+start)/2;

    if (cards[mid] == target) {
      return 1;
    }

    if (cards[mid] > target) {
      return binarySearch(start , mid-1 , cards,target);
    } else {
      return binarySearch(mid + 1 ,end , cards,target);

    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    int[] hasNums = new int[n];

    //상근이가 갖고있는 카드들
    for (int i = 0; i < n; i++) {
      hasNums[i] = scan.nextInt();
    }
    Arrays.sort(hasNums);

    int m = scan.nextInt();
    int[] results = new int[m];

    // 체크해야하는 카드들
    for (int i = 0; i < m; i++) {
      int predictNum = scan.nextInt();
      //문제에서 50만번 * 50만번이기때문에 시간초과 할거라고 예상하였고, 예상대로 틀렸고 이진탐색으로 전환
      results[i] = binarySearch(0, n-1, hasNums, predictNum);

    }

    for (Integer result: results) {
      System.out.print(result+" ");
    }

  }

}
