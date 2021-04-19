package 뱀;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SolutionTest {

    @Test
    public void test() throws IOException {
        String[] fnames = {"input.txt","input2.txt","input3.txt"};
        int[] ans = {9,21,13};
        for (int i=0;i<ans.length;i++) {
            Assert.assertEquals(ans[i],Main.solve("resources/"+fnames[i],true));
        }
    }
}
