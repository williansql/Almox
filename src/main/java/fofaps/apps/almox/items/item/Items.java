package fofaps.apps.almox.items.item;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "items", schema = "items")
public class Items {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "barcode")
  private String barcode;

  @Column(name = "model")
  private String model;

  @Column(name = "number_serie")
  private String numberSerie;

  @Column(name = "description")
  private String description;

  @Column(name = "price")
  private Double price;

  @Column(name = "status")
  private Boolean status = true;
}
