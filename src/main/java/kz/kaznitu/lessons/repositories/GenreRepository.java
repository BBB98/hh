package kz.kaznitu.lessons.repositories;

import kz.kaznitu.lessons.models.Actor;
import kz.kaznitu.lessons.models.Genre;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Integer> {
    List<Genre> findByname (String name);
}