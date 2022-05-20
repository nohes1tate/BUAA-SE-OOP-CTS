package terminal;

import behavior.ErrorBehavior;
import controller.role.*;
import controller.terminal.SudoController;

public class Sudo {
    // singleton
    private static final Sudo singalton = new Sudo();
    private Sudo() {}

    public static Sudo getTerminal() {
        return singalton;
    }

    // terminal main process
    public void run(String[] args) {
        switch (args[0]) {
            case "QUIT":
                SudoController.quit(args);
                break;
            case "TunakTunakTun":
                ErrorBehavior.AccessError();
                break;
            case "NutKanutKanut":
                SudoController.QuitSudo(args);
                break;
            case "addUser":
                UserListController.AddUser(args);
                break;
            case "addLine":
                LineListController.AddLine(args);
                break;
            case "delLine":
                LineListController.DelLine(args);
                break;
            case "addStation":
                LineListController.AddStation(args);
                break;
            case "delStation":
                LineListController.DelStation(args);
                break;
            case "lineInfo":
                LineListController.LineInfo(args);
                break;
            case "listLine":
                LineListController.ListLine(args);
                break;
            case "addTrain":
                TrainListController.AddTrain(args);
                break;
            case "delTrain":
                TrainListController.DelTrain(args);
                break;
            case "listTrain":
                TrainListController.ListTrain(args);
                break;
            case "login":
                UserController.Login(args);
                break;
            case "logout":
                UserController.Logout(args);
                break;
            case "buyTicket":
                UserController.BuyTicket(args);
                break;
            case "listOrder":
                UserController.listOrder(args);
                break;
            case "rechargeBalance":
                UserController.RechargeBalance(args);
                break;
            case "checkBalance":
                UserController.CheckBalance(args);
                break;
            case "importCert":
                CertController.ImportCert(args);
                break;
            case "cancelOrder":
                UserController.CancelOrder(args);
                break;
            case "payOrder":
                UserController.PayOrder(args);
                break;
            default : ErrorBehavior.CmdError();
        }
    }
}
