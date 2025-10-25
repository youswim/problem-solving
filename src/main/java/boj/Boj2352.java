package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj2352 {

    public static void main(String[] args) throws IOException {
        // 와이어를 엉키기 않게 연결하는 방법 = 가장 긴 증가하는 수열 문제

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int wireCnt = Integer.parseInt(br.readLine());
        int[] wire = new int[wireCnt];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < wire.length; i++) {
            wire[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> lis = new ArrayList<>();

        lis.add(wire[0]);
        for (int i = 1; i < wire.length; i++) {
            Integer lastLisElement = lis.get(lis.size() - 1);
            if (lastLisElement < wire[i]) {
                lis.add(wire[i]);
            } else if (lastLisElement > wire[i]) {
                lis.set(binarySearch(lis, wire[i]), wire[i]);
            }
        }

        System.out.println(lis.size());
    }

    static int binarySearch(List<Integer> list, int num) {
        int lo = 0;
        int hi = list.size() - 1;
        int mid = (lo + hi) / 2;
        while (lo < hi) {
            if (list.get(mid) < num) {
                lo = mid + 1;
            } else if (list.get(mid) > num) {
                hi = mid;
            } else { // 문제 조건에서는 사실상 동작하지 않는 조건
                break;
            }
            mid = (lo + hi) / 2; // 포인트
        }
        return mid;
    }
}
