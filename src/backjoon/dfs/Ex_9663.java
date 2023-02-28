package backjoon.dfs;

import java.util.Scanner;

/**
 * N-Queen
 *
 * Created by park on 2023/02/13.
 */
public class Ex_9663 {

  public static int[] arr;
  public static int N;
  public static int count = 0;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    N = in.nextInt();
    arr = new int[N];

    nQueen(0);
    System.out.println(count);
  }


  public static void nQueen(int depth) {
    // 모든 원소를 다 채운 상태면 count 증가 및 return
    // depth 가 곧 놓은 퀸의 갯수.
    if (depth == N) {
      count++;
      return;
    }
    for (int i = 0; i < N; i++) {
      arr[depth] = i;
      // arr[0]은 곧 첫번째 열을 뜻한다. 0 1 2 3은 차례대로 첫번째부터 네번째까지의 행을 뜻한다.
      // nQueen(depth + 1); 상태면 arr[1]에 0,1,2,3 이 차례대로 대입된다.
      // 우선 arr[1]에 0이 대입되고 Possibility(depth) 이 실행된다. 이때 depth는 1 이다.

      // 여기서 노드의 유망성을 파악하여 백트랙킹 기법을 사용합니다.
      // 놓을 수 있는 위치일 경우 재귀호출을 하여 계속 dfs 실행
      if (Possibility(depth)) {
        nQueen(depth + 1);
      }
    }
  }
  public static boolean Possibility(int depth) {
    for (int i = 0; i < depth; i++) {
      // 첫번째 depth은 0이 들어와서 0<0 은 for문의 조건이 성립이 안되기 때문에 무조건 true가 반환된다.
      // 두번째 depth은 depth+1 상태이기 때문에 1이 들어온다.

      // 해당 열의 행과 i열의 행이 일치할경우 (같은 행에 존재할 경우)
      // arr[i] 의 경우 arr[depth]보다 이전의 열이다. for문이 계속 돌아감으로.
      // 이 이전의 열(arr[i])들이 현재의 열(arr[depth])과 동일한경우 false가 반환되고 탐색을 멈춘다.
      if (arr[depth] == arr[i]) {
        return false;
      }
      //Math.abs() -> 절대값을 반환하는 함수.
      //열의 차와 행의 차가 같을 경우 대각선에 놓여있다
      //위에 첨부한 그림을 통해서 이해 바람.
      else if (Math.abs(depth - i) == Math.abs(arr[depth] - arr[i])) {
        return false;
      }
    }
    return true;
  }

}
