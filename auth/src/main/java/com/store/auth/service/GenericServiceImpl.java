package com.store.auth.service;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.NoSuchElementException;

public class GenericServiceImpl<T, ID, Repository extends JpaRepository<T, ID>> implements GenericService<T> {
    protected final Repository repository;

    public GenericServiceImpl(Repository repository) { this.repository = repository; }


    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    @Override
    public T get(Long id, String noSuchElementException) {
        return repository.findById((ID) id).orElseThrow(() -> new NoSuchElementException(noSuchElementException));
    }

    @Override
    public void save(T item) {
        repository.save(item);

    }

    @Override
    public void update(T item) {
        repository.save(item);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById((ID) id);
    }
}
