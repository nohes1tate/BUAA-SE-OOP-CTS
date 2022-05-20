package entity.order;

import java.util.ArrayList;

public class OrderList {
    private static ArrayList<Order> singalton = new ArrayList<>();
    private OrderList(){}

    public static ArrayList<Order> getSingalton() {
        return singalton;
    }
    public static Order getOrderByAadhaar(String aadhaar){
        for (Order o:singalton){
            if(o.getUserAadhaar().equals(aadhaar))
                return o;
        }
        return null;
    }
    public static void creatNewUserOrder(String aadhaar){
        singalton.add(new Order(aadhaar));
    }

}
