package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Kino;
import org.springframework.data.repository.CrudRepository;

public interface KinoRepository extends CrudRepository<Kino, Integer> {
}
