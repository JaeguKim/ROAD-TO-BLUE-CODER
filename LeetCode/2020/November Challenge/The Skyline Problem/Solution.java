import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

class BuildingPoint implements Comparable<BuildingPoint> {
    int x;
    boolean isStart;
    int height;

    @Override
    public int compareTo(BuildingPoint o) {
        if (this.x != o.x) {
            return this.x - o.x;
        } else {
            return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
        }
    }

}

// TreeMap을 사용한 이유 : PriorityQueue는 remove연산이 O(N)만큼 걸리므로 TreeMap을 사용
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length*2];
        int index = 0;
        for (int building[] : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];

            buildingPoints[index+1] = new BuildingPoint();
            buildingPoints[index+1].x = building[1];
            buildingPoints[index+1].isStart = false;
            buildingPoints[index+1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);
        TreeMap<Integer, Integer> queue = new TreeMap<>();
        queue.put(0,1);
        int prevMaxHeight = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (BuildingPoint buildingPoint : buildingPoints) {
            if (buildingPoint.isStart) {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value != null) {
                        return value + 1;
                    }
                    return 1;
                });
            } else {
                queue.compute(buildingPoint.height, (key, value) -> {
                    if (value == 1) {
                        return null;
                    }
                    return value - 1;
                });
            }
            int currentMaxHeight = queue.lastKey();
            if (prevMaxHeight != currentMaxHeight) {
                result.add(Arrays.asList(new Integer[]{buildingPoint.x, currentMaxHeight}));
                prevMaxHeight = currentMaxHeight;
            }
        }
        return result;
    }
}