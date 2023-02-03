package backjoon.priority_queue;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueue_01 {
    static class Data implements Comparable<Data> {
        private int number;
        private int startTime;
        private int pageSize;

        public int getNumber() {
            return number;
        }

        public int getPageSize() {
            return pageSize;
        }

        public Data(int number, int startTime, int pageSize) {
            this.number = number;
            this.startTime = startTime;
            this.pageSize = pageSize;
        }

        //우선순위 큐 기준
        @Override
        public int compareTo(Data other) {
            if (this.pageSize == other.pageSize) {
                if (this.startTime < other.startTime) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                if (this.pageSize < other.pageSize) {
                    return -1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static int[] solution(int[][] data) {
        int[] answer = new int[data.length];
        int nowNumber = 0;
        int iterIndex = 1;
        int finalNum = data.length;
        int nowTime = data[0][1];

        PriorityQueue<Data> pq = new PriorityQueue<>();

        pq.add(new Data(data[0][0], data[0][1], data[0][2]));
        while (!pq.isEmpty()) {
            Data poll = pq.poll();
            answer[nowNumber] = poll.getNumber();
            nowNumber++;
            nowTime += poll.getPageSize();
            while (true) {
                if (iterIndex == finalNum) {
                    break;
                }
                if (nowTime >= data[iterIndex][1]) {
                    pq.add(new Data(data[iterIndex][0], data[iterIndex][1], data[iterIndex][2]));
                    iterIndex++;
                } else {
                    //없음 일 경우
                    if (pq.isEmpty()) {
                        pq.add(new Data(data[iterIndex][0], data[iterIndex][1], data[iterIndex][2]));
                        //다음 요청시간으로
                        nowTime = data[iterIndex][1];
                        iterIndex++;
                    }
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

//        int[][] test = new int[][] {
//                {1,2,10}, {2,5,8}, {3,6,9}, {4,20,6}, {5,25,5}
//        };

        int[][] test = new int[][] {
                {1,0,3}, {2,1,3}, {3,3,2}, {4,9,1}, {5,10,2}
        };
        System.out.println(Arrays.toString(solution(test)));

    }
}
