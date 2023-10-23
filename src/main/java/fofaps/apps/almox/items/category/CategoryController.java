package fofaps.apps.almox.items.category;

import fofaps.apps.almox.items.category.dtos.CategoryDTO;
import fofaps.apps.almox.items.category.utils.CategoryUtils;
import fofaps.apps.almox.utils.exceptions.BadRequestExceptions;
import fofaps.apps.almox.utils.exceptions.NotFoundException;
import fofaps.apps.almox.utils.models.ApiResponse;
import fofaps.apps.almox.utils.models.PaginatedData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryUtils categoryUtils;
  private final CategoryService categoryService;

  @PostMapping
  public ResponseEntity<ApiResponse<Category>> create(
      @RequestBody CategoryDTO categoryDTO, BindingResult result) throws BadRequestExceptions {
    ApiResponse<Category> response = new ApiResponse<>();
    Category category = categoryUtils.transformDTOToEntity(categoryDTO);
    if (result.hasErrors()) Objects.requireNonNull(result.getFieldError().getDefaultMessage());
    response.of(
        HttpStatus.CREATED,
        "Categoria " + category.getName().toUpperCase() + " criada com sucesso",
        category);

    Category create = categoryService.create(category);
    return ResponseEntity.status(response.getStatus()).body(response);
  }

  @GetMapping
  public ResponseEntity<ApiResponse<PaginatedData<Category>>> findAll(
      CategoryCriteria criteria, @PageableDefault() Pageable pageable) {
    ApiResponse<PaginatedData<Category>> response = new ApiResponse<>();
    categoryService.findAll(criteria, pageable);
    response.of(HttpStatus.OK, "Lista de categorias");
    return ResponseEntity.status(response.getStatus()).body(response);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse<Category>> findById(@PathVariable String id)
      throws NotFoundException {
    ApiResponse<Category> response = new ApiResponse<>();
    Category findCategory = categoryService.findById(id);
    return ResponseEntity.status(response.getStatus()).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse<Category>> putCategory(
      @PathVariable String id, @RequestBody CategoryDTO categoryDTO, BindingResult result)
      throws NotFoundException {
    ApiResponse<Category> response = new ApiResponse<>();
    Category category = categoryUtils.transformDTOToEntity(categoryDTO);
    if (result.hasErrors()) Objects.requireNonNull(result.getFieldError().getDefaultMessage());
    categoryService.putById(category, id);
    response.of(
        HttpStatus.OK, "Categoria " + category.getName() + " editada com sucesso.", category);
    return ResponseEntity.status(response.getStatus()).body(response);
  }

  @PatchMapping("/delete/{id}")
  public ResponseEntity<ApiResponse<Category>> changeStatus(@PathVariable String id)
      throws NotFoundException {
    ApiResponse<Category> response = new ApiResponse<>();
    categoryService.changeStatus(id);
    response.of(HttpStatus.OK, "Categoria atualizada");
    return ResponseEntity.status(response.getStatus()).body(response);
  }
}
