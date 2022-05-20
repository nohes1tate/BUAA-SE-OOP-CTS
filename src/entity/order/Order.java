package entity.order;

import entity.train.SeatType;

import java.util.ArrayList;

public class Order {
    private String userAadhaar;
    private ArrayList<OrderInfo> orders = new ArrayList<>();

    public Order(String userAadhaar) {
        this.userAadhaar = userAadhaar;
    }

    public ArrayList<OrderInfo> getOrders() {
        return orders;
    }

    public String getUserAadhaar() {
        return userAadhaar;
    }

    public void addOrderInfo(String trainNo, String startStation, String endStation, SeatType seatType, int ticketNum) {
        orders.add(new OrderInfo(trainNo, startStation, endStation, seatType, ticketNum));
    }
}
