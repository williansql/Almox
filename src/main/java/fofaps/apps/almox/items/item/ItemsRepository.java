package fofaps.apps.almox.items.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemsRepository extends JpaRepository<Items, String> {

    Optional<Items> findByNameIgnoreCase(String name);
}
