package 입국심사;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(28,sol.solution(6,new int[]{7,10}));
    }
}
