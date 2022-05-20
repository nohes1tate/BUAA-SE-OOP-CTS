package entity.user;

public class Student extends User {
    private int discount;

    public Student(String[] command) {
        super(command);
        discount = Integer.parseInt(command[4]);
    }

    public void setDiscount(int num) {
        this.discount = num;
    }

    public int getDiscount() {
        return discount;
    }


    @Override
    public String toString() {
        return "Name:" + name + "\n" + "Sex:" + sex + "\n" + "Aadhaar:" + aadhaar + "\n" + "Discount:" + discount;
    }
}
