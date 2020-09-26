class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int end = 0;
        for (int i=0; i<timeSeries.length; i++){
            int newEnd = timeSeries[i] + duration;
            if (timeSeries[i] >= end){
                res += duration;
            }
            else{
                res += newEnd-end;
            }
            end = newEnd;
        }
        return res;
    }
}