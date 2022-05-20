package entity.user;

public class User {
    protected String name;
    protected String sex;
    protected String aadhaar;
    protected Wallet usrWallet;

    public User(String[] command) {
        name = command[1];
        sex = command[2];
        aadhaar = command[3];
        usrWallet = new Wallet();
    }

    public String GetName() {
        return name;
    }

    public String GetSex() {
        return sex;
    }

    public String GetAadhaar() {
        return aadhaar;
    }

    public String toString() {
        return "Name:" + name + "\n" + "Sex:" + sex + "\n" + "Aadhaar:" + aadhaar;
    }

    public static boolean CheckName(User user) {
        String regex = "[a-zA-Z_]+";
        return user.GetName().matches(regex);
    }

    public static boolean CheckSex(User user) {
        String regex = "[FMO]";
        return user.GetSex().matches(regex);
    }

    public static boolean CheckAadhaar(User user) {
        String regex = "[0-9]+";
        if (!user.GetAadhaar().matches(regex) && user.GetAadhaar().length() != 12)
            return false;
        int num1 = Integer.parseInt(user.GetAadhaar().substring(0, 4));
        int num2 = Integer.parseInt(user.GetAadhaar().substring(4, 8));
        int num3 = Integer.parseInt(user.GetAadhaar().substring(8, 11));
        int num4 = Integer.parseInt(user.GetAadhaar().substring(11, 12));
        if (1 <= num1 && num1 <= 1237 && 20 <= num2 && num2 <= 460 && num3 <= 100 && num4 <= 2) {
            return (num4 == 0 && user.GetSex().equals("F")) || (num4 == 1 && user.GetSex().equals("M")) || (num4 == 2 && user.GetSex().equals("O"));
        }
        return false;
    }

    public Wallet getUsrWallet() {
        return usrWallet;
    }
}
