package lt.techin.menu.meal;

import lt.techin.menu.menu.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    MealRepository mealRepository;
    public MealService(MealRepository mealRepository){
        this.mealRepository = mealRepository;
    }
    public List<Meal> getAll(){
        return mealRepository.findAll();
    }
    public Meal addMeal(Meal meal){
        return mealRepository.save(meal);
    }
    public List<Meal> findAllByMenu(Menu menu){
        return mealRepository.findAllByMenu(menu);
    }
    public Meal editMeal(Long id, Meal meal){
        Meal tempMeal = mealRepository.findOneById(id);
        tempMeal.setTitle(meal.getTitle());
        tempMeal.setDescription(meal.getDescription());
        tempMeal.setQuantity(meal.getQuantity());
        tempMeal.setMenu(meal.getMenu());
        return mealRepository.save(tempMeal);
    }
    public void deleteMeal(Long id){
        mealRepository.deleteById(id);
    }
}
