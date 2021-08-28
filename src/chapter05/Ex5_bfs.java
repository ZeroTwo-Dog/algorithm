package chapter05;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * BFS
 * Created by park on 2021/08/28.
 */
public class Ex5_bfs {
  public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

  private static void bfs(int start, boolean[] visited) {
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);
    visited[start] = true;

    while (!queue.isEmpty()) {
      int n = queue.poll();
      System.out.print(n + " ");
      for (int i = 0; i < graph.get(n).size(); i++) {
        int newQ = graph.get(n).get(i);

        if(!visited[newQ]) {
          queue.offer(graph.get(n).get(i));
          visited[newQ] = true;
        }
      }
    }



  }


  public static void main(String[] args) {
    boolean[] visited = {
        false,false, false, false, false, false, false,false, false
    };

    // 그래프 초기화
    for (int i = 0; i < 9; i++) {
      graph.add(new ArrayList<Integer>());
    }

    // 노드 1에 연결된 노드 정보 저장
    graph.get(1).add(2);
    graph.get(1).add(3);
    graph.get(1).add(8);

    // 노드 2에 연결된 노드 정보 저장
    graph.get(2).add(1);
    graph.get(2).add(7);

    // 노드 3에 연결된 노드 정보 저장
    graph.get(3).add(1);
    graph.get(3).add(4);
    graph.get(3).add(5);

    // 노드 4에 연결된 노드 정보 저장
    graph.get(4).add(3);
    graph.get(4).add(5);

    // 노드 5에 연결된 노드 정보 저장
    graph.get(5).add(3);
    graph.get(5).add(4);

    // 노드 6에 연결된 노드 정보 저장
    graph.get(6).add(7);

    // 노드 7에 연결된 노드 정보 저장
    graph.get(7).add(2);
    graph.get(7).add(6);
    graph.get(7).add(8);

    // 노드 8에 연결된 노드 정보 저장
    graph.get(8).add(1);
    graph.get(8).add(7);

    bfs(1, visited);
  }
}
