package net.vikesh.ssm.dao;

import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Vikesh on 24-Dec-16.
 */
@Repository
public class GenericDao<T, S> implements Dao<T> {

    @Resource
    private EntityManager em;

    @Override
    public <T, S extends Serializable> T findOne(Class<T> clazz, S id) {
        return em.find(clazz, id);
    }

    @Override
    public <T> T update(T item) {
        return em.merge(item);
    }

    @Override
    public <T> void delete(T item) {
        em.remove(item);
    }

    @Override
    public <T> T create(T item) {
        em.persist(item);
        return item;
    }

    /**
     * Does an equals search for the parameters provided
     *
     * @param clazz
     * @param params
     * @param <T>
     * @param <P>
     * @return
     */
    @Override
    public <T, P> List<T> searchByParams(Class<T> clazz, Map<String, P> params) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(clazz);
        TypedQuery<T> typedQuery = em.createQuery(query);
        params.forEach((key, value) -> {
        });
        return typedQuery.getResultList();
    }

    /**
     * Does an equals search but makes sure there is only one result. Use this when searching when uniqueness
     * of attribute is known.
     *
     * @param clazz
     * @param params
     * @param <T>
     * @param <P>
     * @return
     */
    @Override
    public <T, P> T searchOne(Class<T> clazz, Map<String, P> params) {
        List<T> resultList = searchByParams(clazz, params);
        if (resultList != null && !resultList.isEmpty() && resultList.size() > 1) {
            throw new NonUniqueResultException(String.format("Expected one, got %s", resultList.size()));
        }
        return resultList != null && resultList.size() == 1 ? resultList.get(0) : null;
    }
}
