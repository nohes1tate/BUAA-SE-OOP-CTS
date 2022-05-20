package behavior;

public class ErrorBehavior {
    static public void ArgIllegal(){
        System.out.println("Arguments illegal");
    }
    static public void UnError(){
        System.out.println("Unknown error");
    }
    static public void CmdError(){ System.out.println("Command does not exist"); }
    static public void AccessError(){ System.out.println("WanNiBa"); }
    static public void TrainSerialIllegal(){ System.out.println("Train serial illegal"); }
}
