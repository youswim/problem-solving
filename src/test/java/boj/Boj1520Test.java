package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Boj1520Test {

    @ParameterizedTest
    @MethodSource("source")
    void test1(int[][] map, int expected) {

        Boj1520.map = map;

        Assertions.assertEquals(expected, Boj1520.fun());
    }

    public static Stream<Arguments> source() {
        return
        Stream.of(
                Arguments.of(new int[][]{
                        {0, 0, 0, 0, 0, 0},
                        {0, 50, 45, 37, 32, 30},
                        {0, 35, 50, 40, 20, 25},
                        {0, 30, 30, 25, 17, 28},
                        {0, 27, 24, 22, 15, 10}}, 3),
                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {0, 10, 9},
                        {0, 11, 8}}, 1),
                Arguments.of(new int[][]{
                        {0, 0, 0},
                        {0, 10, 9},
                        {0, 9, 8}}, 2)
        );
    }



}