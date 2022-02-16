package chapter12;

/**
 * 문자열 압축 (보류 문제가 이해가안감)
 * Created by park on 2022/01/18.
 */
public class Ex12_3 {

  public static void main(String[] args) {
    String s = "aabbaccc";
    String[] strs =  new String[1000];

    int start;
    int end;
    int cnt = 1;
    //글자수 반복문
    for (int i = 1; i <= s.length(); i++) {
      strs[i-1] = "";
      start = 0;
      end = i;
      String sStr = s.substring(0, i);
      //
      for (int j = i; j < s.length(); j++) {
        String e;
        if ((end+i) <= s.length()+1) {
          e = s.substring(start, end);
          start += i;
          end += i;
          if (i == 1) {
            strs[i-1] += e;
          } else {
            if (sStr.equals(s.substring(start, end))) {
              strs[i - 1] += i + e;
            } else {
              strs[i-1] += e;
            }
          }
        }
      }
    }
    System.out.println(s.substring(7,8));
  }
}
