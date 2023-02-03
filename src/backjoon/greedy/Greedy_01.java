package backjoon.greedy;

public class Greedy_01 {
    public static long solution(long n) {
        long answer = 0;

        for (int i = 1; i <= 100000; i++) {
            long quotient  =  i % n;
            long remainder   =  i / n;

            if (remainder > n) {
                break;
            }

            if (remainder  == quotient) {
                answer += i;
            }
        }



        return answer;
    }
    public static void main(String[] args) {
        System.out.println(solution(3));

    }
}
