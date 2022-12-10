package progammers;

/**
 * JadenCase 문자열 만들기
 * Created by park on 2022/12/10
 */
public class P_ex_12951 {

  public static String solution(String s) {
    StringBuilder answer = new StringBuilder();

    String[] split = s.split(" ");

    for (int i =0; i < split.length; i++) {
      split[i] = split[i].toLowerCase();
      if (split[i].length() != 0) {
        split[i] = split[i].substring(0,1).toUpperCase() + split[i].substring(1);
      }

      if (i == split.length-1) {
        answer.append(split[i]);
      }  else {
        answer.append(split[i]).append(" ");
      }


    }

    if (s.charAt(s.length() - 1) == ' ') {
      answer.append(" ");
    }

    return answer.toString();

  }


  public static void main(String[] args) {
    System.out.println(solution("   a "	));

  }

}
