package controller.role;

import behavior.ErrorBehavior;
import behavior.LineListBehavior;

public class LineListController {
    public static void DelLine(String[] args){
        if(args.length!=2)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.DelLine(args);
    }
    public static void AddStation(String[] args) {
        if(args.length!=4)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.AddStation(args);
    }
    public static void DelStation(String[] args) {
        if (args.length != 3)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.DelStation(args);
    }
    public static void AddLine (String[] args){
        if(args.length<5||args.length%2!=1)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.AddLine(args);
    }
    public static void LineInfo(String[] args) {
        if(args.length!=2)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.LineInfo(args);
    }

    public static void ListLine(String[] args) {
        if (args.length != 1)
            ErrorBehavior.ArgIllegal();
        else
            LineListBehavior.ListLine(args);
    }
}
