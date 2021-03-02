import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {

    public int getSize(int num){
        String s = Integer.toString(num);
        return s.length();
    }

    public int getSequntialNum(int startNum,int size){
        int cur = startNum;
        String s = "";
        for (int i=0; i<size; ++i){
            if (cur+i > 9){
                return -1;
            }
            s += Integer.toString(cur+i);
        }
        return Integer.parseInt(s);
    }

    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int startSize = getSize(low);
        int endSize = getSize(high);
        for (int size=startSize; size<=endSize; ++size){
            for (int start=1; start<9; ++start){
                int candidate = getSequntialNum(start, size);
                if (candidate >= low && candidate <= high){
                    res.add(Integer.valueOf(candidate));
                }
            }
        }
        return res;
    }   
}
