package prob1641;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    Solution sol = new Solution();

    @Test
    public void test1() {
        Assert.assertEquals(66045,sol.countVowelStrings(33));
    }
}
