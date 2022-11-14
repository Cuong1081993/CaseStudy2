package Services;

import Model.Order;

import java.util.List;

public interface IOrderService {
    List<Order> findAllOrder();

    void add(Order newOrder);

    void editOrder(Order newOrder);

    void editOrder();

    Order findOrderById(Long idOrder);

    boolean existOrder(Long idOrder);
    List<Order> findOrderByUserId(Long idOrder);
}
