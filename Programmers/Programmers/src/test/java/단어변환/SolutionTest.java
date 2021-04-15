package 단어변환;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void solTest() {
        Solution sol = new Solution();
        Assert.assertEquals(4,sol.solution("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"}));
        sol = new Solution();
        Assert.assertEquals(0,sol.solution("hit","cog",new String[]{"hot","dot","dog","lot","log"}));
    }
}
