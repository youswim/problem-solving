package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Boj11049Test {

    @ParameterizedTest
    @MethodSource("source")
    void test(int matrixCnt, int[][] matrixs, long answer) {

        Assertions.assertEquals(Boj11049.calculateMinTimes(matrixCnt, matrixs), answer);

    }

    public static Stream<Arguments> source() {
        return Stream.of(Arguments.of(3, new int[][]{{5, 3}, {3, 2}, {2, 6}}, 90));
    }

}