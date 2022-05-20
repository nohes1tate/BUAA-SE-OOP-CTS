package entity.line;

import entity.train.TrainList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineList {
    private static List<Line> singalton = new ArrayList<>();
    private LineList(){}

    public static List<Line> getSingalton() {
        return singalton;
    }

    public static Line getLineByName(String Name){
        for (Line l:singalton ){
            if (Name.equals(l.getLineNo()))
                return l;
        }
        return null;
    }

    public static void addStation(int i,Station station){
        getSingalton().get(i).getStationList().add(station);
    }
    public static void delStation(int i,int j){
        getSingalton().get(i).getStationList().remove(j);
    }

    public static void sort() {
        Collections.sort(singalton);
    }

    public static Line getLineByTrain(String arg) {
        return getLineByName(TrainList.getTrainByNo(arg).getLineNo());
    }
}
