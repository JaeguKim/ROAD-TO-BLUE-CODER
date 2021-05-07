package 전화번호목록;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolTest {
    String prefix = "resources/전화번호목록/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals("NO\n" +
                "YES\n", Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals("NO\n" +
                "NO\n", Main.solve(prefix+"input2.txt",true));
    }
}