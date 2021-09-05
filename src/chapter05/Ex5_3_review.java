package chapter05;

import java.util.Scanner;

/**
 * 5_3 일주일 뒤에 다시 풀어보기
 * Created by park on 2021/09/05.
 */
public class Ex5_3_review {
  private final static int[][] graph = new int[100][100];

  private static boolean dfs (int x, int y, int n, int m) {
    if (x < 0 || x >= n || y < 0 || y >= m) {
      return false;
    }

    if (graph[x][y] == 0) {
      graph[x][y] = 1;

      dfs(x +1, y,n,m);
      dfs(x -1, y,n,m);
      dfs(x, y+1,n,m);
      dfs(x, y-1,n,m);
      return true;
    } else {
      return false;
    }
  }


  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n , m, count = 0;

    n = sc.nextInt();
    m = sc.nextInt();

    sc.nextLine();

    //그래프 입력
    for (int i = 0; i < n; i++) {
      String str = sc.nextLine();
      for (int j =0; j < str.length(); j++) {
        graph[i][j] = str.charAt(j) - '0';
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j =0; j < m; j++) {
        if (dfs(i,j,n,m)) {
          count++;
        }
      }
    }

    System.out.println(count);
  }
}
