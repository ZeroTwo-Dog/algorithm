package backjoon.greedy;

import java.util.Scanner;

/**
 * 크로아티아 알파벳
 * Created by park on 2022/10/26.
 */
public class Ex_2941 {

  final static String[] CROATIA_ALPHABET ={"c=", "c-", "dz=","d-", "lj", "nj","s=","z="};

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);



    String word = scanner.next();
    int allAplCnt = 0;
    for (String ap : CROATIA_ALPHABET) {
      if (word.contains(ap)) {

        int apCnt = (word.length() - word.replace(ap, "").length()) / ap.length();
        //띄어쓰기로 안채우면 알파벳이 합쳐져서 크로아티아 앞파벳으로 인식할수도있음.
        word = word.replace(ap, " ");
        allAplCnt += apCnt;
      }
    }
    //공백 제거 - 남은 영어 알파벳 체크용
    word = word.replace(" ","");

    allAplCnt += word.length();
    System.out.println(allAplCnt);


  }
}
