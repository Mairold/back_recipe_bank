package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglistingredient;

import ee.recipebank.backrecipebank.domain.ingridient.Ingredient;
import ee.recipebank.backrecipebank.domain.ingridient.group.IngredientGroup;
import ee.recipebank.backrecipebank.domain.ingridient.measurement.MeasurementUnit;
import ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist.ShoppingList;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "shopping_list_ingredient")
public class ShoppingListIngredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "is_custom", nullable = false)
    private Boolean isCustom = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ingredient_group_id")
    private IngredientGroup ingredientGroup;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingList shoppingList;

    @Column(name = "quantity", precision = 6, scale = 2)
    private BigDecimal quantity;

    @NotNull
    @Column(name = "date_time_added", nullable = false)
    private Instant dateTimeAdded;

    @Column(name = "date_time_modified")
    private Instant dateTimeModified;

    @Size(max = 1)
    @NotNull
    @Column(name = "status", nullable = false, length = 1)
    private String status;

}