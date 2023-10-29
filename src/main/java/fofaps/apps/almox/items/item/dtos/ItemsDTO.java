package fofaps.apps.almox.items.item.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ItemsDTO {

    @NotBlank(message = "este campo não pode ficar vazio")
    private String name;
    private String barcode;
    private String model;
    private String numberSerie;
    private String description;
    @NotBlank(message = "este campo não pode ficar vazio")
    private Double price;
    private Boolean status;
}
