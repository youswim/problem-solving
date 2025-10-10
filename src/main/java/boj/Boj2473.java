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

        long min = Long.MAX_VALUE;
        int[] answer = new int[3];
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while (lo < hi) {
                long tmpSum = (long) nums[i] + nums[lo] + nums[hi]; // 형변환을 별도로 해주지 않으면 오버플로우 발생
                long tmpSumAbs = Math.abs(tmpSum);
                if (tmpSumAbs < min) {
                    min = tmpSumAbs;
                    answer[0] = nums[i];
                    answer[1] = nums[lo];
                    answer[2] = nums[hi];
                }

                if (tmpSum < 0) {
                    lo++;
                } else if (tmpSum > 0) {
                    hi--;
                } else {
                    break;
                }
            }

        }

        System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);

    }
}
