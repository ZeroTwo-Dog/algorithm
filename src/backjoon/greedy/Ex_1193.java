package backjoon.greedy;

import java.util.Scanner;

/**
 * 분수찾기 Ex_1193
 * Created by park on 2022/10/21.
 */
public class Ex_1193 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    int n = scanner.nextInt();
    int cnt = 1;

    int x = 1 , y = 1;
    int diffNum = 1;
    boolean loopTF = true;
    boolean xTurn = true;



    while (loopTF) {
      if (n == 1) {
        break;
      }
      int loopX = x;
      int loopY = y;

      for (int i=0; i < diffNum; i++) {
        if (cnt == n) {
          x = loopX;
          y = loopY;
          loopTF = false;
          break;
        }
        cnt++;
        //지그재어로 대각선 위아래 향하기
        if (!xTurn) {
          loopX++;
          loopY--;
        } else {
          loopX--;
          loopY++;
        }
      }

      //지그재그 순서 제어
      if (loopTF) {
        diffNum++;
        xTurn = !xTurn;
        if (!xTurn) {
          y = x;
          x = 1;
          y++;
        } else {
          x = y;
          y = 1;
          x++;
        }

      }



    }

    System.out.println(x+"/"+y);
  }

}
