package behavior;

import entity.line.LineList;
import entity.train.Train;
import entity.train.TrainList;

import static utils.Str.isNonNegDouble;
import static utils.Str.isNonNegInteger;


public class TrainListBehavior {
    public static void addTrain(String[] args){
        if(TrainList.getTrainByNo(args[1])!=null){
            System.out.println("Train serial duplicate");
            return;
        }
        if(LineList.getLineByName(args[2])!=null&& LineList.getLineByName(args[2]).checkLoad()){
            for (int i=3;i<=args.length-1;i=i+2){
                if(!isNonNegDouble(args[i])){
                    System.out.println("Price illegal");
                    return;
                }
            }
            for (int i=4;i<=args.length-1;i=i+2){
                if(!isNonNegInteger(args[i])){
                    System.out.println("Ticket num illegal");
                    return;
                }
            }
            LineList.getLineByName(args[2]).addLoad();
            TrainList.getSingleton().add(new Train(args));
            System.out.println("Add Train Success");
        }
        else
            System.out.println("Line illegal");
    }
    public static void DelTrain(String[] args){
        if(TrainList.getTrainByNo(args[1])!=null){
            LineList.getLineByName(TrainList.getTrainByNo(args[1]).getLineNo()).unLoad();
            TrainList.getSingleton().remove(TrainList.getTrainByNo(args[1]));
            System.out.println("Del Train Success");
        }
        else {
            System.out.println("Train does not exist");
        }
    }
    public static void DelTrainOnLine(String lineName){
        TrainList.getSingleton().removeIf(t -> t.getLineNo().equals(lineName));
    }
    public static void CheckTicket(String[] args){
        if(TrainList.getTrainByNo(args[1])!=null) {
            int remain, distance;
            double price;
            if(LineList.getLineByTrain(args[1]).CheckStation(args[2])&&LineList.getLineByTrain(args[1]).CheckStation(args[3])){
                distance=LineList.getLineByTrain(args[1]).getDistance(args[2],args[3]);
                if(TrainList.getTrainByNo(args[1]).CheckSeatMatch(args[4])){
                    price=(double)distance*TrainList.getTrainByNo(args[1]).getSeatPrice(args[4]);
                    remain=TrainList.getTrainByNo(args[1]).getSeatRemain(args[4]);
                    System.out.printf("[%s: %s->%s] seat:%s remain:%d distance:%d price:%.2f%n",args[1],args[2],args[3],args[4],remain,distance,price);
                }
                else {
                    System.out.println("Seat does not match");
                }
            }
            else {
                System.out.println("Station does not exist");
            }
        }
        else{
            System.out.println("Train serial does not exist");
        }
    }
    public static void ListTrain(String[] args){
        TrainList.sort();
        int i=1;
        if(args.length==1){
            if(TrainList.getSingleton().isEmpty()){
                System.out.println("No Trains");
            }
            else {
                for (Train t : TrainList.getSingleton()) {
                    System.out.println(String.format("[%d] ", i) + t.getTrainInfo());
                    i++;
                }
            }
        }
        else {
            if(LineList.getLineByName(args[1])==null){
                System.out.println("Line does not exist");
            }
            else {
                if (LineList.getLineByName(args[1]).getLoad() == 0) {
                    System.out.println("No Trains");
                } else {
                    for (Train t : TrainList.getSingleton()) {
                        if (t.getLineNo().equals(args[1])) {
                            System.out.println(String.format("[%d] ", i) + t.getTrainInfo());
                            i++;
                        }
                    }
                }
            }
        }
    }
}
