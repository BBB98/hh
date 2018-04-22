package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Actor;
import kz.kaznitu.lessons.models.Rejisser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RejisserRepository extends CrudRepository<Rejisser, Integer> {
    List<Rejisser> findByname (String name);
}