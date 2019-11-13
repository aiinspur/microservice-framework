package com.msf.oauth2.service.base;

import java.util.List;

/**
 *
 * @author shihujiang
 * @date 2019-08-01
 */
public interface BaseService<E> {

    /**
     * get by primary key.
     *
     * @param id primary id.
     * @return Obj.
     */
    E get(Long id);

    /**
     * Get list.
     *
     * @param query conditions
     * @return objects.
     */
    List<E> list(E query);

    /**
     * save entity.
     *
     * @param entity entity
     */
    void saveOrUpt(E entity);

    /**
     * delete .
     *
     * @param id obj id.
     */
    void delete(Long id);
}