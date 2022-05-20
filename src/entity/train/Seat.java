package entity.train;

public class Seat {
    private double price;
    private int num;
    private SeatType type;

    public Seat(String price, String num, String type) {
        this.price = Double.parseDouble(price);
        this.num = Integer.parseInt(num);
        this.type = CheckType(type);
    }

    public static SeatType CheckType(String arg) {
        SeatType st = null;
        switch (arg) {
            case "CC":
                st = SeatType.CC;
                break;
            case "SB":
                st = SeatType.SB;
                break;
            case "GG":
                st = SeatType.GG;
                break;
            case "SC":
                st = SeatType.SC;
                break;
            case "HC":
                st = SeatType.HC;
                break;
            case "1A":
                st = SeatType.K_1A;
                break;
            case "2A":
                st = SeatType.K_2A;
                break;
            default:
                break;
        }
        return st;
    }

    public void addNum(int n) {
        this.num += n;
    }

    public void subNum(int n) {
        this.num -= n;
    }

    public String getTypeStr() {
        if (type != SeatType.K_1A && type != SeatType.K_2A)
            return type.toString();
        else {
            if (type == SeatType.K_1A)
                return "1A";
            else
                return "2A";
        }
    }

    public SeatType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public int getNum() {
        return num;
    }


}
