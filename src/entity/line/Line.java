package entity.line;

import java.util.ArrayList;
import java.util.Collections;

public class Line implements Comparable {
    private String lineNo;
    private int capacity;
    private int load=0;
    private ArrayList<Station> stationList = new ArrayList<>();

    public Line(String[] args){
        lineNo=args[1];
        capacity=Integer.parseInt(args[2]);
        for (int i=2;2*i<=args.length-1;i++){
            stationList.add(new Station(args[2*i-1],args[2*i]));
        }
    }

    @Override
    public int compareTo(Object newLine){
        return lineNo.compareTo(((Line)newLine).lineNo);
    }
    @Override
    public String toString(){
        StringBuilder toStr= new StringBuilder(lineNo + " " + load + "/" + capacity);
        Collections.sort(stationList);
        for (Station station : stationList) {
            toStr.append(" ").append(station.getStationName()).append(":").append(station.getStationMile());
        }
        return toStr.toString();
    }

    public int getLoad() {
        return load;
    }

    public void addLoad(){
        load++;
    }

    public void unLoad(){
        load--;
    }

    public String getLineNo() {
        return lineNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Station> getStationList() {
        return stationList;
    }

    public Station getStationByName(String stationName) {
        for(Station s: stationList){
            if(s.getStationName().equals(stationName))
                return s;
        }
        return null;
    }

    public void addStation(Station station) {
        stationList.add(station);
    }

    public void delStationByName(String stationName) {
        for(Station s: stationList){
            if(s.getStationName().equals(stationName)){
                stationList.remove(s);
                return;
            }
        }
    }

    public boolean CheckStation(String arg) {
        return getStationByName(arg)!=null;
    }

    public int getDistance(String arg, String arg1) {
        return Math.abs(getStationByName(arg).getStationMile()-getStationByName(arg1).getStationMile());
    }

    public boolean checkLoad() {
        return capacity>load;
    }
}
