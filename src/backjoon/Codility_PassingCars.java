package backjoon;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Codility_PassingCars {

    public static int solution(int[] A) {
        int N = A.length;

        int cars = 0;

        int eastCar = 0;

        for (int i = 0; i < N; i++) {
            if (A[i] == 0) {
                eastCar++;
            } else {
                cars+=eastCar;
            }
        }
        if (cars > 1000000000 || cars < 0) return -1;

        return cars;


    }

    public static void main(String[] args) {

        int[] testValues = {0,1,0,1,1};
        System.out.println(solution(testValues));
    }
}
