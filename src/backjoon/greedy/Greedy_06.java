package backjoon.greedy;

public class Greedy_06 {

    public static boolean[][] nonActiveTime = new boolean[25][61];


    public static String solution(String noti_time, String[] do_not_disturb) {
        for (int i = 0; i < do_not_disturb.length; i++) {
            String[] timeSplit = do_not_disturb[i].split("~");
            String startTime =  timeSplit[0];
            String[] startSplit = startTime.split(":");
            int startHour = Integer.parseInt(startSplit[0]);
            int startMinutes = Integer.parseInt(startSplit[1]);

            String endTime = timeSplit[1];
            String[] endSplit = endTime.split(":");
            int endHour = Integer.parseInt(endSplit[0]);
            int endMinutes = Integer.parseInt(endSplit[1]);


            if (startHour < endHour) {
                for (int j = startHour + 1; j < endHour; j++) {
                    for (int k = 0; k <= 59; k++) {
                        nonActiveTime[j][k] = true;
                    }
                }
            } else if (startHour == endHour) {
                if (startMinutes > endMinutes) {
                    for (int j = 0; j < 24; j++) {
                        if (j == startHour) continue;
                        for (int k = 0; k <= 59; k++) {
                            nonActiveTime[j][k] = true;
                        }
                    }
                }
            } else {
                for (int j = startHour + 1; j < 24; j++) {
                    for (int k = 0; k <= 59; k++) {
                        nonActiveTime[j][k] = true;
                    }
                }

                for (int j = 0; j < endHour; j++) {
                    for (int k = 0; k <= 59; k++) {
                        nonActiveTime[j][k] = true;
                    }
                }
            }


            if (startHour == endHour) {
                if (startMinutes < endMinutes) {
                    for (int j = startMinutes; j < endMinutes; j++) {
                        nonActiveTime[startHour][j] = true;
                    }
                } else {
                    for (int j = startMinutes +1 ; j <= 59; j++) {
                        nonActiveTime[startHour][j] = true;
                    }
                    for (int j = 0 ; j < endMinutes; j++) {
                        nonActiveTime[startHour][j] = true;
                    }
                }
            } else {
                for (int j = startMinutes; j <= 59; j++) {
                    nonActiveTime[startHour][j] = true;
                }
                for (int j = 0; j < endMinutes; j++) {
                    nonActiveTime[endHour][j] = true;
                }
            }
        }

        String[] split = noti_time.split(":");
        int notiHour = Integer.parseInt(split[0]);
        int notiMinutes = Integer.parseInt(split[1]) - 1;
        String answer = "impossible";
        for (int j = 0; j < 2400; j++) {
            notiMinutes++;
            if (notiMinutes == 60) {
                notiHour++;
                if (notiHour == 24) {
                    notiHour = 0;
                }
                notiMinutes = 0;
            }
            if (!nonActiveTime[notiHour][notiMinutes]) {
                String resultHour = "";
                String resultMinutes = "";
                if (notiHour >= 10) {
                    resultHour = Integer.toString(notiHour);
                }  else {
                    resultHour = "0" + notiHour;
                }
                if (notiMinutes >= 10) {
                    resultMinutes = Integer.toString(notiMinutes);
                } else {
                    resultMinutes = "0" + notiMinutes;
                }
                answer = resultHour + ":" + resultMinutes;
                break;
            }
        }
        return answer;
    }


    public static void main(String[] args) {

        String noti_time = "09:55";
        String[] do_not_disturb = {"09:55~13:25","13:25~14:01"};

        System.out.println(solution(noti_time, do_not_disturb));

    }
}
