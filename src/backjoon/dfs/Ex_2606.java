package backjoon.dfs;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 바이러스
 * Created by park on 2022/03/03.
 */
public class Ex_2606 {


  public static void dfs(int[][] graphs,int start, boolean[] visited) {

    //방문시 true
    visited[start] = true;
    for (int i = 0; i < graphs[start].length; i++) {
      if (graphs[start][i] == 1) {
        if(!visited[i]) {
          dfs(graphs, i, visited);
        }
      }

    }
  }

// bfs
//  public static void bfs(int i,int[][] graphs,boolean[] visited) {
//    Queue<Integer> q = new LinkedList<Integer>();
//    q.offer(i);
//    visited[i] = true;
//    while(!q.isEmpty()) {
//      int temp = q.poll();
//
//      for(int k=1; k<=graphs.length; k++) {
//        if(graphs[temp][k] == 1 && !visited[k]) {
//          q.offer(k);
//          visited[k] = true;
//        }
//      }
//    }
//  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();

    int[][] graphs = new int[n+1][n+1];
    boolean[] visited = new boolean[n+1];
    for (int i = 0; i < m; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      //양방향하기위해서
      //FIXME: 배열말고 링크드 리스트 생각해봐야할듯...
      graphs[a][b]  = 1;
      graphs[b][a]  = 1;
    }


    dfs(graphs,1, visited);
    int cnt = 0;
    for (boolean t: visited) {
      if (t) {
        cnt++;
      }
    }
    if (cnt == 1) {
      System.out.println(0);
    } else {
      System.out.println(cnt-1);
    }


  }
}
