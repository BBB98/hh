package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Actor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Integer> {
    List<Actor> findByname (String name);
}
