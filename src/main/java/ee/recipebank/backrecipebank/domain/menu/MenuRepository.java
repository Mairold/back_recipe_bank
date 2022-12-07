package ee.recipebank.backrecipebank.domain.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Query("select m from Menu m where m.user.id = ?1 order by m.dateTimeAdded DESC")
    List<Menu> findAllByUserId(Integer id);

}