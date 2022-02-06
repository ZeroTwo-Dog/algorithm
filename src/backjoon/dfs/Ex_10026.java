package backjoon.dfs;

import java.util.Scanner;

/**
 * 적록색약
 * Created by park on 2022/02/06.
 */
public class Ex_10026 {

  public static boolean normalDfs(int x, int y, String[][] graphs, boolean[][] visited, int n, String color) {
    if ( x < 0 || x >= n || y < 0 || y >= n)
      return false;

    if (!visited[x][y]) {
      visited[x][y] = true;
      if (graphs[x][y].equals(color)) {
        normalDfs(x, y + 1, graphs, visited, n, color);
        normalDfs(x + 1, y, graphs, visited, n, color);
        normalDfs(x - 1, y, graphs, visited, n, color);
        normalDfs(x, y - 1, graphs, visited, n, color);
        return true;
      } else {
        return false;
      }
    } else {
      return false;
    }
  }


  public static boolean[][] init (boolean[][] visited , int n){
    for (int i = 0; i < n; ++i) {
      for (int j =0; j < n; j++) {
        visited[i][j]=false;
      }
    }
    return visited;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    boolean[][] visited = new boolean[n][n];
    String[] colors = {"R" ,"G", "B"};
    String[][] graphs = new String[n][n];

    scan.nextLine();
    //입력
    //그래프 입력
    for (int i = 0; i < n; ++i) {
      String str = scan.nextLine();
      for (int j =0; j < str.length(); j++) {
        graphs[i][j] = String.valueOf(str.charAt(j));
        visited[i][j]=false;
      }
    }


    int nonBlockCnt = 0;
    int normalBlockCnt = 0;

    //노색맹
    for (String color : colors) {
      visited = init(visited,n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          boolean normalDfs = normalDfs(i, j, graphs, visited, n, color);
          boolean nonDfs = normalDfs(i, j, graphs, visited, n, color.equals("G") ? "R" : color);

          if (normalDfs)
            normalBlockCnt++;

          if (nonDfs)
            nonBlockCnt++;
        }
      }
    }

    //색맹처리
    for (int i = 0; i < n; ++i) {
      for (int j =0; j < n; j++) {
        if (graphs[i][j].equals("G")) {
          graphs[i][j] = "R";
        }
     }
    }


    //색맹
    for (String color : colors) {
      visited = init(visited,n);
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          boolean nonDfs = normalDfs(i, j, graphs, visited, n,   color);
          if (nonDfs)
            nonBlockCnt++;
        }
      }
    }

    System.out.println(normalBlockCnt+" " +nonBlockCnt);
  }

}
