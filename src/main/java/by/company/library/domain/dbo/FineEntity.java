package by.company.library.domain.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "fine")
public class FineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Amount")
    private BigDecimal amount;
    @Column(name = "Paid")
    private boolean paid;

    @OneToOne(mappedBy = "fine")
    private BookMovementEntity bookMovement;
}
