package lt.techin.menu.meal;

import lt.techin.menu.menu.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MealRepository extends JpaRepository<Meal,Long> {
    List<Meal> findAllByMenu(Menu menu);
    Meal findOneById(Long id);
}
