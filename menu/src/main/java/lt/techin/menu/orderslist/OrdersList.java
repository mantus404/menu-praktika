package lt.techin.menu.orderslist;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.techin.menu.meal.Meal;
import lt.techin.menu.menu.Menu;
import lt.techin.menu.orders.Orders;

import javax.persistence.*;

@Entity
@Table(name = "ORDERSLIST")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MEAL_ID")
    private Meal meal;
    @ManyToOne
    @JoinColumn(name = "ORDERS_ID")
    private Orders orders;
    private Long quantity;
}
