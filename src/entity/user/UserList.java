package entity.user;


import java.util.ArrayList;
import java.util.List;

public class UserList {
    private static List<User> singalton = new ArrayList<>();
    private UserList(){}
    public static List<User> getUserList() {
        return singalton;
    }
    public static boolean CheckAadhaarExist(String aadhaar){
        for (User u:singalton){
            if(u.GetAadhaar().equals(aadhaar))
                return true;
        }
        return false;
    }
    public static boolean CheckUserExist(String aadhaar, String name){
        for(User u:singalton){
            if(u.GetName().equals(name)&&u.GetAadhaar().equals(aadhaar))
                return true;
        }
        return false;
    }
    public static User getUserByAadhaar(String aadhaar){
        for(User u:singalton){
            if(u.GetAadhaar().equals(aadhaar)){
                return u;
            }
        }
        return null;
    }
}
