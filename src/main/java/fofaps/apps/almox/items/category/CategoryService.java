package fofaps.apps.almox.items.category;

import fofaps.apps.almox.utils.exceptions.BadRequestExceptions;
import fofaps.apps.almox.utils.exceptions.NotFoundException;
import fofaps.apps.almox.utils.models.PaginatedData;
import fofaps.apps.almox.utils.models.Pagination;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepository categoryRepository;

  public Category create(Category category) throws BadRequestExceptions {
    if (categoryRepository.existsById(category.getName()))
      throw new BadRequestExceptions("Já existe uma categoria com esse nome..");
    return categoryRepository.save(category);
  }

  public PaginatedData<Category> findAll(CategoryCriteria criteria, Pageable pageable) {
    Specification<Category> specification = criteria.createSpecification(criteria);
    pageable =
        PageRequest.of(
            pageable.getPageNumber(), pageable.getPageSize(), Sort.by(Sort.Direction.ASC, "name"));
    Page<Category> category = categoryRepository.findAll(specification, pageable);
    return new PaginatedData<>(category.getContent(), Pagination.from(category, pageable));
  }

  public Category findById(String id) throws NotFoundException {
    return categoryRepository
        .findById(id)
        .orElseThrow(() -> new NotFoundException("Categoria não encontrada.."));
  }

  public Category putById(Category category, String id) throws NotFoundException {
    return categoryRepository
        .findById(id)
        .map(categoryRepository::save)
        .orElseThrow(() -> new NotFoundException("Categoria não encontrada"));
  }

  public void changeStatus(String id) throws NotFoundException {
    categoryRepository.findById(id).map(
            category -> {
              category.setStatus(!category.getStatus());
              return categoryRepository.save(category);
            }
    ).orElseThrow(() -> new NotFoundException("Categoria não encontrada.."));
  }
}
