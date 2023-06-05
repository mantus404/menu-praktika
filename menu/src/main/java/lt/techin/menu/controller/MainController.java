package lt.techin.menu.controller;

import lt.techin.menu.meal.Meal;
import lt.techin.menu.meal.MealService;
import lt.techin.menu.menu.Menu;
import lt.techin.menu.menu.MenuService;
import lt.techin.menu.orders.Orders;
import lt.techin.menu.orders.OrdersService;
import lt.techin.menu.orderslist.OrdersList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/main")
public class MainController {
    @Autowired
    MenuService menuService;
    @Autowired
    MealService mealService;
    @Autowired
    OrdersService ordersService;
    @GetMapping("/menu")
    public List<Menu> getAllMenu(){
        return menuService.getAll();
    }
    @GetMapping("/meal")
    public List<Meal> getAllMeal(){
        return mealService.getAll();
    }
    @PostMapping("/menu/")
    public Menu addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }
    @PostMapping("/meal")
    public Meal addMeal(@RequestBody Meal meal){
        return mealService.addMeal(meal);
    }
    @PatchMapping("/menu/{id}")
    public Menu editMenu(@PathVariable Long id, @RequestBody Menu menu){
        return menuService.editMenu(id, menu);
    }
    @PatchMapping("/meal/{id}")
    public Meal editMeal(@PathVariable Long id, @RequestBody Meal meal){
        return mealService.editMeal(id, meal);
    }
    @GetMapping("/{menuId}/meals")
    public List<Meal> getMeals(@PathVariable Long menuId) {
        Menu menu = menuService.findById(menuId);
        return mealService.findAllByMenu(menu);
    }
    @DeleteMapping("/menu/{id}")
    public void deleteMenu(@PathVariable Long id){
        menuService.deleteMenu(id);
    }
    @DeleteMapping("/meal/{id}")
    public void deleteMeal(@PathVariable Long id){
        mealService.deleteMeal(id);
    }
    @GetMapping("/orders/{cnfrm}")
    public Map<Orders, List<OrdersList>> getAllOrders(@PathVariable int cnfrm){
        return ordersService.getAll(cnfrm);
    }
    @PostMapping("/orders")
    public Orders addOrder(@RequestBody List<OrdersList> ordersList){
        return ordersService.addOrder(ordersList);
    }
    @PatchMapping("/orders/{id}")
    public Orders confirmOrder(@PathVariable Long id){
        return ordersService.confirmOrder(id);
    }
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Long id){
        Orders temp = new Orders();
        temp.setId(id);
        ordersService.deleteOrderList(temp);
        ordersService.deleteOrder(id);
    }
}
