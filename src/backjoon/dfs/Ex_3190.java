package backjoon.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 뱀
 * 백준 3190
 * Created by park on 2022/02/26.
 */
public class Ex_3190 {

  static class Snake implements Comparable <Snake>{
    int x;
    int y;
    int num;

    Snake (int x, int y ,int num) {
      this.x = x;
      this.y = y;
      this. num = num;
    }

    @Override
    public int compareTo(Snake o) {
      return Integer.compare(this.num, o.num);
    }
  }

  public static List<Snake> snakeList = new ArrayList<>();



  public static int n = 2;
  public static int[][] graph = new int[100][100];

  public static boolean[][] apples = new boolean[100][100];


  public static int dir = 4;

  //
  public final static int RIGHT = 4;
  public final static int LEFT = 3;
  public final static int UP = 1;
  public final static int DOWN = 2;

  //경과 시간
  public static int time = 0;


  // 뱀 전진
  public static void snakeMove(int x, int y, boolean start, Map<Integer, String> directionMap) {

    //초기에 1,1 에서는 꼬리 만나도 그만두면 안됨
    if (!start) {
      //그만두는 조건
      if (!breakSnake(x, y)) {
        return;
      }
      ++time;
    }

    //방향전환
    selectSnakeDir(directionMap);


    Snake min = snakeList.stream().min(Snake::compareTo).get();
    int max = snakeList.stream().min(Snake::compareTo).get().num;

    if (dir == RIGHT) {
      snakeList.add(new Snake(x,y+1,max+1));
      //사과를 안만을때
      if (!breakContackSnake(x,y+1)) {
        return ;
      }
      checkAppleEat(x,y,min);
      snakeMove(x,y+1,false,directionMap);
    } else if (dir == LEFT) {
      snakeList.add(new Snake(x,y-1,max+1));
      if (!breakContackSnake(x,y-1)) {
        return ;
      }
      checkAppleEat(x,y,min);
      snakeMove(x,y-1,false,directionMap);
    } else if (dir == UP) {
      snakeList.add(new Snake(x-1,y,max+1));
      if (!breakContackSnake(x-1,y)) {
        return ;
      }
      checkAppleEat(x,y,min);
      snakeMove(x-1,y,false,directionMap);
    } else if (dir == DOWN){
      snakeList.add(new Snake(x+1,y,max+1));
      if (!breakContackSnake(x+1,y)) {
        return ;
      }
      checkAppleEat(x,y,min);
      snakeMove(x+1,y,false,directionMap);
    }

  }

  public static void checkAppleEat(int x, int y , Snake snake) {
    //사과를 안만을때
    if (!apples[x][y]) {
      snakeList.remove(snake);
    } else {
      apples[x][y] =false;
    }
  }

  //뱀 방향 변화조건
  public static void selectSnakeDir (Map<Integer, String> directionMap) {
    for (Map.Entry<Integer, String> map : directionMap.entrySet()) {
      if (time == map.getKey()) {
        if (map.getValue().equals(" D")) {
          if (dir == RIGHT) {
            dir = DOWN;
          } else if (dir == DOWN) {
            dir = LEFT;
          } else if (dir == LEFT) {
            dir = UP;
          } else {
            dir = RIGHT;
          }
        } else {
          if (dir == RIGHT) {
            dir = UP;
          } else if (dir == UP) {
            dir = LEFT;
          } else if (dir == LEFT) {
            dir = DOWN;
          } else {
            dir = RIGHT;
          }
        }
      }
    }
  }


  //멈추는 조건
  public static boolean breakSnake (int x, int y) {
    if (!breakXy(x,y)) {
      return false;
    }

    return breakContackSnake(x, y);

  }

  public static boolean breakXy (int x, int y) {
    if ( x <= 0 || x > n || y <= 0 || y > n) {
      time++;
      return false;
    }
    return true;
  }

  public static boolean breakContackSnake(int x, int y) {
    for ( int i = 0; i < snakeList.size(); i++ ) {
      if (i < snakeList.size() - 1) {
        if (snakeList.get(i).x == x && snakeList.get(i).y == y) {
          time++;
          return false;
        }
      }
    }
    return true;
  }



  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    n = scan.nextInt();

    //사과 갯수
    int k = scan.nextInt();


    //사과 위치 지정
    for (int i = 0; i < k; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      apples[x][y] = true;
    }

    //방향전환
    int l = scan.nextInt();
    Map<Integer, String> directionMap = new HashMap<>();
    for (int i = 0; i < l; i++) {
      int key = scan.nextInt();
      String value = scan.nextLine();
      directionMap.put(key, value);
    }

    // 키로 정렬
    Object[] mapkey = directionMap.keySet().toArray();
    Arrays.sort(mapkey);

    snakeList.add(new Snake(1,1, 1));


    snakeMove(1, 1,true,directionMap);

    System.out.println(time);
  }

}
