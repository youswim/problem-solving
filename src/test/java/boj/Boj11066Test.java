package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class Boj11066Test {

    @ParameterizedTest
    @MethodSource("source")
    void test1(int[] files, int answer) {

        Assertions.assertEquals(answer, Boj11066.fun(files));
    }

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(new int[]{40, 10, 20}, 100),
                Arguments.of(new int[]{40, 30, 30, 50}, 300),
                Arguments.of(new int[]{1, 21, 3, 4, 5, 35, 5, 4, 3, 5, 98, 21, 14, 17, 32}, 864)
        );
    }

}