package cloud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 사은품 교환하기
 * Created by park on 2023/02/28.
 */
public class Cloud_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int t = Integer.parseInt(input);
        long[] n = new long[t];
        long[] m =  new long[t];


        for (int i = 0; i < t; i++) {
            String input2 = br.readLine();
            String[] split2 = input2.split(" ");
            n[i] = Long.parseLong(split2[0]);
            m[i] = Long.parseLong(split2[1]);
        }
        long[] result = new long[t];

        for (int i = 0; i < t; i++) {
            if (n[i] < 5) {
                result[i] = 0;
            } else {
                long coupon = n[i] / 5;
                long sum = coupon * 12;

                if (sum <= n[i] +m[i]) {
                    result[i] = coupon;
                } else {
                    result[i] = (n[i] +m[i]) / 12;
                }



            }
        }

        for (long r : result) {
            System.out.println(r);
        }


    }
}
