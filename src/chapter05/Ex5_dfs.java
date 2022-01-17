package chapter05;

/**
 * DFS
 * Created by park on 2021/08/28.
 */
public class Ex5_dfs {

  public static void dfs (int[][] graph, int node, boolean[] visited) {
    //방문시 true
    visited[node] = true;
    System.out.print(node + " ");
    for (int i = 0; i < graph[node].length; i++) {
      int num = graph[node][i];

      //방문 하지 않았다면, 재귀로 진행
      //문제에서 순서를 지정해주면 하단 if에서 진행 해야할듯
      if(!visited[num]) {
        dfs(graph, num, visited);
      }
    }
  }

  public static void main(String[] args) {

  boolean[] visited = {
      false,false, false, false, false, false, false,false, false
  };
  int[][] graph = {
      {},
      {2,3,8},
      {1,7},
      {1,4,5},
      {3,5},
      {3,4},
      {7},
      {2,6,8},
      {1,7}
  };

  dfs(graph, 1, visited);
  }
}
