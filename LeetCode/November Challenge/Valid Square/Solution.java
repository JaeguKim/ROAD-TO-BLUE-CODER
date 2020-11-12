import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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