package fofaps.apps.almox.items.lot;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "lot", schema = "items")
public class Lot {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "number_lote")
    private String numberLot;

    @Column(name = "number_serie")
    private String numberSerie;

    @Column(name = "description")
    private String description;


}
