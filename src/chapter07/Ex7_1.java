package chapter07;

import java.util.Arrays;
import java.util.Collections;

/**
 * 이진탐색 기초 binarySearch
 * Created by park on 2021/09/22.
 */
public class Ex7_1 {
  public static boolean binarySearch (int start, int end, int[] arr, int target) {

    if (start > end) {
      return false;
    }

    //시작점과 끝점을 더하는 이유는 아래 재귀함수에 따라서 start,end점이 바뀌기때문에
    int mid =(end+start)/2;

    if (arr[mid] == target) {
      return true;
      //중간값이 목표값보다 큰 경우, end 값 줄이기
    } else if (arr[mid] > target) {
     return binarySearch(start, mid -1, arr, target);
    } else {
      //중간값이 목표 값 보다 작은경우, start 값 올리기
      return binarySearch(mid+1 , end, arr, target);
    }
  }

  public static void main(String[] args) {
    int[] arr = {1, 4, 5, 6, 8, 3, 2, 9, 7,10};
    //이진탐색 전제조건 정렬이 되어있어야한다.
    Arrays.sort(arr);
    boolean result = binarySearch(0,arr.length-1,arr, 3);
    if (result) {
      System.out.println("목표가 있습니다.");
    } else {
      System.out.println("목표가 없습니다.");
    }


  }
}