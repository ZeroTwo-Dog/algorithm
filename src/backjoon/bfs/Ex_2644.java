package backjoon.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 촌수계산 (BFS)
 * Created by park on 2022/05/07.
 */
public class Ex_2644 {


  static int[] result = new int[101];


  static void bfs(int[][] graph, int start, int end) {
    Queue<Integer> queue = new LinkedList<>();

    queue.add(start);

    while (!queue.isEmpty()) {
      int n = queue.poll();

      if (n == end ) {
        break;
      }


      for (int i=0; i< graph[n].length; i++) {
        //방문하지 않았고, 관계까 있는 부분만 체크
        if (graph[n][i]== 1 && result[i] == 0) {
          queue.add(i);
          result[i] = result[n] +1;
        }
      }

    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // 총사람
    int n = scan.nextInt();

    int[][] graph = new int[n+1][n+1];

    //찾는 사람
    int start = scan.nextInt();
    int end = scan.nextInt();

    //관계
    int rel = scan.nextInt();

    for (int i = 0;  i < rel; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();

      graph[y][x] = 1;
      graph[x][y] = 1;


    }

    bfs(graph, start, end);

    if (result[end] == 0) {
      System.out.println(-1);
    } else {
      System.out.println(result[end]);
    }






  }

}
