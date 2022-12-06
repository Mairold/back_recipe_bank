package ee.recipebank.backrecipebank.domain.recipe;

import ee.recipebank.backrecipebank.domain.recipe.preparationtime.PreparationTime;
import ee.recipebank.backrecipebank.domain.recipe.recipecategory.RecipeCategory;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_category_id", nullable = false)
    private RecipeCategory recipeCategory;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "preparation_time_id", nullable = false)
    private PreparationTime preparationTime;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "serving_size", nullable = false)
    private Integer servingSize;

    @Size(max = 2000)
    @NotNull
    @Column(name = "instructions", nullable = false, length = 2000)
    private String instructions;

    @NotNull
    @Column(name = "date_from", nullable = false)
    private LocalDate dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

}