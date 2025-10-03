package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] baseNumbers = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < baseNumbers.length; i++) {
            baseNumbers[i] = Integer.parseInt(st.nextToken());
        }

        int fcNumberSize = Integer.parseInt(br.readLine());
        StringTokenizer fcNumbers = new StringTokenizer(br.readLine(), " ");

        Arrays.sort(baseNumbers);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < fcNumberSize; i++) {
            if (binarySearch(baseNumbers, Integer.parseInt(fcNumbers.nextToken()))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean binarySearch(int[] baseNumbers, int target) {
        int start = 0; // 0
        int end = baseNumbers.length - 1; // 9

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target == baseNumbers[mid]){ return true;}
            if (target < baseNumbers[mid]) {
                end = mid - 1;
            } else { // target > mid
                start = mid + 1;
            }
        }
        return false;
    }

    // 시간초과 코드
//    static boolean binarySearch(int[] baseNumbers, int target) {
//        int start = 0; // 0
//        int end = baseNumbers.length - 1; // 9
//
//        while (start != end) {
//            int mid = (start + end) / 2;
//            if (target == baseNumbers[mid]){ return true;}
//            if (target < baseNumbers[mid]) {
//                end = mid - 1;
//            } else { // target > mid
//                start = mid + 1;
//            }
//        }
//        return baseNumbers[start] == target;
//    }
}