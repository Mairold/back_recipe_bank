package ee.recipebank.backrecipebank.domain.menu.sectioninmenu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SectionInMenuRepository extends JpaRepository<SectionInMenu, Integer> {
    @Query("select s from SectionInMenu s where s.menu.id = ?1")
    List<SectionInMenu> findBy(Integer MenuId);


}