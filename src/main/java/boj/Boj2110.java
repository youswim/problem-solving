package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int houseCnt = Integer.parseInt(st.nextToken());
        int wifiCnt = Integer.parseInt(st.nextToken());

        int[] houses = new int[houseCnt];
        for (int i = 0; i < houseCnt; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int lo = 1;
        int hi = houses[houses.length - 1] - houses[0] + 1;
        // 집이 (1, 2) 만 있는 경우를 대비하여 1을 더해준다.
        // 현재 로직은 while문 조건에 등호가 포함될 경우 무한루프를 돌게 됨.

        while (lo < hi) {
            int gap = (lo + hi) / 2;

            if (calculate(houses, gap) < wifiCnt) {
                hi = gap;
            } else {
                lo = gap + 1;
            }
        }

        System.out.println(lo - 1);

    }

    static int calculate(int[] houses, int gap) {
        int count = 1;
        int lastInstalled = 0;
        for (int i = 1; i < houses.length; i++) {
            if (houses[i] - houses[lastInstalled] >= gap) {
                count++;
                lastInstalled = i;
            }
        }
        return count;
    }

}
