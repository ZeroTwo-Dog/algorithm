package backjoon.greedy;

import java.util.*;

public class Greedy_05 {

    public static void main(String[] args) {

        int[] queue = {2,1,3,1,2,1};
        Queue<Integer> numQueue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(Map.of(1, 0, 2, 0, 3, 0));
        for(int num :queue){
            map.put(num, map.get(num) + 1);
            numQueue.add(num);
        }

        Comparator<Map.Entry<Integer, Integer>> comparator = Map.Entry.comparingByValue();

        int[] answer = {0,0,0};
        while (!map.get(1).equals(map.get(2)) || !map.get(2).equals(map.get(3))) {
            int num = numQueue.poll();
            map.put(num, map.get(num) - 1);
            Map.Entry<Integer, Integer> minEntry = Collections.min(map.entrySet(), comparator);
            Integer minNum = minEntry.getKey();
            map.put(minNum, map.get(minNum) + 1);
            answer[minNum - 1] = answer[minNum - 1] + 1;
        }

        System.out.println(Arrays.toString(answer));

    }
}
