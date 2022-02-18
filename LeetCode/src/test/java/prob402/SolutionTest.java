package prob402;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
       Solution sol = new Solution();
       Assert.assertEquals("1219",sol.removeKdigits("1432219",3));
       Assert.assertEquals("200",sol.removeKdigits("10200",1));
       Assert.assertEquals("0",sol.removeKdigits("10",2));
       Assert.assertEquals("0",sol.removeKdigits("1234567890",9));
       Assert.assertEquals("0",sol.removeKdigits("100",1));
    }
}
