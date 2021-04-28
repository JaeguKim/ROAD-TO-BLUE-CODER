package 다단계칫솔판매;

import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {

    @Test
    public void test1() {
        Solution sol = new Solution();
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"young", "john", "tod", "emily", "mary"};
        int[] amount = new int[]{12, 4, 2, 5, 10};
        int[] ans = new int[]{360, 958, 108, 0, 450, 18, 180, 1080};
        int[] actual = sol.solution(enroll,referral,seller,amount);
        for (int i=0;i<ans.length;i++) {
            Assert.assertEquals(ans[i],actual[i]);
        }
    }

    @Test
    public void test2() {
        Solution sol = new Solution();
        String[] enroll = new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = new String[]{"sam", "emily", "jaimie", "edward"};
        int[] amount = new int[]{2, 3, 5, 4};
        int[] ans = new int[]{0, 110, 378, 180, 270, 450, 0, 0};
        int[] actual = sol.solution(enroll,referral,seller,amount);
        for (int i=0;i<ans.length;i++) {
            Assert.assertEquals(ans[i],actual[i]);
        }
    }
}
