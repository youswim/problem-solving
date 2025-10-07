package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj2470 {

    public static void main(String[] args) throws IOException {

        // 문제 분류에는 이분 탐색이라고 되어있는데, 정확히는 투포인터였음.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());

        int[] arr = new int[size];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int answer1 = arr[0];
        int answer2 = arr[arr.length - 1];
        int min = Math.abs(answer1 + answer2);

        int start = 0;
        int end = arr.length - 1;
        while (start < end) {

            int res = arr[start] + arr[end];
            int absRes = Math.abs(arr[start] + arr[end]);
            if (absRes < min) {
                answer1 = arr[start];
                answer2 = arr[end];
                min = absRes;
            }

            if (res < 0) {
                start++;
            } else if (res > 0) {
                end--;
            } else {
                answer1 = arr[start];
                answer2 = arr[end];
                break;
            }

        }

        System.out.println(answer1 + " " + answer2);

    }

}
