package controller.terminal;

import application.Global;
import behavior.ErrorBehavior;
import behavior.QuitBehavior;
import terminal.TerminalType;

public class SudoController {
    static public void quit(String[] args){
        if(args.length==1)
        {
            QuitBehavior.quit();
        }
        else
            ErrorBehavior.ArgIllegal();
    }
    static public void QuitSudo(String[] args){
        if(args.length==1)
        {
            System.out.println("DaDaDa");
            Global.getInstance().setType(TerminalType.Default);
        }
        else
            ErrorBehavior.ArgIllegal();
    }
}
