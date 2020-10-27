import java.util.ArrayList;
import java.util.List;

class Solution {

    public double champagneTower(int poured, int query_row, int query_glass) {
        List<Double> li = new ArrayList<>();
        li.add((double)poured);
        int row = 1;
        while (row <= query_row){
            List<Double> temp = new ArrayList<>();
            temp.add(li.get(0)/2);
            for (int i=1;i<li.size();i++){
                temp.add(li.get(i-1)/2+li.get(i));
            }
            temp.add(temp.get(0));
            li = new ArrayList<>(temp);
            row++;
        }
        return Math.min(li.get(query_glass),1);
    }
}