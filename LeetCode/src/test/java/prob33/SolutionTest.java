package prob33;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals(4,sol.search(new int[]{4,5,6,7,0,1,2},0));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals(4,sol.search(new int[]{4,5,6,7,8,1,2,3},8));
    }
}
