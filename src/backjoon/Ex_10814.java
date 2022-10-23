package backjoon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 나이순 정렬 Ex_10841
 * Created by park on 2022/10/23.
 */
public class Ex_10814 {

  public static class User {
    int age;
    String name;

    public User () {}
    public User (int age, String name) {
      this.age = age;
      this.name= name;
    }

    public int getAge() {
      return age;
    }

    public String getName() {
      return name;
    }
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    List<User> userList = new ArrayList<>();

    for (int i =0; i< n; i++) {
      int age = scan.nextInt();
      String name = scan.next();
      userList.add(new User(age, name));
    }

    //단순히 나이로만 정렬
    userList = userList.stream().sorted(Comparator.comparingInt(o -> o.age)).collect(Collectors.toList());


    for (User user : userList) {
      System.out.println(user.getAge()+" "+user.getName());
    }



  }

}
