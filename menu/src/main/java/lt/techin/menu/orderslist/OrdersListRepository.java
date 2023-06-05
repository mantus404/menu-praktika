package lt.techin.menu.orderslist;

import lt.techin.menu.orders.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersListRepository extends JpaRepository<OrdersList,Long> {
    List<OrdersList> findAllByOrders(Orders orders);
    void deleteByOrders(Orders orders);
}
