package boj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.*;
import java.util.stream.Stream;

class Boj2470Test {

    @MethodSource("provider")
    @ParameterizedTest
    public void test(String input, String output) throws IOException {
        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        PrintStream originalOut = System.out;

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Boj2470.main(null);

        // System.lineSeparator() : 운영체제별로 다른 줄바꿈 문자열
        Assertions.assertEquals(output + System.lineSeparator(), outContent.toString());

    }


    public static Stream<Arguments> provider() {
        return Stream.of(
                Arguments.of(
                        """
                                5
                                -2 4 -99 -1 98""", "-99 98"),
                Arguments.of(
                        """
                                5
                                -99 -98 -97 -96 -95""", "-96 -95"
                ),
                Arguments.of(
                        """
                                5
                                95 96 97 98 99""", "95 96"
                ));
    }


}