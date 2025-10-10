package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2473 {

    // 입력 추가 예시 : https://www.acmicpc.net/board/view/59873

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] nums = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);

        int lo = 0;
        int hi = nums.length - 1;

        long min = Long.MAX_VALUE;
        int[] res = new int[3];
        while (lo < hi - 1) {

            int midIdx = calculatePartialMin(lo, hi, nums);
            long partialRes = nums[lo] + nums[hi] + nums[midIdx];
            long partialResAbs = Math.abs(partialRes);
            if (partialResAbs < min) {
                res[0] = nums[lo];
                res[1] = nums[midIdx];
                res[2] = nums[hi];
                min = partialResAbs;
            }
            // 이 부분이 오답의 결정적 원인.
            // 합을 구하는데에는 3개의 숫자를 사용하나, 두개의 숫자만 사용하여 판단하다보니 문제 발생
            long twoPointRes = nums[lo] + nums[hi];
            if (twoPointRes > 0) {
                hi--;
            } else if (twoPointRes < 0) {
                lo++;
            } else {
                if (partialRes > 0) {
                    hi--;
                } else if (partialRes < 0) {
                    lo++;
                } else {
                    break;
                }
            }

        }

        System.out.println(res[0] + " " + res[1] + " " + res[2]);
    }

    static int calculatePartialMin(int lo, int hi, int[] nums) {
        long min = Long.MAX_VALUE;
        int minIdx = 0;
        long base = nums[lo] + nums[hi];
        for (int i = lo + 1; i < hi; i++) {
            long sum = Math.abs(base + nums[i]);
            if (min > sum) {
                min = sum;
                minIdx = i;
            }
        }

        return minIdx;
    }
}
