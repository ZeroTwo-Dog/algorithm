package backjoon.greedy;

import java.util.Scanner;


/**
 * 단어 공부 Ex_1157
 * Created by park on 2022/10/23.
 */
public class Ex_1157 {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    //알파뱃 갯수가 26
    int[] ap = new int[26];
    String word = scan.next();

    word = word.toUpperCase();


    for (int i = 0; i < word.length(); i++) {
      //아스키 코드 활
      ap[word.charAt(i)- 'A']++;
    }


    int max = 0;
    char result = '?';
    for (int i = 0; i < ap.length; i++) {
      if (ap[i] > max) {
        max=ap[i];
        //65가 대문자 A 아스키코드
        result = (char)(i+65);
      } else if (ap[i] == max) {
          result ='?';
      }
    }

    System.out.println(result);


  }

}
