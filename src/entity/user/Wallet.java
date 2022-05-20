package entity.user;

public class Wallet {
    private double balance;
    public Wallet(){
        balance=0;
    }
    public void recharge(double c){
        balance+=c;
    }
    public void cost(double c){
        balance-=c;
    }

    public double getBalance() {
        return balance;
    }
}
