package by.company.library.domain.dbo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "bin")
public class BinEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Floor")
    private int  floor;
    @Column(name = "Room")
    private int room;
    @Column(name = "Bin_No")
    private int binNo;

    @JsonIgnore
    @OneToMany(mappedBy = "bin")
    private Set<BookMovementEntity> booksMovement;

    {
        booksMovement = new HashSet<>();
    }
}
