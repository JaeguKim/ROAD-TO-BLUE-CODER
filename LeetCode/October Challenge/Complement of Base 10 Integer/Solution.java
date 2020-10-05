import java.util.BitSet;

class Solution {
    public int bitwiseComplement(int N) {
        String input = Integer.toBinaryString(N);
        String reverse = "";
        for (int i=0; i<input.length(); i++){
            reverse += input.charAt(0) == '1' ? "0" : "1";
        }
        return Integer.parseInt(reverse, 2);
    }

}

