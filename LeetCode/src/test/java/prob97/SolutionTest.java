package prob97;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(true,sol.isInterleave("aabcc","dbbca","aadbbcbcac"));
    }
}
