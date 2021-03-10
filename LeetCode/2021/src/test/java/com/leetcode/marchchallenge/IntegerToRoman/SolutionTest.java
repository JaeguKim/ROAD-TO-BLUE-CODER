package com.leetcode.marchchallenge.IntegerToRoman;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution sol;

    @Before
    public void setup() {
        sol = new Solution();
    }

    @Test
    public void testIntegerToRoman() {
        Assert.assertEquals("III",sol.intToRoman(3));
        Assert.assertEquals("IV",sol.intToRoman(4));
        Assert.assertEquals("IX",sol.intToRoman(9));
        Assert.assertEquals("LVIII",sol.intToRoman(58));
        Assert.assertEquals("MCMXCIV",sol.intToRoman(1994));
    }
}
