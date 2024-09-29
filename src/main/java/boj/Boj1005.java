package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1005 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트 케이스 갯수
        int testCaseCnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseCnt; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            // 각 노드의 기본 걸리는 시간 입력
            int[] nodeWeights = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nodeWeights[j] = Integer.parseInt(st.nextToken());
            }

            // 각 노드별 후행 노드 리스트 초기화
            List<List<Integer>> nodeLines = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                nodeLines.add(new ArrayList<>());
            }

            int[] beforeNodeCnt = new int[N];  // 각 노드의 선행조건 수

            // 각 노드별 후행 노드 리스트 값 추가
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                nodeLines.get(start).add(end);
                beforeNodeCnt[end]++;
            }

            // 도착 노드
            int destNode = Integer.parseInt(br.readLine()) - 1;

            int result = findMinimumTime(N, nodeWeights, nodeLines, beforeNodeCnt, destNode);
            System.out.println(result);
        }

        br.close();
    }

    // Method that solves each test case
    public static int findMinimumTime(int N, int[] nodeWeights, List<List<Integer>> nodeLines, int[] beforeNodeCnt, int destNode) {
        int[] nodeWeightResults = Arrays.copyOf(nodeWeights, N);  // 각 노드의 최대 가중치

        Queue<Integer> q = new LinkedList<>();

        // 선행 조건이 없는 건물들의 번호를 queue 에 저장
        for (int j = 0; j < N; j++) {
            if (beforeNodeCnt[j] == 0) {
                q.add(j);
            }
        }

        // 위상정렬 및 최소 시간 계산
        while (!q.isEmpty()) {
            Integer currentNode = q.remove();
            if (currentNode == destNode) {
                return nodeWeightResults[currentNode];
            }

            List<Integer> afterNodes = nodeLines.get(currentNode);

            for (Integer afterNode : afterNodes) {
                nodeWeightResults[afterNode] = Math.max(nodeWeightResults[afterNode], nodeWeightResults[currentNode] + nodeWeights[afterNode]);
                beforeNodeCnt[afterNode]--;

                if (beforeNodeCnt[afterNode] == 0) {
                    q.add(afterNode);
                }
            }
        }

        return nodeWeightResults[destNode];
    }
}
