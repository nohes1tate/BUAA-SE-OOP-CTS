package entity.train;

import java.util.ArrayList;
import java.util.Collections;

public class TrainList {
    private static ArrayList<Train> singleton = new ArrayList<>();
    private TrainList(){}

    public static ArrayList<Train> getSingleton() {
        return singleton;
    }
    public static Train getTrainByNo(String no){
        for(Train t:singleton){
            if(no.equals(t.getTrainNo()))
                return t;
        }
        return null;
    }
    public static void sort(){
        Collections.sort(singleton);
    }
}
