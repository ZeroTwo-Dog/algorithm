package chapter09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 전보 문제
 * Created by park on 2021/11/13.
 */
public class Ex9_5 {
  
  public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();

  public static boolean[] visited = new boolean[100001];
  public static int[] d = new int[10001];


  public static int n, m, start;

  public static int cityCount = 0;


  //다익스트라 알고리즘
  public static void calVisitCityAndDistance() {
    PriorityQueue<Node> pq = new PriorityQueue<>();

    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node node = pq.poll();
      int now = node.getIndex(); // 현재 노드

      if (visited[now] && now != start) continue;
      visited[now] = true;

      //시작 도시 제외한 도착한 도시 갯수
      if (now != start) {
        cityCount++;
      }

      for (int i =0; i < graph.get(now).size(); i++) {
        int cost = graph.get(now).get(i).getDistance();
        int index = graph.get(now).get(i).getIndex();
        //내가 다녀온 길 + 현재 갈길
        d[index] = d[now] + cost;
        pq.offer(new Node(index, cost));

      }


    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);



    //첫줄 도시 , 통로, 출발 도시
    n = scan.nextInt();
    m = scan.nextInt();
    start = scan.nextInt();

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<Node>());
    }

    //간선 지정
    for(int i = 0; i < m; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      int z = scan.nextInt();
      graph.get(x).add(new Node(y, z));
    }

    calVisitCityAndDistance();

    System.out.println(cityCount+ " , " +Arrays.stream(d).max().getAsInt());


  }

}
