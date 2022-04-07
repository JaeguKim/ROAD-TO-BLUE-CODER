package prob680;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(true,sol.validPalindrome("aba"));
        Assert.assertEquals(true,sol.validPalindrome("abca"));
        Assert.assertEquals(false,sol.validPalindrome("abc"));
    }
}
