package chapter05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * bfs - 미로찾기
 * Created by park on 2021/09/05.
 */
public class Ex5_4 {
  private final static int[][] graph = new int[200][200];
  private static int count = 0;

  private static void bfs(int n, int m) {
    Queue<int[]> queue = new LinkedList<>();
    //초기 위치 세팅
    int[] yx = new int[]{1, 1};
    queue.offer(yx);

    while (!queue.isEmpty()) {
      int[] p = queue.poll();
      count++;
      //도착시 종료
      if (p[0] == n &&  p[1] == m)
        break;

      //하우상좌 순으로 돌림 (우선순위대로 if 진행 항상 우측하단 이기때문에)
      //일주일뒤 복습 필요 (if else 부분이 수정되어야할것같고, 객체 지향으로 변경해야할 것같다.)
      if (graph[(p[0] + 1)][p[1]] == 1) {
        graph[(p[0] + 1)][p[1]] =0;
        p[0]++;
        queue.offer(p);
      } else if (graph[p[0]][(p[1] + 1)] == 1) {
        graph[p[0]][(p[1] + 1)] = 0;
        p[1]++;
        queue.offer(p);
      } else if (graph[(p[0] - 1)][p[1]] == 1) {
        graph[(p[0] - 1)][p[1]] = 0;
        p[0]--;
        queue.offer(p);
      } else {
        graph[p[0]][(p[1] - 1)] = 0;
        p[1]--;
        queue.offer(p);
      }
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n, m;

    n = sc.nextInt();
    m = sc.nextInt();

    sc.nextLine();

    for (int i = 1; i <= n; i ++) {
      String str = sc.nextLine();
      for (int j = 1; j <= str.length(); j++) {
        graph[i][j] = str.charAt(j-1) - '0';
      }
    }
    bfs(n, m);
    System.out.println(count);

  }
}
