import java.util.*;

public class P_Ex_1844 {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};
    public static boolean[][] visisted;

    static class Pair {
        private int x;
        private int y;
        private int cost;

        public Pair(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

    }

    public static int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        visisted =  new boolean[n][m];


        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0, 1));
        visisted[0][0] = true;
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            int x = poll.getX();
            int y = poll.getY();

            if (x == n-1 && y == m-1) {
                return poll.cost;
            }

            for (int i =0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx <0 || ny < 0 || nx >= m || ny >= n) {
                    continue;
                }

                if (maps[nx][ny] == 1 && !visisted[nx][ny]) {
                    visisted[nx][ny]= true;
                    queue.offer(new Pair(nx, ny ,poll.cost + 1));
                }
            }

        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}}));

    }
}
