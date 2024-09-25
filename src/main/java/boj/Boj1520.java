package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1520 {

    static int[][] map;
    static int[][] dp;

    static int[] dRow = {-1, 0, 1, 0};
    static int[] dCol = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int rowSize = Integer.parseInt(st.nextToken()); // M
        int colSize = Integer.parseInt(st.nextToken()); // N

        map = new int[rowSize][colSize];

        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[0].length; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(fun());

    }

    static int fun() {

        dp = new int[map.length][map[0].length];
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                dp[row][col] = -1;
            }
        }

        return dfs(0, 0);

    }

    static int dfs(int row, int col) {

        if (row == map.length - 1 && col == map[0].length - 1) {
            return 1;
        }

        if (dp[row][col] != -1) {
            return dp[row][col];
        }

        dp[row][col] = 0;

        for (int i = 0; i < 4; i++) {

            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if (nRow < 0 || nCol < 0 || nRow >= map.length || nCol >= map[0].length) {
                continue;
            }

            if (map[nRow][nCol] < map[row][col]) {
                dp[row][col] += dfs(nRow, nCol);
            }
        }

        return dp[row][col];

    }

}