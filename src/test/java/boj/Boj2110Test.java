package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

class Boj2110Test {

    @MethodSource("provider")
    @ParameterizedTest
    void test(String input, String output) throws IOException {

        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Boj2110.main(null);

        Assertions.assertEquals(output + System.lineSeparator(), outContent.toString());

    }

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of("""
                        5 3
                        1
                        2
                        8
                        4
                        9""", "3"),
                Arguments.of("""
                        2 2
                        1
                        2""", "1"));
    }

}