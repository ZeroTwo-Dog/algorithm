package backjoon.greedy;

import java.util.*;

public class Greedy_02 {

    public static String[] solution(String[] logs) {
        String[] answer ;

        Map<String,Map<String, String>> dataMap = new TreeMap<>();
        List<String> result = new ArrayList<>();

        for (String log : logs) {
            Map<String, String> value = new TreeMap<>();
            String[] split = log.split(" ");
            String sCode = split[0];
            String number = split[1];
            String score = split[2];

            if (dataMap.containsKey(sCode)) {
                value = dataMap.get(sCode);
            }
            value.put(number, score);
            dataMap.put(sCode, value);

        }

        List<String> sCodes = new ArrayList<>(dataMap.keySet());

        for (int i = 0; i < sCodes.size(); i++) {
            String mainKey = sCodes.get(i);
            if (dataMap.get(mainKey).size() < 5) {
                continue;
            }
            if (i + 1 != sCodes.size()) {
                int j =  i + 1;
                String subKey = sCodes.get(j);
                if (dataMap.get(subKey).size() < 5) {
                    continue;
                }

                //동일한 번호
                for (String key : dataMap.get(mainKey).keySet()) {
                    String val1 = dataMap.get(mainKey).get(key);
                    String val2 = dataMap.get(subKey).get(key);

                    //문제 점수
                    if (!val1.equals(val2)) {
                        break;
                    }
                }
                if (!result.contains(mainKey)) {
                    result.add(mainKey);
                }

                if (!result.contains(subKey)) {
                    result.add(subKey);
                }
            }
        }




        if (result.size() == 0) {
            answer = new String[]{"None"};
        } else {
            answer = new String[result.size()];

            for (int  i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
//        String[] strs = new String[]{"1901 1 100", "1901 2 100", "1901 4 100","1901 7 100", "1901 8 100",
//        "1902 2 100","1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100",
//                "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100",
//                "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100",
//                "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100",};

//        String[] strs = new String[]{"0001 3 95", "0001 5 90", "0001 5 100","0002 3 95", "0001 7 80",
//                "0001 8 80","0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80",
//                "0002 5 100", "0003 99 90"};

        String[] strs = new String[]{"0001 1 0","0001 2 0", "0001 3 0", "0001 4 0","0001 5 0",
                "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0","0456 5 0"};
        System.out.println(Arrays.toString(solution(strs)));

    }
}
