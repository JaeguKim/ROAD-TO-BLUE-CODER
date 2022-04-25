package prob1396;

import java.util.HashMap;
import java.util.Map;

public class UndergroundSystem {

    private class CheckInInfo {
        private String station;
        private int t;
        public CheckInInfo(String station,int t) {
            this.station = station;
            this.t = t;
        }
        public String getStation() {
            return station;
        }
        public int getTime() {
            return t;
        }
    }

    private class AverageInfo {
        private int cnt;
        private int sum;
        public AverageInfo() {
            this.cnt = 0;
            this.sum = 0;
        }
        public void update(int diff) {
            cnt++;
            sum+=diff;
        }
        public double getAvg() {
            return sum/(double)cnt;
        }
    }

    private Map<Integer,CheckInInfo> checkInMp;
    private Map<String,AverageInfo> averageInfoMp;

    public UndergroundSystem() {
        checkInMp = new HashMap<>();
        averageInfoMp = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkInMp.put(id,new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo info = checkInMp.get(id);
        String key = info.getStation()+"-"+stationName;
        AverageInfo averageInfo = averageInfoMp.getOrDefault(key,new AverageInfo());
        averageInfo.update(t-info.getTime());
        averageInfoMp.put(key,averageInfo);
    }

    public double getAverageTime(String startStation, String endStation) {
        return averageInfoMp.get(startStation+"-"+endStation).getAvg();
    }
}
