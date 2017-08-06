package id.or.greenlabs.spring.demo.dao;

import java.util.List;

public interface BaseDAO<T> {
    T save(final T entity);

    T delete(final T entity);

    T update(final T entity);

    List<T> find(T param, int offset, int limit);

    T findById(final int id);

    int count(T param);
}
