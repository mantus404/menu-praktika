package lt.techin.menu.orderslist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersListService {
    @Autowired
    OrdersListRepository ordersListRepository;
    public OrdersListService(OrdersListRepository ordersListRepository){
        this.ordersListRepository = ordersListRepository;
    }
}
