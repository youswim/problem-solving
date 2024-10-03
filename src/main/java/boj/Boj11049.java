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

        for (int term = 1; term < matrixCnt; term++) {
            for (int start = 0; start < matrixCnt; start++) {

                if (term + start == matrixCnt) break;

                dp[start][start + term] = Integer.MAX_VALUE;

                // [0][10] 이라면, [0][i] * [i+1][10] (0 <= i <= 10) 처럼 두 구간으로 나누어 곱의 최솟값을 계산한다.
                for (int sep = start; sep < start + term; sep++) {

                    dp[start][start + term] = Math.min(
                            dp[start][start + term],
                            dp[start][sep] + dp[sep + 1][start + term] + (long) matrixs[start][0] * matrixs[sep][1] * matrixs[start + term][1]
                    );

                }

            }
        }

        return dp[0][matrixCnt - 1];

    }

}
