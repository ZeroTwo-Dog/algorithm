package backjoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Codility_Nesting {

    public static int solution(String S) {
        // write your code in Java SE 8

        char[] strs = S.toCharArray();

        int left = 0;

        char before = 0;
        for (Character c :strs) {
            if (c.equals('(')) {
                left++;

            } else if(left == 0 || c == before){
                return 0;
            }
            before = c;
        }

        return 1;


    }

    public static void main(String[] args) {

        int[] testValues = {-3,-1,-2,-2,-5,-6};

        System.out.println(solution("(()(())())"));
    }
}
