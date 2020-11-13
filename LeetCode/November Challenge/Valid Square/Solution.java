import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* TIME : NlogN, Space : N */
public class Point implements Comparable<Point>{
    int x,y;
    
    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        if (x != o.x){
            return (x > o.x) ? 1 : -1;
        }
        else {
            return (y > o.y) ? 1 : -1;
        }
    }

}

class Solution {
   
    public int getDist(Point src, Point dst){
        int xDiff = Math.abs(src.x-dst.x);
        int yDiff = Math.abs(src.y-dst.y);
        return xDiff*xDiff + yDiff*yDiff;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Point> list = new ArrayList<>();
        list.add(new Point(p1[0],p1[1]));
        list.add(new Point(p2[0],p2[1]));
        list.add(new Point(p3[0],p3[1]));
        list.add(new Point(p4[0],p4[1]));
        Collections.sort(list);
        int AB = getDist(list.get(0),list.get(1));
        int BC = getDist(list.get(1),list.get(2));
        int BD = getDist(list.get(1),list.get(3));
        int CD = getDist(list.get(2),list.get(3));
        int AC = getDist(list.get(0),list.get(2));
        
        if (AB <= 0 || BD <= 0 || CD <= 0 || AC <= 0) return false;
        else if (AB == BD && BD == CD && CD == AC && BC == 2*AB){
            return true;
        }
        else
            return false;
    }
}

/* TIME : O(1), Space : O(1) */
class Solution {
   
    public int getDist(int[] src, int[] dst){
        int xDiff = Math.abs(src[0]-dst[0]);
        int yDiff = Math.abs(src[1]-dst[1]);
        return xDiff*xDiff + yDiff*yDiff;
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(getDist(p1,p2));
        list.add(getDist(p1,p3));
        list.add(getDist(p1,p4));
        list.add(getDist(p2,p3));
        list.add(getDist(p2,p4));
        list.add(getDist(p3,p4));
        for (int dist : list){
            if (!map.containsKey(dist)) map.put(dist,1);
            else map.put(dist,map.get(dist)+1);
        }
        if (map.size() != 2) return false;
        Iterator<Integer> iter = map.keySet().iterator();
        int dist = iter.next();
        if (map.get(dist) == 4 || map.get(dist) == 2) return true;
        return false;
    }
}