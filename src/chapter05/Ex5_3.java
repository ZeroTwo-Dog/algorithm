package chapter05;

import java.util.Scanner;

/**
 * 음료수 열러먹기
 * Created by park on 2021/08/29.
 */
public class Ex5_3 {

  private final static int[][] graph = new int[100][100];

  public static boolean dfs (int x, int y, int n , int m) {

    if ( x < 0 || x >= n || y < 0 || y >= m)
      return false;

    if (graph[x][y] == 0) {
      // 해당 노드 방문 처리
      graph[x][y] = 1;
      //상하좌우
      dfs(x - 1 ,y, n, m);
      dfs(x ,y - 1, n, m);
      dfs(x  ,y + 1, n, m);
      dfs(x + 1 ,y, n, m);
      return true;
    } else
      return false;

  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n, m, count = 0;

    n = sc.nextInt();
    m = sc.nextInt();
    sc.nextLine(); // 버퍼 지우기

//    띄어쓰기 없이 입력하는 부분은 아스키코드로 빼는거 인지 해야함!!!
//    for (int i = 0; i < n; i++) {
//      for (int j = 0; j < m; j++) {
//        graph[i][j] = sc.nextInt();
//      }
//    }
    // 2차원 리스트의 맵 정보 입력 받기
    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j = 0; j < m; j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }

    //아이스크림 전체틀 작성
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        boolean dfsResult = dfs(i,j, n, m);
        if (dfsResult)
          count++;
      }
    }
    System.out.println(count);
  }
}
