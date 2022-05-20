package behavior;

import application.Global;
import terminal.TerminalType;

public class QuitBehavior {
    public static void quit(){
        System.out.println("----- Good Bye! -----");
        Global.getInstance().setType(TerminalType.QUIT);
    }
}
