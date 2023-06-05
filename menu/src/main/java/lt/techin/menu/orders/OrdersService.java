package lt.techin.menu.orders;

import lt.techin.menu.orderslist.OrdersList;
import lt.techin.menu.orderslist.OrdersListRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrdersService {
    @Autowired
    OrdersRepository ordersRepository;
    @Autowired
    OrdersListRepository ordersListRepository;
    public OrdersService(OrdersRepository ordersRepository, OrdersListRepository ordersListRepository){
        this.ordersRepository = ordersRepository;
        this.ordersListRepository = ordersListRepository;
    }
    public Map<Orders, List<OrdersList>> getAll(int value) {
        Map<Orders,List<OrdersList>> map = new HashMap<>();
        if (value == 0) {
            List<Orders> orders = ordersRepository.findAllByConfirmed(0);
            orders.forEach(order -> map.put(order,ordersListRepository.findAllByOrders(order)));
            return map;
        } else if (value == 1) {
            List<Orders> orders = ordersRepository.findAllByConfirmed(1);
            orders.forEach(order -> map.put(order,ordersListRepository.findAllByOrders(order)));
            return map;
        } else {
            List<Orders> orders = ordersRepository.findAll();
            orders.forEach(order -> map.put(order,ordersListRepository.findAllByOrders(order)));
            return map;
        }
    }
    public Orders addOrder(List<OrdersList> ordersList){
        Orders orders = new Orders();
        orders.setConfirmed(0);
        ordersRepository.save(orders);
        for (OrdersList order : ordersList) {
            order.setOrders(orders);
        }
        ordersListRepository.saveAll(ordersList);
        return orders;
    }
    @Transactional
    public void deleteOrderList(Orders orders){
        ordersListRepository.deleteByOrders(orders);
    }
    public void deleteOrder(Long id){
        ordersRepository.deleteById(id);
    }

    public Orders confirmOrder(Long id){
        Orders tempOrder = ordersRepository.findOneById(id);
        tempOrder.setConfirmed(1);
        return ordersRepository.save(tempOrder);
    }
}
