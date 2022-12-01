package ee.recipebank.backrecipebank.domain.recipe;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

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
    private Instant dateFrom;

    @Column(name = "date_to")
    private LocalDate dateTo;

}