package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 짝지어제거
 * Created by park on 2022/11/16.
 */
public class P_ex_12973 {
  public static int solution(String s) {
    Stack<Character> stack = new Stack<>();

    for(char c : s.toCharArray())
      //비어있지않고, 다음값과 같다면 pop
      if(!stack.isEmpty() && stack.peek() == c) stack.pop();
      //비어있거나, 다음값과 같지않다면 Push
      else stack.push(c);

    return stack.isEmpty() ? 1 : 0;
  }





  public static void main(String[] args) {
    System.out.println(solution("aabb"));

  }

}
