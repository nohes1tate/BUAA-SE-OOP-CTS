package controller.terminal;

import application.Global;
import behavior.ErrorBehavior;
import behavior.QuitBehavior;
import terminal.TerminalType;

public class DefaultController {
    static public void quit(String[] args){
        if(args.length==1)
        {
            QuitBehavior.quit();
        }
        else
            ErrorBehavior.ArgIllegal();
    }
    static public void enterSudo(String[] args){
        if(args.length==1)
        {
            System.out.println("DuluDulu");
            Global.getInstance().setType(TerminalType.Sudo);
        }
        else
            ErrorBehavior.ArgIllegal();
    }
}
