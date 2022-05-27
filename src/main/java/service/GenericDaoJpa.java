package service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class GenericDaoJpa<T> implements GenericDao<T>{
    @PersistenceContext
    private EntityManager em;
    private final Class<T> type;

    public GenericDaoJpa(Class<T> type){
        this.type = type;
    }
    @Override
    @Transactional
    public List<T> findAll() {
        //        return em.createNamedQuery(type.getName()+".findAll", type).getResultList();
        return em.createQuery("select entity from " + type.getName() + " entity", type).getResultList();
    }
    @Override
    @Transactional
    public <U> T get(U id) {
        T entity = em.find(type, id);
        return entity;
    }

    @Override
    @Transactional
    public T update(T object) {
        return em.merge(object);
    }

    @Override
    @Transactional
    public void delete(T object) {
        em.remove(em.merge(object));
    }

    @Override
    @Transactional
    public void insert(T object) {
        em.persist(object);
    }

    @Override
    @Transactional
    public <U> boolean exists(U id) {
        T entity = em.find(type, id);
        return entity != null;
    }
}
