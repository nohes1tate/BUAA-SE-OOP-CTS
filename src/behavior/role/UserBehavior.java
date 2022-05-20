package behavior.role;

import behavior.ErrorBehavior;
import entity.line.Line;
import entity.line.LineList;
import entity.order.Order;
import entity.order.OrderInfo;
import entity.order.OrderList;
import entity.train.Seat;
import entity.train.SeatType;
import entity.train.Train;
import entity.train.TrainList;
import entity.user.LoginUser;
import entity.user.UserList;
import utils.Str;

import java.util.LinkedList;
import java.util.Objects;

public class UserBehavior {

    public static void Login(String[] args) {
        if (LoginUser.isLogin()) {
            System.out.println("You have logged in");
            return;
        }
        String aadhaar = args[1], name = args[2];
        if (UserList.CheckAadhaarExist(aadhaar)) {
            if (UserList.CheckUserExist(aadhaar, name)) {
                LoginUser.setLogin(true);
                LoginUser.setLoginUser(UserList.getUserByAadhaar(aadhaar));
                System.out.println("Login success");
            } else {
                System.out.println("Wrong name");
            }
        } else {
            System.out.println("User does not exist");
        }
    }

    public static void Logout() {
        if (LoginUser.isLogin()) {
            LoginUser.setLogin(false);
            LoginUser.LogOut();
            System.out.println("Logout success");
        } else {
            System.out.println("No user has logged in");
        }
    }

    public static void BuyTicket(String[] args) {
        String trainNo = args[1], startStation = args[2], endStation = args[3];
        SeatType seatType = Seat.CheckType(args[4]);
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
            return;
        }
        Train t;
        if ((t = TrainList.getTrainByNo(trainNo)) == null) {
            System.out.println("Train does not exist");
            return;
        }
        Line l = LineList.getLineByTrain(trainNo);
        if (l.getStationByName(startStation) == null || l.getStationByName(endStation) == null) {
            System.out.println("Station does not exist");
            return;
        }
        if (!t.CheckSeatMatch(seatType)) {
            System.out.println("Seat does not match");
            return;
        }
        if (!Str.isPosInt(args[5])) {
            System.out.println("Ticket number illegal");
            return;
        }
        int ticketNum = Integer.parseInt(args[5]);
        if (ticketNum > t.getSeatRemain(seatType)) {
            System.out.println("Ticket does not enough");
            return;
        }
        if ((args[4].equals("1A") || args[4].equals("2A")) && (!LoginUser.getCert())) {
            System.out.println("Cert illegal");
            return;
        }
        if (OrderList.getOrderByAadhaar(LoginUser.getAadhaar()) == null) {
            OrderList.creatNewUserOrder(LoginUser.getAadhaar());
        }
        Objects.requireNonNull(OrderList.getOrderByAadhaar(LoginUser.getAadhaar())).addOrderInfo(trainNo, startStation, endStation, seatType, ticketNum);
        t.reduceSeatNum(seatType, ticketNum);
        System.out.println("Thanks for your order");
    }

    public static void listOrder() {
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
        } else {
            Order o = OrderList.getOrderByAadhaar(LoginUser.getAadhaar());
            if (o == null || o.getOrders().size() == 0) {
                System.out.println("No order");
            } else {
                for (int i = o.getOrders().size() - 1; i >= 0; i--) {
                    System.out.println(o.getOrders().get(i).showInfo());
                }
            }
        }
    }

    public static void CancelOrder(String[] args) {
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
            return;
        }
        Order o = OrderList.getOrderByAadhaar(LoginUser.getAadhaar());
        if (o == null) {
            System.out.println("No such Record");
            return;
        }
        boolean exist = false, enough = false;
        int inOrder = 0, target;
        LinkedList<Integer> RemoveIndex = new LinkedList<>();
        target = Integer.parseInt(args[5]);
        OrderInfo tmpOInfo = null;
        int cancelNum=0;
        int i;
        for (i = o.getOrders().size() - 1; i >= 0; i--) {
            OrderInfo OInfo = o.getOrders().get(i);
            if (OInfo.match(args[2], args[3], args[4])) {
                if (!exist) {
                    exist = true;
                }
                if (!OInfo.isPaid() && OInfo.getTicketNum() < target - inOrder) {
                    inOrder += OInfo.getTicketNum();
                    RemoveIndex.add(i);
                } else if (!OInfo.isPaid() && OInfo.getTicketNum() == target - inOrder) {
                    RemoveIndex.add(i);
                    enough = true;
                    break;
                } else if (!OInfo.isPaid() && OInfo.getTicketNum() > target - inOrder) {
                    OInfo.reduceTicket(target - inOrder);
                    tmpOInfo = OInfo;
                    cancelNum = target - inOrder;
                    enough = true;
                    break;
                }
            }
        }
        if (!exist) {
            System.out.println("No such Record");
        }
        if (enough) {
            while (!RemoveIndex.isEmpty()) {
                Train t;
                OrderInfo OInfo = o.getOrders().get(RemoveIndex.getFirst());
                t = TrainList.getTrainByNo(OInfo.getTrainNo());
                assert t != null;
                t.addSeatNum(OInfo.getSeatType(),OInfo.getTicketNum());
                o.getOrders().remove(OInfo);
                RemoveIndex.removeFirst();
            }
            if(tmpOInfo!=null){
                Train t;
                t = TrainList.getTrainByNo(tmpOInfo.getTrainNo());
                assert t != null;
                t.addSeatNum(tmpOInfo.getSeatType(),cancelNum);
            }
            System.out.println("Cancel success");
        } else {
            System.out.println("No enough orders");
        }
    }

    public static void RechargeBalance(String[] args) {
        double b = Double.parseDouble(args[1]);
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
            return;
        }
        if (b < 0) {
            ErrorBehavior.ArgIllegal();
            return;
        }
        LoginUser.Recharge(b);
        System.out.println("Recharge Success");
    }

    public static void CheckBalance() {
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
            return;
        }
        String s = String.format("UserName:%s\nBalance:%.2f", LoginUser.getName(), LoginUser.getBalance());
        System.out.println(s);
    }

    public static void PayOrder() {
        if (!LoginUser.isLogin()) {
            System.out.println("Please login first");
            return;
        }
        double b = LoginUser.getBalance();
        double cost = 0;
        int discount = LoginUser.getDiscount();
        Order o = OrderList.getOrderByAadhaar(LoginUser.getAadhaar());
        if (o == null || o.getOrders().size() == 0) {
            System.out.println("No order");
            return;
        }
        for (int i = o.getOrders().size() - 1; i >= 0; i--) {
            OrderInfo OInfo = o.getOrders().get(i);
            if (!OInfo.isPaid()) {
                if (discount >= OInfo.getTicketNum()) {
                    cost += 0.05 * OInfo.getUnitPrice() * OInfo.getTicketNum();
                    discount -= OInfo.getTicketNum();
                } else {
                    cost += 0.05 * OInfo.getUnitPrice() * discount;
                    cost += OInfo.getUnitPrice() * (OInfo.getTicketNum() - discount);
                    discount = 0;
                }
            }
        }
        if (cost > b) {
            System.out.println("Balance does not enough");
        } else {
            LoginUser.setDiscount(discount);
            LoginUser.costBalance(cost);
            for (int i = o.getOrders().size() - 1; i >= 0; i--) {
                OrderInfo OInfo = o.getOrders().get(i);
                if (!OInfo.isPaid()) {
                    OInfo.setPaid(true);
                }
            }
            System.out.println("Payment success");
        }
    }
}
