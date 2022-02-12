package prob127;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(5,sol.ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog")));
        Assert.assertEquals(0,sol.ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log")));
    }
}
