package entity.user;

public class LoginUser {
    private static User loginUser;
    private static boolean login = false;

    public static boolean isLogin() {
        return login;
    }

    public static double getBalance() {
        return loginUser.usrWallet.getBalance();
    }

    public static String getName() {
        return loginUser.GetName();
    }

    public static void setLoginUser(User u) {
        loginUser = u;
    }

    public static void setLogin(boolean login) {
        LoginUser.login = login;
    }

    public static void LogOut() {
        loginUser = null;
    }

    public static String getAadhaar() {
        return loginUser.GetAadhaar();
    }

    public static boolean getCert() {
        return Cert.getCert(loginUser.GetAadhaar());
    }

    public static void Recharge(double b) {
        loginUser.usrWallet.recharge(b);
    }

    public static int getDiscount() {
        if (loginUser.getClass().equals(Student.class)) {
            return ((Student) loginUser).getDiscount();
        }
        return 0;
    }

    public static void setDiscount(int num) {
        ((Student) loginUser).setDiscount(num);
    }

    public static void costBalance(double d) {
        loginUser.getUsrWallet().cost(d);
    }
}
