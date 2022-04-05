package backjoon.sort;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 단어정렬
 * Created by park on 2022/04/05.
 */
public class Ex_1181 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    String[] list = new String[n];

    for (int i = 0; i < n; i++) {
      list[i] = scan.next();
      scan.nextLine();
    }
    sort(list);

    List<List<String>> listResult = new ArrayList<>();
    //길이로 정렬 제한 50
    for (int i = 1; i <= 50; i++){
      List<String> l = new ArrayList<>();
      for (int j = 0; j < n; j++) {
        if (list[j].length() == i) {
          l.add(list[j]);
        }
      }
      if (l.size() != 0) {
        //중복제거
        l = l.stream().distinct().collect(Collectors.toList());
        listResult.add(l);
        Collections.sort(listResult.get(listResult.size()-1));
      }

    }

    for (List<String> strings : listResult) {
      for (String string : strings) {
        System.out.println(string);
      }
    }
 }
}