
class JavaSubstringComparisons {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        String minSubstr = s.substring(0,k);
        String maxSubstr = s.substring(0,k);
        for (int i=1; i<=s.length()-k; i++){
            String ss = s.substring(i,i+k);
            if (ss.compareTo(minSubstr) < 0){
                minSubstr = ss;
            }
            if (ss.compareTo(maxSubstr) > 0){
                maxSubstr = ss;
            }
        }
        return minSubstr + "\n" + maxSubstr;
    }

}