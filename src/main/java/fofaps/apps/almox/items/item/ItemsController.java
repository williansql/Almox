package fofaps.apps.almox.items.item;


import fofaps.apps.almox.items.item.dtos.ItemsDTO;
import fofaps.apps.almox.items.item.utils.ItemsUtils;
import fofaps.apps.almox.utils.exceptions.BadRequestExceptions;
import fofaps.apps.almox.utils.models.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("itens")
@RequiredArgsConstructor
public class ItemsController {

    private final ItemsService service;
    private final ItemsUtils itemsUtils;

    public ResponseEntity<ApiResponse<Items>> create(
            @Valid @RequestBody ItemsDTO itemsDTO, BindingResult result)
            throws BadRequestExceptions {
        ApiResponse<Items> response = new ApiResponse<>();
        Items items = itemsUtils.transformDTOToEntity(itemsDTO);
        if (result.hasErrors())
            Objects.requireNonNull(result.getFieldError().getDefaultMessage());
        service.create(items);
        response.of(HttpStatus.CREATED, "Item criado com sucesso", items);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    public ResponseEntity<ApiResponse<List<Items>>> findAll(@PageableDefault(size = 7)Pageable pageable){
        ApiResponse<List<Items>> response = new ApiResponse<>();
        service.findAll(pageable);
        response.of(HttpStatus.FOUND, "Lista de itens");
        return ResponseEntity.status(response.getStatus()).body(response);

    }
}
