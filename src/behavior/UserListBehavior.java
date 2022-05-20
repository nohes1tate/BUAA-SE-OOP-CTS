package behavior;

import entity.user.Student;
import entity.user.User;
import entity.user.UserList;

public class UserListBehavior {
    public static void addUser(String[] args){
        User tmpUsr = new User(args);
        if(!User.CheckName(tmpUsr)){
            System.out.println("Name illegal");
            return;
        }
        if(!User.CheckSex(tmpUsr)){
            System.out.println("Sex illegal");
            return;
        }
        if(!User.CheckAadhaar(tmpUsr)){
            System.out.println("Aadhaar number illegal");
            return;
        }
        boolean isUnique=true;
        for (User user : UserList.getUserList()) {
            if (user.GetAadhaar().equals(tmpUsr.GetAadhaar())) {
                System.out.println("Aadhaar number exist");
                isUnique = false;
                break;
            }
        }
        if(isUnique){
            if(args.length==5){
                Student tmpStu = new Student(args);
                UserList.getUserList().add(tmpStu);
                System.out.println(tmpStu);
            }
            else {
                UserList.getUserList().add(tmpUsr);
                System.out.println(tmpUsr);
            }
        }
    }
}
