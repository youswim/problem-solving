package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1450 {

    private static int c;
    private static int[] arr;

    // 중간에서 만나기 알고리즘
    // 배열을 절반으로 나눈 뒤, 각각 합이 가능한 경우를 구한다.
    // 오른쪽 배열은 정렬을 한다.
    // 정렬하지 않은 배열의 원소를 하니씩 꺼내어, 가방에 담을 수 있는 최대 무게에서 원소의 값을 뺀다.
    // 원소의 값을 정렬된 한쪽 배열에서 이진탐색으로 위치를 찾는다.
    // 찾은 위치 인덱스가, 왼쪽 배열의 원소를 뽑았을 때에도 사용 가능한 경우의 수

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        exSearch(left, 0, n / 2, 0);
        exSearch(right, n / 2, n, 0);
        Collections.sort(right);

        int result = 0;
        for (Integer integer : left) {
            result += bs(integer, right) + 1;
        }
        System.out.println(result);
        br.close();
    }

    private static void exSearch(List<Integer> part, int start, int end, int sum) {
        if (sum > c) return;
        if (start == end) {
            part.add(sum);
            return;
        }
        exSearch(part, start + 1, end, sum);
        exSearch(part, start + 1, end, sum + arr[start]);
    }

    // 1
    // 0 0 1 1 1 1 2
    private static int bs(int target, List<Integer> right) {
        int start = 0;
        int end = right.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (right.get(mid) <= c - target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }
}
