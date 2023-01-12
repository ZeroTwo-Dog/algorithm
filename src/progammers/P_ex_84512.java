package progammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 모음사전
 * Created by park on 2022/11/16.
 */
public class P_ex_84512 {

  public static String[] vowels = {"A","E","I","O","U"};
  static List<String> list = new ArrayList<>();


  public static int solution(String word) {


    for (int i =1 ; i <= vowels.length; i++) {
      dfs(0,"",i);
    }

    //정렬하면 A->AA 순서대로 정렬
    Collections.sort(list);
    int answer = 0;

    for (String ans: list) {
      answer++;
      if (ans.equals(word)) {
        break;
      }
    }

    return answer;
  }


  //A -> UUUUU까지 전체 만들기
  public static void dfs (int dep, String str, int len ) {
    if(dep == len){
      list.add(str);
      return;
    }
    for(int i = 0; i<5;i++){
      dfs(dep+1,str+vowels[i],len);
    }
  }

  public static void main(String[] args) {
    System.out.println(solution("AAAAE"));

  }

}
