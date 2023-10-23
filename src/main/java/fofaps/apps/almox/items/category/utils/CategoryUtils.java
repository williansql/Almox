package fofaps.apps.almox.items.category.utils;

import fofaps.apps.almox.items.category.Category;
import fofaps.apps.almox.items.category.dtos.CategoryDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryUtils {

  String name;

  private final ModelMapper modelMapper;

  public Category transformDTOToEntity(CategoryDTO categoryDTO) {
    return modelMapper.map(categoryDTO, Category.class);
  }

  public CategoryDTO transformEntityToDTO(Category category) {
      return modelMapper.map(category, CategoryDTO.class);
  }
}
