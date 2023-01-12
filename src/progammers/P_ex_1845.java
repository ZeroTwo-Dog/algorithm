package progammers;

import java.util.HashSet;
import java.util.Set;

public class P_ex_1845 {
    public static int solution(int[] nums) {
        int answer;

        int div = nums.length / 2;

        Set<Integer> numSets = new HashSet<>();

        for (int num : nums) {
            numSets.add(num);
        }
        if (numSets.size() == 1) {
            answer = 1;
        } else if (numSets.size() < div) {
            answer = numSets.size();
        } else {
            answer = div;
        }



        return answer;
    }
    public static void main(String[] args) {
        int[] arr1 = new int[]{3,3,3,2,2,2};
        System.out.println(solution(arr1));

    }
}
