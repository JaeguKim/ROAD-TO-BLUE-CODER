class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] ary = s.split(" ");
        for (int i=ary.length-1; i>-1; i--){
            if (ary[i].length() > 0){
                return ary[i].length();
            }
        } 
        return 0;         
    }
}