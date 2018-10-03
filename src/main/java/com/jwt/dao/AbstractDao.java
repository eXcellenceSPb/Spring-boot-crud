package com.jwt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

abstract class AbstractDao<PK extends Serializable, T> {
    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    AbstractDao() {
        this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @PersistenceContext
    private EntityManager em;

    EntityManager getEm() {
        return this.em;
    }

    T find(PK key) {
        return (T) em.find(persistentClass, key);
    }

    void persist(T entity) {
        em.persist(entity);
    }

    void merge(T entity) {
        em.merge(entity);
    }

    void delete(T entity) {
        em.remove(entity);
    }
}
