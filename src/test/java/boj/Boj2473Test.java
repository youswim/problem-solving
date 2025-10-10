package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class Boj2473Test {

    @MethodSource("provider")
    @ParameterizedTest
    void test(String input, String output) throws IOException {

        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutput));

        Boj2473.main(null);

        Assertions.assertEquals(output + System.lineSeparator(), actualOutput.toString());

    }

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(
                        """
                                5
                                -2 6 -97 -6 98""", "-97 -2 98"
                ),
                Arguments.of(
                        """
                                7
                                -2 -3 -24 -6 98 100 61""", "-6 -3 -2"
                ),
                Arguments.of(
                        """
                                5
                                999999999 1000000000 1000000000 1000000000 1000000000""", "999999999 1000000000 1000000000"
                ),
                Arguments.of(
                        """
                                4
                                -5 2 3 4""", "-5 2 3"
                )
        );
    }

}