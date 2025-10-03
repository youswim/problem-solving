package boj;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class Boj1920Test {

    @Test
    public void test() throws IOException {
        String input = """
                5
                4 1 5 2 3
                5
                1 3 7 9 5""";

        InputStream is = new ByteArrayInputStream(input.getBytes());
        System.setIn(is);

        Boj1920.main(null);
    }

}