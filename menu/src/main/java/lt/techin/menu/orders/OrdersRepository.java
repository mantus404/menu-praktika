package lt.techin.menu.orders;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Long> {
    List<Orders> findAllByConfirmed(int value);
    Orders findOneById(Long id);
}
