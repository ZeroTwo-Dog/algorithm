package chapter06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * 성적 오름차순
 * Created by park on 2021/09/18.
 */
public class Ex6_2 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    Map<String , Integer> student = new HashMap<>();

    for (int i = 0; i < n; i++) {
      String key = scan.next();
      Integer value = scan.nextInt();
      student.put(key, value);
    }

    List<Map.Entry<String , Integer>> maps = new ArrayList<>(student.entrySet());
//    maps.sort(Entry.comparingByValue());
//    maps.sort(Entry.comparingByKey());
    //람다 stream 이용 람다에 익숙해져야료
    maps.stream().sorted(Entry.comparingByValue()).forEach(o -> System.out.println(o.getValue()));
    maps.forEach(System.out::println);
  }

}
