package by.company.library.domain.dbo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_movement")
public class BookMovementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "User_Id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "Book_ISBN", nullable = false)
    private BookEntity book;

    @ManyToOne
    @JoinColumn(name = "Bin_Id", nullable = false)
    private BinEntity bin;
    @Column(name = "Quantity")
    private int quantity;
    @CreatedDate
    @Column(name = "Issue_date")
    private Date issueDate;
    @LastModifiedDate
    @Column(name = "Returned_date")
    private Date returnedDate;
    @LastModifiedDate
    @Column(name = "Real_returned_date")
    private Date realReturnedDate;
    @Column(name = "Returned")
    private boolean returned;
    @Column(name = "Expired")
    private boolean expired;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Fine_Id", referencedColumnName = "ID")
    private FineEntity fine;
}
