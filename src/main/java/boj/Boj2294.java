package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2294 {

    public static void main(String[] args) throws IOException {
        start();
    }

    public static void start() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> coins = new ArrayList<>();

        for (int i = 0; i < n; i++) { // coin 리스트 입력받기
            coins.add(Integer.valueOf(br.readLine()));
        }

        int result = logic(k, coins);
        System.out.println(result);

        br.close();
    }

    public static int logic(int k, List<Integer> coins) {
        int[] dp = new int[k + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
            // -1을 하지 않으면 45번 줄에서 dp[j - coin] + 1 할 때 overflow로 오답이 된다.
        }

        for (Integer coin : coins) {
            for (int j = coin; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k];
    }

}
