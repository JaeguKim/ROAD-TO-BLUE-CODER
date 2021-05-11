package 게리맨더링2;
import org.junit.Assert;
import org.junit.Test;
import java.io.IOException;

public class SolutionTest {

    String prefix = "resources/게리맨더링2/";

    @Test
    public void test1() throws IOException {
        Assert.assertEquals(18, Main.solve(prefix+"input1.txt",true));
    }

    @Test
    public void test2() throws IOException {
        Assert.assertEquals(20, Main.solve(prefix+"input2.txt",true));
    }

    @Test
    public void test3() throws IOException {
        Assert.assertEquals(23, Main.solve(prefix+"input3.txt",true));
    }

    @Test
    public void test4() throws IOException {
        Assert.assertEquals(1, Main.solve(prefix+"input4.txt",true));
    }
}
