package chapter04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by park on 2021/08/19.
 */
public class Ex4_1 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = 1, y = 1, n;
    Map<String, Integer> moveXY = new HashMap<>();
    moveXY.put("R", 1);
    moveXY.put("L", -1);
    moveXY.put("U", -1);
    moveXY.put("D", 1);

    //n
    n = scan.nextInt();


    String[] move;

    int i = 0;
    scan.nextLine(); // 버퍼 비우기
    move = scan.nextLine().split(" ");


    for (String m : move) {
      // 좌우 이동
      if (m.equals("R") || m.equals("L")) {
        //영역밖으로 나갈때 체크
        if ((moveXY.get(m)+y) < 1 || (moveXY.get(m)+y) > n)
          continue;
        y +=moveXY.get(m);
      }
      // 상하 이동
      if (m.equals("U") || m.equals("D")) {
        //영역밖으로 나갈때 체크
        if ((moveXY.get(m)+x) < 1 || (moveXY.get(m)+x) > n)
          continue;
        x +=moveXY.get(m);

      }

    }
    System.out.println(x + "," +y);
  }

}
