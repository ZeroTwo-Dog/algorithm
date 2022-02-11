package backjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 연구소 (DFS, BFS)
 * Created by park on 2022/02/11.
 */
public class Ex_14502 {

  static class Xy {
    int x;
    int y;

    public Xy() {}
    public Xy(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  final static int NORMAL = 0;
  final static int WALL = 1;
  final static int VIRUS = 2;

  static int n;
  static int m;

  static int[][] map;

  static int[] dx = {-1, 1, 0, 0};
  static int[] dy = {0, 0, -1, 1};

  static int result = 0;

  // 벽세우기
  public static void dfs(int cnt) {
    if (cnt == 3) {
      bfs();
      return;
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (map[i][j] == NORMAL) {
          map[i][j] = WALL;
          dfs(cnt + 1);
          map[i][j] = NORMAL;
        }
      }
    }
  }

  public static void bfs() {
    int[][] virusMap = new int[n][m];
    Queue<Xy> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        virusMap[i][j] = map[i][j];
      }
    }

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (virusMap[i][j] == VIRUS) {
          queue.add(new Xy(i,j));
        }
      }
    }

    while (!queue.isEmpty()) {
      Xy xy = queue.poll();

      for (int i = 0; i < dx.length; i++) {
        int x = xy.x + dx[i];
        int y = xy.y + dy[i];
        if ( x >= 0 && x < n && y >= 0 && y < m) {

          if (virusMap[x][y] == NORMAL) {
            virusMap[x][y] = VIRUS;
            queue.add(new Xy(x, y));
          }
        }

      }
    }
    result (virusMap);


  }

  public static void result (int[][] virusMap) {

    int cnt = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (virusMap[i][j] == NORMAL) {
          cnt++;
        }
      }
    }

    result = Math.max(cnt, result);
  }


  // 2채우기


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);


      n = scan.nextInt();


      m = scan.nextInt();


    map = new int[n][m];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        map[i][j] = scan.nextInt();
      }
    }

    dfs(0);

    System.out.println(result);

  }

}
