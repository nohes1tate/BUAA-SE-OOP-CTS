package controller.role;

import behavior.ErrorBehavior;
import behavior.role.UserBehavior;

public class UserController {
    public static void Login(String[] args){
        if(args.length!=3){
            ErrorBehavior.ArgIllegal();
        }
        else {
            UserBehavior.Login(args);
        }
    }
    public static void Logout(String[] args){
        if(args.length!=1){
            ErrorBehavior.ArgIllegal();
        }
        else {
            UserBehavior.Logout();
        }
    }
    public static void BuyTicket(String[] args){
        if(args.length!=6){
            ErrorBehavior.ArgIllegal();
        }
        else {
            UserBehavior.BuyTicket(args);
        }
    }
    public static void listOrder(String[] args){
        if(args.length!=1){
            ErrorBehavior.ArgIllegal();
        }
        else {
            UserBehavior.listOrder();
        }
    }

    public static void RechargeBalance(String[] args) {
        if(args.length!=2){
            ErrorBehavior.ArgIllegal();
        }
        else {
            UserBehavior.RechargeBalance(args);
        }
    }
    public static void CheckBalance(String[] args){
        if(args.length!=1){
            ErrorBehavior.ArgIllegal();
        }else {
            UserBehavior.CheckBalance();
        }
    }
    public static void CancelOrder(String[] args){
        if(args.length!=6){
            ErrorBehavior.ArgIllegal();
        }else {
            UserBehavior.CancelOrder(args);
        }
    }
    public static void PayOrder(String[] args){
        if(args.length!=1){
            ErrorBehavior.ArgIllegal();
        }else {
            UserBehavior.PayOrder();
        }
    }
}
