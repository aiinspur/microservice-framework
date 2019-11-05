package com.msf.msfmng.service.base;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author shihujiangØØ
 * @date 2019-08-01
 */
public class BaseServiceImpl<R extends JpaRepository<E, Long>, E> implements BaseService<E> {

    protected R repository;


    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E get(Long id) {
        return repository.getOne(id);

    }

    @Override
    public List<E> list(E query) {
        return repository.findAll();
    }

    @Override
    public void saveOrUpt(E entity) {
        repository.save(entity);

    }


    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
