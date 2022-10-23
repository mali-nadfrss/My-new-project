package com.mali.ds.design;

import java.util.HashMap;
import java.util.Map;

/* https://leetcode.com/problems/design-underground-system/ */
public class UndergroundSystem {
    class StationTime{
        int t;
        String station;
        public StationTime(int t, String station){
            this.t = t;
            this.station = station;
        }
    }

    Map<String, int[]> map;
    Map<Integer, StationTime> swipe;
    public UndergroundSystem() {
        map = new HashMap<>();
        swipe = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        StationTime st = new StationTime(t,stationName );
        swipe.put(id,st);
    }

    public void checkOut(int id, String stationName, int t) {
        String in = swipe.get(id).station;
        int intime = swipe.get(id).t;
        if(map.get(in+"|"+stationName) == null){
            map.put(in+"|"+stationName, new int[]{t-intime,1});
        } else{

            int c = map.get(in+"|"+stationName)[1];
            int total = map.get(in+"|"+stationName)[0];
            map.put(in+"|"+stationName, new int[]{total+(t-intime),c+1});

        }
    }

    public double getAverageTime(String startStation, String endStation) {
        int t = map.get(startStation+"|"+endStation)[0];
        int c = map.get(startStation+"|"+endStation)[1];
        return (double)t/c;
    }

    public static void main(String[] args) {

        UndergroundSystem undergroundSystem = new UndergroundSystem();
        undergroundSystem.checkIn(10, "Leyton", 3);
        undergroundSystem.checkOut(10, "Paradise", 8); // Customer 10 "Leyton" -> "Paradise" in 8-3 = 5
        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.00000, (5) / 1 = 5
        undergroundSystem.checkIn(5, "Leyton", 10);
        undergroundSystem.checkOut(5, "Paradise", 16); // Customer 5 "Leyton" -> "Paradise" in 16-10 = 6
        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 5.50000, (5 + 6) / 2 = 5.5
        undergroundSystem.checkIn(2, "Leyton", 21);
        undergroundSystem.checkOut(2, "Paradise", 30); // Customer 2 "Leyton" -> "Paradise" in 30-21 = 9
        undergroundSystem.getAverageTime("Leyton", "Paradise"); // return 6.66667, (5 + 6 + 9) / 3 = 6.66667
        System.out.println();
    }

}
