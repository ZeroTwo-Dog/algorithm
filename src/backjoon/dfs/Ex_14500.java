package backjoon.dfs;

import java.util.Scanner;

/**
 * Ex_145000 (테트로미노)
 * Created by park on 2022/10/16.
 */
public class Ex_14500 {

  private static final int[] dy = {0, 0, 1, -1};
  private static final int[] dx = {1, -1, 0, 0};

  private static int[][] map = new int[50][100];
  private static boolean[][] visited = new boolean[50][100];

  private static int n;
  private static int m;



  private static int maxValue = 0;


  public static void dfs (int x, int y, int cnt, int sum ) {

    if (cnt == 4) {
      maxValue = Math.max(maxValue, sum);
      return;
    }

    for (int i = 0; i < 4; i++) {
      int curX = x + dx[i];
      int curY = y + dy[i];
      //범위 밖일때 패스
      if (curX < 0 || curY < 0 || curX >= n || curY >= m) {
        continue;
      }


      if (!visited[curX][curY]) {
        //처음에 아래소스처럼 했다가 에러름 못찾았는데 if (cnt == 2) 에서 다시 돌아왔을때 아래 dfs에서 더한값으로 진행되서 4개가 아니라 5개가 max 되는현상 있는 에러잡움
//        sum += map[curX][curY];


        // 뻐큐 모양은 DFS로 할때 방향대로 한번에 가는게 아니라 가운데에서 펼쳐져야함
        // 그래서 가운데일때인 2번째에서 기준점으로 한번 펼치기
        if (cnt == 2) {
          visited[curX][curY] = true;
          dfs(x,y,cnt+1, sum + map[curX][curY]);
          visited[curX][curY] = false;
        }

        visited[curX][curY] = true;
        dfs(curX,curY,cnt+1, sum + map[curX][curY]);
        visited[curX][curY] = false;

      }
    }


  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();
    map = new int[n][m];
    visited = new boolean[n][m];


    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = scan.nextInt();
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        //완전 탐색을 해야되서 방문지를 중심점 중심으로 dfs 진행하고 다시 초기화
        visited[i][j] = true;
        dfs(i,j,1, map[i][j]);
        visited[i][j] = false;      }
    }

    System.out.println(maxValue);



  }

}
