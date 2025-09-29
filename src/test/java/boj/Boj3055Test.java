package boj;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.stream.Stream;

class Boj3055Test {

    @MethodSource("provider")
    @ParameterizedTest
    public void test(String input, String result) throws IOException {

        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        Boj3055.main(new String[] {});
    }

    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(input1, "3"),
                Arguments.of(input2, "KAKTUS"),
                Arguments.of(input3, "6"),
                Arguments.of(input4, "4")

        );
    }

    static String input1 = """
            5 4
            .D.*
            ....
            ..X.
            S.*.
            ....
            """;

    static String input2 = """
            3 3
            D.*
            ...
            ..S
            """;

    static String input3 = """
            3 6
            D...*.
            .X.X..
            ....S.
            """;

    static String input4 = """
            5 4
            .D.*
            ....
            ..X.
            S.*.
            ....
            """;

}