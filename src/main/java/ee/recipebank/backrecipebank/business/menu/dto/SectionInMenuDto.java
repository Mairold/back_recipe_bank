package ee.recipebank.backrecipebank.business.menu.dto;

import ee.recipebank.backrecipebank.domain.menu.sectioninmenu.SectionInMenu;
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
    private Integer sectionId;
    @Size(max = 100)
    @NotNull
    private String sectionName;
}