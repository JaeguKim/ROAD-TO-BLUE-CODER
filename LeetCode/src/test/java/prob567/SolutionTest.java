package prob567;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(true,sol.checkInclusion("ab","eidbaooo"));
        Assert.assertEquals(false,sol.checkInclusion("ab","eidboaoo"));
    }
}
