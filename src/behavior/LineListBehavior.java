package behavior;

import behavior.role.LineBehavior;
import entity.line.Line;
import entity.line.LineList;
import entity.line.Station;
import utils.Str;

public class LineListBehavior {
    public static void DelLine(String[] args){
        if(LineList.getLineByName(args[1])!=null){
            LineList.getSingalton().remove(LineList.getLineByName(args[1]));
            TrainListBehavior.DelTrainOnLine(args[1]);
            System.out.println("Del Line success");
        }
        else
            System.out.println("Line does not exist");
    }
    public static void AddStation(String[] args){
        String lineNo=args[1];
        if(LineList.getLineByName(lineNo)!=null){
            String stationName = args[2];
            if(LineList.getLineByName(lineNo).getStationByName(stationName)==null){
                if(!Str.isNonNegInteger(args[3])){
                    ErrorBehavior.ArgIllegal();
                }
                else {
                    LineList.getLineByName(lineNo).addStation(new Station(stationName,args[3]));
                    System.out.println("Add Station success");
                }
            }
            else
                System.out.println("Station duplicate");
        }
        else
            System.out.println("Line does not exist");
    }

    public static void DelStation(String[] args){
        String lineNo = args[1];
        String stationName = args[2];
        if(LineList.getLineByName(lineNo)!=null){
            if(LineList.getLineByName(lineNo).getStationByName(stationName)!=null){
                LineList.getLineByName(lineNo).delStationByName(stationName);
                System.out.println("Delete Station success");
            }
            else {
                System.out.println("Station does not exist");
            }
        }
        else
            System.out.println("Line does not exist");
    }
    public static void AddLine (String[] args){
        for (int i=2;2*i<= args.length-1;i++){
            if(!Str.isNonNegInteger(args[2*i]))
            {
                ErrorBehavior.ArgIllegal();
                return;
            }
        }
        if(args.length>5) {
            for (int i = 2; 2 * i <= args.length - 1; i++) {
                for (int j = 1; j < i; j++) {
                    if (args[2 * i - 1].equals(args[2 * j - 1])) {
                        System.out.println("Station duplicate");
                        return;
                    }
                }
            }
        }
        Line tmpLine = new Line(args);
        if(LineList.getLineByName(tmpLine.getLineNo())!=null){
            System.out.println("Line already exists");
        }
        else{
            if(!LineBehavior.JudgeCapacity(tmpLine.getCapacity())){
                System.out.println("Capacity illegal");
            }
            else {
                LineList.getSingalton().add(tmpLine);
                System.out.println("Add Line success");
            }
        }
    }

    public static void LineInfo(String[] args) {
        String lineNo = args[1];
        if(LineList.getLineByName(lineNo)!=null){
            System.out.println(LineList.getLineByName(lineNo));
        }
        else
            System.out.println("Line does not exist");
    }

    public static void ListLine(String[] args) {
        if(LineList.getSingalton().size()==0){
            System.out.println("No Lines");
            return;
        }
        for(int i=0;i<LineList.getSingalton().size();i++){
            LineList.sort();
            System.out.println("[" + (i+1) + "]"+ " " +LineList.getSingalton().get(i).toString());
        }
    }
}
