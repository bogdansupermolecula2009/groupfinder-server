package ru.heavyproject.groupfinder.server.dao;

import org.springframework.data.repository.CrudRepository;
import ru.heavyproject.groupfinder.server.entities.User;

public interface UserRopository extends CrudRepository<User, Long> {
    
}
