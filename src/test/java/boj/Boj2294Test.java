package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Boj2294Test {

    @ParameterizedTest
    @MethodSource("provider")
    public void tes(Integer k, List<Integer> coins) throws IOException {

        int result = Boj2294.logic(15, Arrays.asList(1, 5, 12));
        Assertions.assertEquals(result, 3);

    }

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(15, Arrays.asList(1, 5, 12)
                ));
    }

}