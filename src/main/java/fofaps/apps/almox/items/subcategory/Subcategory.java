package fofaps.apps.almox.items.subcategory;

import fofaps.apps.almox.items.category.Category;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "subcategory", schema = "items")
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private Boolean status = true;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}




