package entity.train;

public enum SeatType {
    CC,SB,GG,SC,HC,K_1A,K_2A;

    @Override
    public String toString() {
        if(this.equals(SeatType.K_1A)){
            return "1A";
        }
        if(this.equals(SeatType.K_2A)){
            return "2A";
        }
        return super.toString();
    }
}
