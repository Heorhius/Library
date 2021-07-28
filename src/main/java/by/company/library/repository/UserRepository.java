package by.company.library.repository;

import by.company.library.domain.dbo.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, String> {

    UserEntity findByPassportNo(String passportNo);

    Optional<UserEntity> findByNameContaining(String name);

    List<UserEntity> findAllByNameAndSurname(String name, String surname);
}
