package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11049 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int matrixCnt = Integer.parseInt(br.readLine());

        int[][] matrixs = new int[matrixCnt][2];

        StringTokenizer st;

        for (int i = 0; i < matrixCnt; i++) {
            st = new StringTokenizer(br.readLine());
            matrixs[i][0] = Integer.parseInt(st.nextToken()); // 행
            matrixs[i][1] = Integer.parseInt(st.nextToken()); // 열
        }

        System.out.println(calculateMinTimes(matrixCnt, matrixs));

        br.close();

    }

    static long calculateMinTimes(int matrixCnt, int[][] matrixs) {
        long [][] dp = new long[matrixCnt][matrixCnt];

        // dp 초기화
        for (int i = 0; i + 1 < matrixCnt; i++) {
            dp[i][i + 1] = (long) matrixs[i][0] * matrixs[i][1] * matrixs[i + 1][1];
        }

        for (int i = 0; i < matrixCnt - 1; i++) {
            int stage = i + 2; // 이거 변경 필요
            for (int j = 0; j + stage < matrixCnt; j++) {
                dp[j][j + stage] = Math.min(
                        dp[j + 1][j + stage] + (long) matrixs[j][0] * matrixs[j][1] * matrixs[j + stage][1],
                        dp[j][j + stage - 1] + (long) matrixs[j][0] * matrixs[j + stage][0] * matrixs[j + stage][1]
                );

            }
        }
        return dp[0][matrixCnt - 1];
    }
}
