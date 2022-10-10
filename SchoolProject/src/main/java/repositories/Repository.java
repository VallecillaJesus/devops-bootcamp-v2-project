package repositories;

import models.Entity;

import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {
    void save(T object);
    List<T> getAll();
    Optional<T> getByCode(String code);
}
