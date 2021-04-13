package 가장긴팰린드롬;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test() {
        Assert.assertEquals(7,(new Solution()).solution("abcdcba"));
        Assert.assertEquals(3,(new Solution()).solution("abacde"));
    }
}
