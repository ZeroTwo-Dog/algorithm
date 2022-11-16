package progammers;

import java.util.*;

/**
 * 거리두기 확인
 * Created by park on 2022/11/14.
 */
public class P_ex_81302 {


  static int[] dx = {0,0,1,-1};
  static int[] dy = {1,-1,0,0};

  public static int[] solution(String[][] places) {

    int[] answers = new int[5];
    for (int i = 0; i < places.length; i++) {
      boolean flag = true;
      String[] map = places[i];
      for (int j = 0; j < places.length; j++) {
        for (int k = 0; k < map[i].length(); k++) {
          if (map[j].charAt(k) == 'P') {
            if (!bfs(map, j, k)) {
              flag = false;
              break;

            }
          }


        }
        if (flag) {
          answers[i] = 1;
        } else {
          answers[i] = 0;
        }
      }

    }
    return answers;
  }

  public static boolean bfs (String[] map, int x, int y) {
    boolean[][] visited = new boolean[5][5];

    Queue<Node> queue = new LinkedList<>();
    queue.add(new Node(x,y));
    visited[x][y] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = current.x + dx[i];
        int ny = current.y + dy[i];
        //P 기준점 으로 맨하탄 거리 2측정
        int manhattan = Math.abs(x- nx) + Math.abs(y - ny);

        if (nx < 0 || ny < 0 || ny >= map.length || nx >=map.length) continue;
        if (manhattan > 2 || visited[nx][ny] ) continue;

        visited[nx][ny] = true;
        if (map[nx].charAt(ny) == 'X') continue;
        //맨하탄 거리가 2이하일때 P일때 실패 (X일때는 이미 위에서 처리)
        else if (map[nx].charAt(ny) == 'P') return false;
        else queue.offer(new Node(nx,ny));


      }
    }
    return true;
  }
  public static class Node {
    int x;
    int y;


    public Node(int x, int y ) {
      this.x = x;
      this.y = y;
    }


  }

  public static void main(String[] args) {

    String[][] places = new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

    System.out.println(Arrays.toString(solution(places)));
  }

}
