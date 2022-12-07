package ee.recipebank.backrecipebank.domain.ingridient.allowedmeasurements;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AllowedMeasurementUnitRepository extends JpaRepository<AllowedMeasurementUnit, Integer> {
    @Query("select a from AllowedMeasurementUnit a where a.ingredient.id = ?1")
    List<AllowedMeasurementUnit> findByIngredientId(Integer id);

}