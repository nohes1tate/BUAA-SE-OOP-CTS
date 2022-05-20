package terminal;

import behavior.ErrorBehavior;
import controller.role.*;
import controller.terminal.DefaultController;

public class Default {

    // singleton
    private static final Default sington = new Default();
    private Default() {}

    public static Default getTerminal() {
        return sington;
    }

    // terminal main process
    public void run(String[] args) {
        switch (args[0]) {
            case "QUIT":
                DefaultController.quit(args);
                break;
            case "TunakTunakTun":
                DefaultController.enterSudo(args);
                break;
            case "NutKanutKanut":
                ErrorBehavior.AccessError();
                break;
            case "addUser":
                UserListController.AddUser(args);
                break;
            case "lineInfo":
                LineListController.LineInfo(args);
                break;
            case "listLine":
                LineListController.ListLine(args);
                break;
            case "checkTicket":
                TrainListController.CheckTicket(args);
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
