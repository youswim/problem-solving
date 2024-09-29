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

            // 각 노드의 가중치
            int[] nodeWeights = new int[N];

            // 각 노드의 현재 선행조건 수
            int[] beforeNodeCnt = new int[N];

            // 각 노드별 기본 걸리는 시간 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                nodeWeights[j] = Integer.parseInt(st.nextToken());
            }

            // 각 노드의 최대 가중치 (nodeWeights 값으로 초기화)
            int[] nodeWeightResults = Arrays.stream(nodeWeights).toArray();

            // 각 노드별 후행 노드 리스트 초기화
            List<List<Integer>> nodeLines = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                nodeLines.add(new ArrayList<>());
            }

            // 각 노드별 후행 노드 리스트 값 추가
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken()) - 1;
                int end = Integer.parseInt(st.nextToken()) - 1;
                nodeLines.get(start).add(end);
                beforeNodeCnt[end]++;
            }

            // 도착 node 입력
            int destNode = Integer.parseInt(br.readLine()) - 1;

            Queue<Integer> q = new LinkedList<>();

            // 선행 조건이 없는 건물들의 번호를 queue 에 저장
            for (int j = 0; j < N; j++) {
                if (beforeNodeCnt[j] == 0) {
                    q.add(j);
                }
            }

            while (!q.isEmpty()) {
                Integer popNode = q.remove();
                List<Integer> afterNodes = nodeLines.get(popNode);

                for (Integer afterNode : afterNodes) {
                    nodeWeightResults[afterNode] = Math.max(nodeWeightResults[afterNode], nodeWeightResults[popNode] + nodeWeights[afterNode]);

                    beforeNodeCnt[afterNode]--;

                    if (beforeNodeCnt[afterNode] == 0) {
                        q.add(afterNode);
                    }
                }
            }

            System.out.println(nodeWeightResults[destNode]);

            br.close();


        }


        // 게임 시작부터 현재 건물을 짓는데에 걸리는 시간 = 게임 시작부터 현재 건물을 짓는데에 걸리는 시간 + 현재 건물 건설 시간
    }

}
