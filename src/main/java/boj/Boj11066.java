package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11066 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testRepeatCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testRepeatCnt; i++) {

            int fileCnt = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            int[] files = new int[fileCnt];
            for (int j = 0; j < fileCnt; j++) {
                files[j] = Integer.parseInt(st.nextToken());
            }

            System.out.println(fun(files));

        }
    }

    public static int fun(int[] files) {

        int[][] dp = new int[files.length][files.length];

        // 구간별 파일 크기의 합
        int[] fileSum = new int[files.length + 1];

        // 구간별 파일 크기 합 리스트 계산
        fileSum[1] += files[0];
        for (int i = 2; i < fileSum.length; i++) {
            fileSum[i] = fileSum[i - 1] + files[i - 1];
        }
        // 10 10 10 10 10
        // 0  10 20 30 40 50


        for (int step = 1; step < files.length; step++) {

            for (int start = 0; start < files.length; start++) {

                if (start + step == files.length) break;

                dp[start][start + step] = Integer.MAX_VALUE;

                for (int divide = start; divide < start + step; divide++) {

                    dp[start][start + step] = Math.min(
                            dp[start][start + step],
                            dp[start][divide] + dp[divide + 1][start + step] + fileSum[start + step + 1] - fileSum[start]
                            // 나눈 각 구간을 만들기 위해 필요한 시간 최소합 + 두개 파일을 합치기 위해 필요한 시간
                    );

                    /*
                     처음에는 아래와 같이 했었음
                     (dp[start][divide] + dp[divide + 1][start + step]) * 2

                     숫자가 적은 케이스에서는 티가 안나는데,
                     여러번 합친 구간의 파일을 합치려고 할 때, 숫자가 정답보다 커지게 된다.
                     따라서 잘못된 풀이임.
                     */
                }

            }

        }

        return dp[0][files.length - 1];

    }

    // 11049 번 문제와 거의 동일하다.

    /*
    3중 for문을 사용한다.
    1 : step 별 for문 (1부터 시작)
    2 : start 별 for문 (0부터 시작)
    3 : device 별 for문 (start부터 시작(2번 for문))
    단계별 for문 (1부터 시작)
     */
}
