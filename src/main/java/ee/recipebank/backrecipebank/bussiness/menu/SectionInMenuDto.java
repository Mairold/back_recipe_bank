package ee.recipebank.backrecipebank.bussiness.menu;

import ee.recipebank.backrecipebank.domain.menu.SectionInMenu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A DTO for the {@link SectionInMenu} entity
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SectionInMenuDto implements Serializable {
    private Integer id;
    @Size(max = 100)
    @NotNull
    private String name;
}