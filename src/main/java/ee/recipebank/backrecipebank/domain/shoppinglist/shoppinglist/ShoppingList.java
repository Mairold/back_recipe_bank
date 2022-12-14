package ee.recipebank.backrecipebank.domain.shoppinglist.shoppinglist;

import ee.recipebank.backrecipebank.domain.menu.menu.Menu;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "shopping_list")
public class ShoppingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @NotNull
    @Column(name = "date_time_added", nullable = false)
    private Instant dateTimeAdded;

    @Size(max = 255)
    @Column(name = "comment")
    private String comment;

}