package ee.recipebank.backrecipebank.business.menu.dto;

import ee.recipebank.backrecipebank.domain.menu.menu.Menu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link Menu} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MenuResponse implements Serializable {
    private Integer menuId;
    @Size(max = 100)
    @NotNull
    private Instant menuDate;
}