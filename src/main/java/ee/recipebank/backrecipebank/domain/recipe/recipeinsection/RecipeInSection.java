package ee.recipebank.backrecipebank.domain.recipe.recipeinsection;

import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenu;
import ee.recipebank.backrecipebank.domain.recipe.recipe.Recipe;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "recipe_in_section")
public class RecipeInSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "section_in_menu_id", nullable = false)
    private SectionInMenu sectionInMenu;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "recipe_id", nullable = false)
    private Recipe recipe;

    @NotNull
    @Column(name = "planned_serving_size", nullable = false)
    private Integer plannedServingSize;

    @Size(max = 255)
    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "date_time_added", nullable = false)
    private Instant dateTimeAdded;

    @Column(name = "date_time_modified")
    private Instant dateTimeModified;

}