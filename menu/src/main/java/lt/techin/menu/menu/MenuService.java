package lt.techin.menu.menu;

import lt.techin.menu.meal.Meal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuRepository menuRepository;
    public MenuService(MenuRepository menuRepository){
        this.menuRepository = menuRepository;
    }
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }
    public Menu addMenu(Menu menu){
        return menuRepository.save(menu);
    }
    public Menu findById(Long id){
        return menuRepository.findOneById(id);
    }
    public Menu editMenu(Long id, Menu menu){
        Menu tempMenu = this.findById(id);
        tempMenu.setTitle(menu.getTitle());
        return menuRepository.save(tempMenu);
    }
    public void deleteMenu(Long id){
        menuRepository.deleteById(id);
    }

}
