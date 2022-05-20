package entity.train;

import behavior.ErrorBehavior;

import java.util.ArrayList;

public class Train implements Comparable{
    private String trainNo;
    private String lineNo;
    private ArrayList<Seat> seatList = new ArrayList<>();
    private TrainType type;

    public Train(String[] args){
        this.trainNo=args[1];
        this.lineNo=args[2];
        this.type=Type(args[1]);
        switch (Type(args[1])){
            case Gati:
                seatList.add(new Seat(args[3],args[4],"SC"));
                seatList.add(new Seat(args[5],args[6],"HC"));
                seatList.add(new Seat(args[7],args[8],"SB"));
                break;
            case Koya:
                seatList.add(new Seat(args[3],args[4],"1A"));
                seatList.add(new Seat(args[5],args[6],"2A"));
                break;
            case Normal:
                seatList.add(new Seat(args[3],args[4],"CC"));
                seatList.add(new Seat(args[5],args[6],"SB"));
                seatList.add(new Seat(args[7],args[8],"GG"));
                break;
            default:
                ErrorBehavior.UnError();
        }
    }

    public String getLineNo() {
        return lineNo;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public static TrainType Type(String trainNo){
        if (trainNo.charAt(0)=='0'){
            return TrainType.Normal;
        }
        if (trainNo.charAt(0)=='G'){
            return TrainType.Gati;
        }
        return TrainType.Koya;
    }


    public static boolean CheckNo(String no){
        return no.matches("[0GK][0-9]{4}");
    }
    public boolean CheckSeatMatch(String ST){
        switch(type){
            case Gati:
                if(ST.equals("HC")||ST.equals("SC")||ST.equals("SB"))
                    return true;
                break;
            case Normal:
                if(ST.equals("CC")||ST.equals("SB")||ST.equals("GG"))
                    return true;
                break;
            case Koya:
                if(ST.equals("1A")||ST.equals("2A"))
                    return true;
                break;
            default:
                ErrorBehavior.UnError();
                break;
        }
        return false;
    }
    public boolean CheckSeatMatch(SeatType ST){
        switch(type){
            case Gati:
                if(ST.equals(SeatType.HC)||ST.equals(SeatType.SC)||ST.equals(SeatType.SB))
                    return true;
                break;
            case Normal:
                if(ST.equals(SeatType.CC)||ST.equals(SeatType.SB)||ST.equals(SeatType.GG))
                    return true;
                break;
            case Koya:
                if(ST.equals(SeatType.K_1A)||ST.equals(SeatType.K_2A))
                    return true;
                break;
            default:
                ErrorBehavior.UnError();
                break;
        }
        return false;
    }

    public double getSeatPrice(String arg) {
        SeatType st=Seat.CheckType(arg);
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                return s.getPrice();
            }
        }
        ErrorBehavior.UnError();
        return -1;
    }

    public double getSeatPrice(SeatType st){
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                return s.getPrice();
            }
        }
        ErrorBehavior.UnError();
        return -1;
    }

    public int getSeatRemain(String arg) {
        SeatType st=Seat.CheckType(arg);
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                return s.getNum();
            }
        }
        ErrorBehavior.UnError();
        return -1;
    }
    public int getSeatRemain(SeatType st) {
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                return s.getNum();
            }
        }
        ErrorBehavior.UnError();
        return -1;
    }
    public void reduceSeatNum(SeatType st,int num){
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                s.subNum(num);
                return;
            }
        }
        ErrorBehavior.UnError();
    }

    public int getTrainRank(){
        switch(type){
            case Koya:
                return 1;
            case Gati:
                return 2;
            default:
                return 3;
        }
    }
    public String getTrainInfo(){
        StringBuilder Info;
        Info = new StringBuilder(String.format("%s: %s", trainNo, lineNo));
        for (Seat s: seatList){
            Info.append(String.format(" [%s]%.2f:%d", s.getTypeStr(), s.getPrice(), s.getNum()));
        }
        return Info.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(this.getTrainRank()!=((Train)o).getTrainRank()){
            return this.getTrainRank()-((Train)o).getTrainRank();
        }
        else {
            return this.trainNo.compareTo(((Train)o).trainNo);
        }
    }

    public void addSeatNum(SeatType st, int num) {
        for(Seat s:seatList){
            if(s.getType().equals(st)){
                s.addNum(num);
                return;
            }
        }
        ErrorBehavior.UnError();
    }
}
