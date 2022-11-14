package Services;

import Model.Order;
import Utilities.AppUtils;
import Utilities.CSVUtils;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class OrderService implements IOrderService {
    private static OrderService instanceOrder;

    public OrderService() {

    }

    public static OrderService getInstance() {
        if (instanceOrder == null) {
            instanceOrder = new OrderService();
        }
        return instanceOrder;
    }

    @Override
    public List<Order> findAllOrder() {
        List<Order> orderList = new ArrayList<>();
        List<String> records = CSVUtils.readFile(AppUtils.PATH_ORDER);
        for (String record : records) {
            orderList.add(Order.parseOrder(record));
        }
        return orderList;
    }

    @Override
    public void add(Order newOrder) {
        List<Order> orderList = findAllOrder();
        newOrder.setTimeCreatOrder(Instant.now());
        orderList.add(newOrder);
        CSVUtils.writeFile(AppUtils.PATH_ORDER, orderList);
    }

    @Override
    public void editOrder(Order newOrder) {
        List<Order> orderList = findAllOrder();
        for (Order order : orderList) {
            if (order.getIdOrder().equals(newOrder.getIdOrder())) {
                String fullName = order.getFullName();
                if (fullName != null && !fullName.isEmpty()) {
                    order.setFullName(fullName);
                }
                String mobile = order.getMobile();
                if (mobile != null && !mobile.isEmpty()) {
                    order.setMobile(mobile);
                }
                String address = order.getAddress();
                if (address != null && !address.isEmpty()) {
                    order.setAddress(address);
                }
                order.setTimeCreatOrder(Instant.now());
                CSVUtils.writeFile(AppUtils.PATH_ORDER, orderList);
                break;
            }
        }
    }

        @Override
        public void editOrder () {
            List<Order> orders = findAllOrder();
            CSVUtils.writeFile(AppUtils.PATH_ORDER, orders);
        }

        @Override
        public Order findOrderById (Long idOrder){
            List<Order> orderList = findAllOrder();
            for (Order order : orderList) {
                if (order.getIdOrder().equals(idOrder)){
                    return order;
                }
            }
            return null;
        }

        @Override
        public boolean existOrder (Long idOrder){
            return findOrderById(idOrder)!=null;
        }

        @Override
        public List<Order> findOrderByUserId (Long idOrder){
            List<Order> orderList =findAllOrder();
            for (Order order:orderList) {
                if (order.getIdOrder().equals(idOrder)){
                    orderList.add(order);
                }
                return orderList;
            }
            return null;
        }
    }
