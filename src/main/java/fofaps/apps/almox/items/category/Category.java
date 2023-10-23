package fofaps.apps.almox.items.category;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category", schema = "subcategory")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "status")
  private Boolean status = true;
}
