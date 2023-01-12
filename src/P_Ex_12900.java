public class P_Ex_12900 {


    public static int solution(int n) {

        int answer = 0;

        int[] arr = new int[n];

        arr[0] = 1;
        arr[1] = 2;

        for (int i =2; i < n; i++) {
            arr[i] = arr[i-2] + arr[i-1];
            if (i == n-1) {
                answer = arr[i]  % 1000000007;
            }

        }


        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution(4));

    }
}
