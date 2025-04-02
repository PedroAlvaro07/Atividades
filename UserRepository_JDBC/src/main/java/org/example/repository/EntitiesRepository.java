package org.example.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EntitiesRepository<T> {
    void save(T user);
    Optional<T> findById(UUID uuid);
    List<T> findAll();
    void deleteById(UUID uuid);
}
