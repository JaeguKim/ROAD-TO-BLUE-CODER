package 리틀프랜즈사천성;

import org.junit.Assert;
import org.junit.Test;

public class SolTest {

    @Test
    public void test1() {
        Solution sol = new Solution();
        Assert.assertEquals("ABCD",sol.solution(3,3,new String[]{"DBA", "C*A", "CDB"}));
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        Assert.assertEquals("RYAN",sol.solution(2,4,new String[]{"NRYN", "ARYA"}));
    }

    @Test
    public void test3() {
        Solution sol = new Solution();
        Assert.assertEquals("MUZI",sol.solution(4,4,new String[]{".ZI.", "M.**", "MZU.", ".IU."}));
    }

    @Test
    public void test4() {
        Solution sol = new Solution();
        Assert.assertEquals("IMPOSSIBLE",sol.solution(2,2,new String[]{"AB", "BA"}));
    }

    @Test
    public void test5() {
        Solution sol = new Solution();
        Assert.assertEquals("ABCDFHGIE",sol.solution(5,5,new String[]{"FGHEI", "BAB..", "D.C*.", "CA..I", "DFHGE" }));
    }




}
