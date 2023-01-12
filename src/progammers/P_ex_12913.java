package progammers;

/**
 * 땅 따먹기
 * Created by park on 2022/11/16.
 */
public class P_ex_12913 {
  public static int solution(int[][] land) {
    int answer = 0;

    for(int i = 1; i < land.length; i++) {
      //0번째엔 1,2,3 col중에 가장 큰 것 다음으로 저장
      land[i][0] += maxScore(land[i-1][1], land[i-1][2], land[i-1][3]);
      //1번째엔 0,2,3 col중에 가장 큰 것 다음으로 저장
      land[i][1] += maxScore(land[i-1][0], land[i-1][2], land[i-1][3]);
      //2번째엔 0,1,3 col중에 가장 큰 것 다음으로 저장
      land[i][2] += maxScore(land[i-1][0], land[i-1][1], land[i-1][3]);
      //3번째엔 0,1,2 col중에 가장 큰 것 다음으로 저장
      land[i][3] += maxScore(land[i-1][0], land[i-1][1], land[i-1][2]);
    }

    //마지막 행에 모드 최대 경우이기때문에 최대값 찾기
    for(int score : land[land.length - 1]){ // 마지막 행의 최대값 탐색
      answer = Math.max(answer, score);
    }

    return answer;
  }

  public static int maxScore(int a, int b, int c) {
    int max;

    max = Math.max(Math.max(a, b), c);

    return max;
  }


  public static void main(String[] args) {
    int[][] values = new int[][] {{1,2,3,5},{5,6,7,8}, {4,3,2,1}};
    System.out.println(solution(values));

  }

}
