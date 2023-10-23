package fofaps.apps.almox.items.category.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CategoryDTO {

    @NotBlank(message = "Esse campo não pode estar vazio")
    private String name;

}
