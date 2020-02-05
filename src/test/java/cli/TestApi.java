package cli;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import api.cli.Put;

public class TestApi {

    @Test
    public void lengthOfparser() {
        String s1 = "\"this is a test string, and this is one doc only\"";
        String[] out1 = Put.parseRegexInput(s1);

        assertEquals(1, out1.length);

        String s2 = "\"this is a test string, and this has two docs\", like this";
        String[] out2 = Put.parseRegexInput(s2);

        assertEquals(2, out2.length);

    }
}