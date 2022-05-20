package controller.role;

import behavior.ErrorBehavior;
import behavior.TrainListBehavior;
import entity.train.Train;
import entity.train.TrainType;

public class TrainListController {
    public static void AddTrain(String[] args){
        if(!Train.CheckNo(args[1])) {
            ErrorBehavior.TrainSerialIllegal();
        }
        else{
            TrainType tt = Train.Type(args[1]);
            boolean flag=true;
            switch (tt){
                case Koya:
                    if(args.length!=7) {
                        ErrorBehavior.ArgIllegal();
                        flag = false;
                    }
                    break;
                case Normal:
                case Gati:
                    if(args.length!=9) {
                        ErrorBehavior.ArgIllegal();
                        flag = false;
                    }
                    break;
                default:
                    ErrorBehavior.UnError();
                    flag=false;
            }
            if(flag){
                TrainListBehavior.addTrain(args);
            }
        }
    }
    public static void DelTrain(String[] args){
        if(!Train.CheckNo(args[1])) {
            ErrorBehavior.TrainSerialIllegal();
        }
        else {
            if(args.length!=2){
                ErrorBehavior.ArgIllegal();
            }
            else {
                TrainListBehavior.DelTrain(args);
            }
        }
    }

    public static void CheckTicket(String[] args){
        if(!Train.CheckNo(args[1])) {
            ErrorBehavior.TrainSerialIllegal();
        }
        else {
            if(args.length!=5){
                ErrorBehavior.ArgIllegal();
            }
            else {
                TrainListBehavior.CheckTicket(args);
            }
        }
    }
    public static void ListTrain(String[] args){
        if(args.length!=1&&args.length!=2){
            ErrorBehavior.ArgIllegal();
        }
        else {
            TrainListBehavior.ListTrain(args);
        }
    }
}
