package by.company.library.domain.dbo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {

    @Id
    @Column(name = "Passport_No")
    private String passportNo;
    @Column(name = "Name")
    private String name;
    @Column(name = "Surname")
    private String surname;
    @CreatedDate
    @Column(name = "Birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name = "Role_Id")
    private RoleEntity role;
    @Column(name = "Phone")
    private String phone;
    @Column(name = "Email")
    private String email;
    @Column(name = "Password")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<BookMovementEntity> booksMovement;

    {
        booksMovement = new HashSet<>();
    }
}