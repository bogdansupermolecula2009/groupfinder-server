package ru.heavyproject.groupfinder.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.heavyproject.groupfinder.server.entities.User;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserName(String username);

    Optional<User> findById(Long id);



    void delete (User user);
}
