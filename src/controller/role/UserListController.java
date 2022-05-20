package controller.role;

import behavior.ErrorBehavior;
import behavior.UserListBehavior;

public class UserListController {
    public static void AddUser(String[] args){
        if(args.length!=4&&args.length!=5)
            ErrorBehavior.ArgIllegal();
        else
            UserListBehavior.addUser(args);
    }
}
