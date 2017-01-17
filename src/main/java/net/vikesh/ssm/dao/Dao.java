package net.vikesh.ssm.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by Vikesh on 24-Dec-16.
 */
public interface Dao<T> {
    <T, S extends Serializable> T findOne(Class<T> clazz, S id);

    <T> T update(T item);

    <T> void delete(T item);

    <T> T create(T item);

    <T, P> List<T> searchByParams(Class<T> clazz, Map<String, P> params);

    <T, P> T searchOne(Class<T> clazz, Map<String, P> params);
}
