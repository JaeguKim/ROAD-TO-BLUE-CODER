import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomSortingComparator implements Comparator<Integer> {

    public int getLeftestDigit(Integer num){
        String s = Integer.toString(num.intValue());
        return Integer.parseInt(s.substring(0,1));
    }

    public int getSize(int num){
        return Integer.toString(num).length();
    }

    @Override
    public int compare(Integer o1, Integer o2) {
       if (getLeftestDigit(o1) != getLeftestDigit(o2)){
            return getLeftestDigit(o2) - getLeftestDigit(o1);
        }
        else if (getSize(o1) == getSize(o2)){
            return o2.intValue()-o1.intValue();
        }
        else{
            String firstCase = o1.toString()+o2.toString();
            String secondCase = o2.toString()+o1.toString();
            return Integer.parseInt(secondCase) - Integer.parseInt(firstCase);
        }
    }
}

public class LargestNumber {

    public String largestNumber(int[] nums) {
        
        List<Integer> arrayList = new ArrayList<>();
        int zeroCnt = 0;
        for (int num : nums){
            arrayList.add(num);
            if (num == 0)
                zeroCnt += 1;
        }
        if (zeroCnt == nums.length){
            return "0";
        }
        Collections.sort(arrayList, new CustomSortingComparator());
        String res = "";
        for (Integer num : arrayList){
            res += num;
        }
        return res;
    }
}