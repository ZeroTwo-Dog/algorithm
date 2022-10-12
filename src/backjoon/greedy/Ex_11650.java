package backjoon.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 좌표 정렬
 * Created by park on 2022/10/12.
 */
public class Ex_11650 {
  public static class Xy {
    int x;
    int y;

    public Xy () {}
    public Xy (int x, int y ) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();


    int[] x = new int[n];
    int[] y = new int[n];

    List<Xy> list = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      x[i] = scan.nextInt();
      y[i] = scan.nextInt();
      list.add(new Xy(x[i], y[i]));
    }

    List<Xy> sortedList = list.stream()
        .sorted(Comparator.comparing(Xy::getX).thenComparing(Comparator.comparing(Xy::getY)))
        .collect(
            Collectors.toList());

    for (Xy xy: sortedList){
      System.out.println(xy.getX() + " " + xy.getY());
    }

  }

}
