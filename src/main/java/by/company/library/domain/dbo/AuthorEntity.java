package by.company.library.domain.dbo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @Column(name = "Place_of_birth")
    private String placeOfBirth;
    @CreatedDate
    @Column(name = "Birth_date")
    private Date birthDate;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
            joinColumns = { @JoinColumn(name = "Book_ISBN", referencedColumnName = "ID") },
            inverseJoinColumns = { @JoinColumn(name = "Author_Id", referencedColumnName = "ISBN") })
    Set<BookEntity> books;
}
