package ru.heavyproject.groupfinder.server.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.heavyproject.groupfinder.server.entities.Group;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends CrudRepository<Group,Long> {
    Optional<Group> findById(Long id);
    List<Group> findAll();
    List<Group> findByOwner(String owner);

    void delete(Group group);
}
