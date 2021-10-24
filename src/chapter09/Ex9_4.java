package chapter09;

import java.util.Scanner;

/**
 * 미래도시 플로이드 워셜
 * Created by park on 2021/10/24.
 */
public class Ex9_4 {

  public final static int INF = (int) 1e9;

  public static int n = 0, m = 0;

  public final static int[][] graph = new int[501][501];


  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    //노드 간선 입력
    n = scan.nextInt();
    m = scan.nextInt();

    //간선 초기화
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= n; j++) {
        //자기 자신을 지나느 경우는 0 세팅
        if (i == j) {
          graph[i][j] = 0;
        } else {
          graph[i][j] = INF;
        }
      }
    }

    //간선입력
    for (int i = 0; i < m; i++) {
      int a = scan.nextInt();
      int b = scan.nextInt();
      graph[a][b] = 1;
    }

    //x, k 입력
    int x = scan.nextInt();
    int k = scan.nextInt();


    //플로이드 워셜 최단경로
    for(int p = 1;  p <= n; p++ ) {
      for (int a = 1; a <= n; a++ ) {
        for (int b = 1; b <= n; b++ ) {
          graph[a][b] = Math.min(graph[a][b], graph[p][a] + graph[p][b]);
        }
      }
    }

    //경유지
    int middle = graph[1][k];
    //경유지에서 도착지
    int destination = graph[k][x];

    if (middle == INF || destination == INF ) {
      System.out.println("-1");
    } else {
      System.out.println("최소경로: " +(middle+destination));
    }


  }

}
