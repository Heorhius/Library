package by.company.library.domain.dbo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class BookEntity {

    @Id
    @Column(name = "ISBN")
    private String isbn;
    @Column(name = "Name")
    private String name;
    @CreatedDate
    @Column(name = "Publishing_date")
    private Date publishingDate;
    @Column(name = "Price")
    private BigDecimal price;
    @Column(name = "In_stock")
    private boolean inStock;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<BookMovementEntity> booksMovement;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Set<AuthorEntity> authors;

    {
        authors = new HashSet<>();
        booksMovement = new HashSet<>();
    }
}
