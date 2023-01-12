package backjoon;


import java.util.*;

public class Codility_FrogRiverOne {

    public static  int solution(int X, int[] A) {
        // write your code in Java SE 8

        Set<Integer> leaf = new HashSet<>();
        for (int i =0 ; i < A.length; i++) {
            leaf.add(A[i]);

            if (leaf.size() == X) {
                return  i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] testValues = {1,3,1,4,2,3,4};
        System.out.println(solution(120,testValues));
    }
}
