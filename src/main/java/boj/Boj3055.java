package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj3055 {

    /*
    물과 고슴도치 각각 한단계씩 BFS를 수행해야 하는 점이 특이했음.
    고슴도치가 더이상 움직이지 못할 때를 가정하기 위해
    while(고슴도치 queue not empty) 문을 가장 상단에 배치하였다.
     */

    private static final int[][] directions = new int[][]{
            new int[]{1, 0}, new int[]{0, 1}, new int[]{-1, 0}, new int[]{0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] initialCondition = br.readLine().split(" ");
        int rowSize = Integer.parseInt(initialCondition[0]);
        int colSize = Integer.parseInt(initialCondition[1]);

        int[][] map = new int[rowSize][colSize];
        boolean[][] waterVisited = new boolean[rowSize][colSize];
        boolean[][] hogVisited = new boolean[rowSize][colSize];

        Queue<int[]> waterQueue = new LinkedList<>();
        Queue<int[]> hogQueue = new LinkedList<>();

        int[] beaverCoord = new int[]{0, 0}; // 초기화

        for (int i = 0; i < rowSize; i++) {
            map[i] = new int[colSize];
            waterVisited[i] = new boolean[colSize];
            String[] rowMap = br.readLine().split("");
            for (int j = 0; j < rowMap.length; j++) {
                if ("D".equals(rowMap[j])) {
                    beaverCoord = new int[]{i, j};
                } else if ("S".equals(rowMap[j])) {
                    hogQueue.add(new int[]{i, j});
                    hogVisited[i][j] = true;
                } else if ("X".equals(rowMap[j])) {
                    map[i][j] = -1; // -1은 바위를 의미
                } else if ("*".equals(rowMap[j])) {
                    waterVisited[i][j] = true;
                    waterQueue.add(new int[]{i, j});
                }
            }
        }


        // 물을 먼저 움직인 뒤, 고슴도치를 움직인다.
        Loop1:
        while (!hogQueue.isEmpty()) {
            List<int[]> waterList = new ArrayList<>();
            while (!waterQueue.isEmpty()) {
                waterList.add(waterQueue.remove());
            }

            for (int[] waterCoord : waterList) {

                int waterRow = waterCoord[0];
                int waterCol = waterCoord[1];

                for (int[] direction : directions) {
                    int newWaterRow = waterRow + direction[0];
                    int newWaterCol = waterCol + direction[1];
                    if (0 <= newWaterRow && newWaterRow < rowSize &&
                            0 <= newWaterCol && newWaterCol < colSize &&
                            map[newWaterRow][newWaterCol] != -1 &&
                            !(newWaterRow == beaverCoord[0] && newWaterCol == beaverCoord[1]) &&
                            !waterVisited[newWaterRow][newWaterCol]) {
                        waterVisited[newWaterRow][newWaterCol] = true;
                        waterQueue.add(new int[]{newWaterRow, newWaterCol});
                    }
                }
            }

//            for (boolean[] booleans : waterVisited) {
//                System.out.println(Arrays.toString(booleans));
//            }

            List<int[]> hogList = new ArrayList<>();
            while (!hogQueue.isEmpty()) {
                hogList.add(hogQueue.remove());
            }

            for (int[] hogCoord : hogList) {
                int hogRow = hogCoord[0];
                int hogCol = hogCoord[1];

                for (int[] direction : directions) {
                    int newHogRow = hogRow + direction[0];
                    int newHowCol = hogCol + direction[1];
                    if (0 <= newHogRow && newHogRow < rowSize &&
                            0 <= newHowCol && newHowCol < colSize &&
                            map[newHogRow][newHowCol] != -1 &&
                            !waterVisited[newHogRow][newHowCol] &&
                            !hogVisited[newHogRow][newHowCol]) {
                        hogVisited[newHogRow][newHowCol] = true;
                        map[newHogRow][newHowCol] = map[hogRow][hogCol] + 1;
                        if (newHogRow == beaverCoord[0] && newHowCol == beaverCoord[1]) {
                            break Loop1;
                        }
                        hogQueue.add(new int[]{newHogRow, newHowCol});
                    }
                }
            }
//            for (int[] c : map) {
//                System.out.println(Arrays.toString(c));
//            }
//            System.out.println("----");
        }

        String result = map[beaverCoord[0]][beaverCoord[1]] == 0 ?
                "KAKTUS" : String.valueOf(map[beaverCoord[0]][beaverCoord[1]]);

        System.out.println(result);

    }
}
