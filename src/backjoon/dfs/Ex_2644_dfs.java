package backjoon.dfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 촌수계산 (DFS)
 * Created by park on 2022/05/07.
 */
public class Ex_2644_dfs {


  static int result = 0;
  static boolean find = false;



  static void dfs(int[][] graph, int start, int end, boolean[] visited, int cnt) {
    visited[start] = true;

    //핵심
    //재귀함수 이기때문에 노드 끝지점과 마지막 cnt가 다름
    //우리가 필요한건 end지점의 노드 끝지점이므로 cnt가 end지점에서 리턴되면됨
    if(start == end) {
      find = true;
      result = cnt;
      return;
    }


    // 연결되 지점 저장
    for (int i=0; i< graph[start].length; i++) {

      if (graph[start][i]== 1 && !visited[i]) {
        visited[i] = true;
        dfs(graph, i, end, visited, cnt+1);
      }
    }
  }


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    // 총사람
    int n = scan.nextInt();

    int[][] graph = new int[n+1][n+1];
    boolean[] visited = new boolean[n+1];

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
    //cnt를 지역변수로 해서 보냄 위에서 설명
    dfs(graph,start,end,visited,0);

    if (!find) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }
    }






  }
