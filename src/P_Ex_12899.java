public class P_Ex_12899 {


    public static String solution(int n) {

        String answer = "";
        String[] arr = new String[]{"4","1","2"};
        while (n > 0) {
            answer = arr[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//
//            int i1 = i % arrSize;
//
//            if (i % arrSize == 1) {
//                sb.append(arr[0]);
//            } else if ( i % arrSize == 2) {
//                sb.deleteCharAt(sb.length()-1);
//                sb.append(arr[1]);
//            } else {
//                sb.deleteCharAt(sb.length()-1);
//                sb.append(arr[2]);
//            }
//
////            if (i )
//        }
//        answer = sb.toString();
//
//        return answer;

    }

    public static void main(String[] args) {
        System.out.println(solution(40));

    }
}
