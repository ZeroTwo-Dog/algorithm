package backjoon.dfs;

import java.util.Scanner;

/**
 * Ex_1102_유기농 배추
 * Created by park on 2022/10/08.
 */
public class Ex_1012 {



  public static void dfs (int[][] graphs, boolean[][] visited, int startX, int startY, int m, int n) {

    if (graphs[startX][startY] == 1 && !visited[startX][startY]) {
      visited[startX][startY] = true;

        //우
      if (startX + 1 < m)
        dfs(graphs, visited, startX + 1, startY, m, n);
      //좌
      if (startX - 1 >= 0)
        dfs(graphs, visited, startX - 1, startY, m,n);
      //상
      if (startY + 1 < n)
        dfs(graphs, visited, startX, startY + 1, m,n);
      //하
      if (startY - 1 >= 0)
        dfs(graphs, visited, startX, startY - 1, m,n);
    }

  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    //테스트케이스
    int t = scan.nextInt();
    int[] count = new int[t];
    int[] plantCount = new int[t];




    //배추 위치 저장
    for (int k = 0; k < t; k++) {
      //가로
      int m = scan.nextInt();
      //새로
      int n = scan.nextInt();

      int[][] graphps = new int[m][n];

      boolean[][] visited = new boolean[m][n];
      //배추 갯수
      plantCount[k] = scan.nextInt();
      for (int i = 0; i < plantCount[k]; i++) {
        int x = scan.nextInt();
        int y = scan.nextInt();
          graphps[x][y] = 1;
      }

      for (int i = 0 ;  i < m; i++) {
        for (int j = 0; j < n; j++) {
          //방문하지 않았고, 배추가 있는곳에서 시작
          if (!visited[i][j] && graphps[i][j] == 1) {
            //dfs를 돌고 다시 실핼되는거면 아직 가보지 못한 지역
            count[k]++;
            dfs(graphps,visited, i,j,m,n);
          }
        }
      }


    }



    for (Integer c: count) {
      System.out.println(c);
    }

  }

}
