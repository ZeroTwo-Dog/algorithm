package chapter12;

/**
 * Created by park on 2022/04/17.
 */
public class Ex12_6 {

  static final int PILLAR = 0;
  static final int BEAM = 1;
  static final int DESTRUCT = 0;
  static final int CONSTRUCT = 1;

  static boolean[][] pillars, beams; // 기둥, 보

  public static void main(String[] args) {
    int n = 5;

//    int[][] build_frame = build_frame = new int[][]
//        {
//            {1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}
//        };
    int[][] build_frame = build_frame = new int[][]
        {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
    solution(n, build_frame);

  }

  public static int[][] solution(int n, int[][] build_frame) {
    int count = 0;

    beams = new boolean[n+1][n+1];
    pillars = new boolean[n+1][n+1];

    for (int i = 0; i < build_frame.length; i ++) {
      int x = build_frame[i][0];
      int y = build_frame[i][1];
      //dir 0 기둥 (바닥이나 기둥위에)/ 보 1 (양쪽이 보에 연결되어있거나 한쪽이 기둥에 연결되여야함)
      int type = build_frame[i][2];
      //way 0 삭제 / 1 추가 <- dir 에 대한거 고려해야함
      int way = build_frame[i][3];

      if (PILLAR == type) {
        if (CONSTRUCT == way) {
          //기둥 추가
          if (checkPillar(x,y)) {
            pillars[x][y] = true;
            count++;
          }
        } else {
          //기둥삭제
          pillars[x][y] = false;
          if (!canDelete(n)) pillars[x][y] = true;
          else count--;
        }

      } else {
        if (CONSTRUCT == way) {
          //보 추가
          if (checkBar(x,y)) {
            beams[x][y] = true;
            count++;
          }

        } else {
          //보삭제
          beams[x][y] = false;
          if (!canDelete(n)) beams[x][y] = true;
          else count--;
        }

      }
    }

    int[][] result = new int[count][3];
    int idx = 0;
    for(int i = 0; i <= n; i++) {
      for(int j = 0; j <= n; j++) {
        if(pillars[i][j]) {
          result[idx][0] = i;
          result[idx][1] = j;
          result[idx++][2] = 0;
        }
        if(beams[i][j]) {
          result[idx][0] = i;
          result[idx][1] = j;
          result[idx++][2] = 1;
        }
      }
    }
    return result;


  }

  public static boolean canDelete(int n) {
    for(int i = 0; i <= n; i++) {
      for(int j = 0; j <= n; j++) {
        if(pillars[i][j] && checkPillar(i, j) == false)  return false; // 기둥이 해당 위치에 있을 수 없다면 false
        else if(beams[i][j] && checkBar(i, j) == false) return false; // 바닥이 해당 위치에 있을 수 없다면 false
      }
    }
    return true;
  }

  public static boolean checkPillar(int x, int y) {
    if(y == 0) return true; //바닥에 설치하는 경우
    else if(y > 0 && pillars[x][y - 1]) return true; //아래 기둥이 있는 경우
    else if(x > 0 && beams[x - 1][y] || beams[x][y]) return true;
    return false;
  }

  public static boolean checkBar(int x, int y) {
    if(y > 0 && pillars[x][y - 1] || pillars[x + 1][y - 1]) return true; // 한쪽 끝에 기둥이 있는 경우
    else if(x > 0 && beams[x - 1][y] && beams[x + 1][y]) return true; //양쪽 끝이 보와 동시에 연결되어 있는 경우
    return false;
  }
}
