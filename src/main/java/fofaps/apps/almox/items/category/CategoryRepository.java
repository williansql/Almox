package fofaps.apps.almox.items.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

  Optional<Category> findByNameIgnoreCase(String name);
}
