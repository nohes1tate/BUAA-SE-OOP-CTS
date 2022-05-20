package entity.order;

import entity.line.LineList;
import entity.train.SeatType;
import entity.train.TrainList;

public class OrderInfo {
    private String trainNo;
    private String startStation;
    private String endStation;
    private SeatType seatType;
    private int ticketNum;
    private boolean paid;

    public OrderInfo(String trainNo, String startStation, String endStation, SeatType seatType, int ticketNum) {
        this.trainNo = trainNo;
        this.startStation = startStation;
        this.endStation = endStation;
        this.seatType = seatType;
        this.ticketNum = ticketNum;
        paid = false;
    }

    public String getTrainNo() {
        return trainNo;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public int getTicketNum() {
        return ticketNum;
    }

    public void reduceTicket(int num) {
        ticketNum -= num;
    }

    public boolean isPaid() {
        return paid;
    }

    public String showInfo() {
        String s;
        double price;
        int distance;
        distance = LineList.getLineByTrain(trainNo).getDistance(startStation, endStation);
        price = (double) distance * ticketNum * TrainList.getTrainByNo(trainNo).getSeatPrice(seatType);
        s = String.format("[%s: %s->%s] seat:%s num:%d price:%.2f paid:%s", trainNo, startStation, endStation, seatType.toString(), ticketNum, price, paid ? "T" : "F");
        return s;
    }

    public boolean match(String start, String end, String st) {
        return start.equals(startStation) && end.equals(endStation) && st.equals(seatType.toString());
    }

    public double getUnitPrice() {
        int distance = LineList.getLineByTrain(trainNo).getDistance(startStation, endStation);
        return (double) distance * TrainList.getTrainByNo(trainNo).getSeatPrice(seatType);
    }
}
